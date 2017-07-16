
package project.classes;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import project.classes.*;

/**
 * Spelling Corrector
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 * 
 * Correct spelling if word doesn't exist in dictionery
 *
 * @param void
 * @return void
 *
 * @since 2017-07-15
 */
class SpellingCorrector{

    private HashMap<String, Integer> nWords;
    String fileName = "project/data/words/wordlist.txt";
    ArrayList<String> dictionary = new ArrayList<String>();
    
    /**
     * Constructor
     *
     * Read dictionery file
     *
     * @param void
     * @return void
     *
     */
    SpellingCorrector(){
       
        try{

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String line = bufferedReader.readLine(); line!=null; line = bufferedReader.readLine()){
               
               String[] words = line.split(" ");
               Collections.addAll(dictionary,words);
            }
            this.createHashMap(fileName);
        
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

	/**
     *
	 * Builds up a map of correct words with
	 * their frequencies, based on the words in the given file.
	 * 
	 * @param file the text to process
	 * @throws IOException
	 */
	public void createHashMap(String file) throws IOException {
	    nWords = new HashMap<String, Integer>();
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    
	    // This pattern matches any word character (letters or digits)
	    Pattern p = Pattern.compile("\\w+");
	    for(String temp = ""; temp != null; temp = in.readLine()){
	        Matcher m = p.matcher(temp.toLowerCase());
	      
	        // find looks for next match for pattern p (in this case a word).  True if found.
	        // group then returns the last thing matched.
	        // The ? is a conditional expression.
	        while(m.find())    
		        nWords.put((temp = m.group()), nWords.containsKey(temp) ? nWords.get(temp) + 1 : 1);
	    }
	    in.close();
	}

	/**
	 * Constructs a list of all words within edit distance 1 of the given word.
	 * @param word the word to construct the list from
	 * @return a list of words with in edit distance 1 of word
	 */
	private ArrayList<String> edits(String word) {
	    ArrayList<String> result = new ArrayList<String>();
	    
	    // All deletes of a single letter
	    for(int i=0; i < word.length(); ++i) 
	      result.add(word.substring(0, i) + word.substring(i+1));
	    
	    // All swaps of adjacent letters
	    for(int i=0; i < word.length()-1; ++i) 
	      result.add(word.substring(0, i) + word.substring(i+1, i+2) + 
		         word.substring(i, i+1) + word.substring(i+2));
	    
	    // All replacements of a letter
	    for(int i=0; i < word.length(); ++i) 
	      for(char c='a'; c <= 'z'; ++c) 
		    result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i+1));
	    
	    // All insertions of a letter
	    for(int i=0; i <= word.length(); ++i) 
	      for(char c='a'; c <= 'z'; ++c) 
		    result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
	    
	    return result;
	}

	  /**
	   * Corrects the spelling of a word, if it is within edit distance 2.
	   * @param word the word to check/correct
	   * @return word if correct or too far from any word; corrected word otherwise
	   */
	  public String correct(String word) {
	    // If in the dictionary, return it as correctly spelled
	    if(nWords.containsKey(word)) 
	      return word;

	    ArrayList<String> list = edits(word);  // Everything edit distance 1 from word
	    HashMap<Integer, String> candidates = new HashMap<Integer, String>();

	    // Find all things edit distance 1 that are in the dictionary.  Also remember
	    //   their frequency count from nWords.  
	    // (Note if equal frequencies the last one will be the one remembered.)
	    for(String s : list) 
	      if(nWords.containsKey(s)) 
		candidates.put(nWords.get(s),s);

	    // If found something edit distance 1 return the most frequent word
	    if(candidates.size() > 0)   
	      return candidates.get(Collections.max(candidates.keySet()));

	    // Find all things edit distance 1 from everything of edit distance 1.  These
	    // will be all things of edit distance 2 (plus original word).  Remember frequencies
	    for(String s : list) 
	      for(String w : edits(s)) 
		if(nWords.containsKey(w)) 
		  candidates.put(nWords.get(w),w);
	    
	    // If found something edit distance 2 return the most frequent word.
	    // If not return the word with a "?" prepended.  (Original just returned the word.)
	    return candidates.size() > 0 ? 
		candidates.get(Collections.max(candidates.keySet())) : "?" + word;
	}




    /**
     * Function
     * Correct Spelling of single string
     *
     * @param string - String which spelling to be corrected
     * @return string - spelling corrected string
     *
     */

    String correctSpelling(String string){

        WagnerFischer wagnerFischer = new WagnerFischer();
        
        if(dictionary.contains(string)){
            return string;  
        }
        else{
	        return this.correct(string);
        }
    }

    /**
     * Function
     *
     * Correct Spelling of ArrayList of String
     *
     * @param
     */

    ArrayList<String> correctSpelling(ArrayList<String> words){

        ArrayList<String> corrected = new ArrayList<String>();

        for(int i=0; i<words.size(); i++){
	        corrected.add(this.correctSpelling(words.get(i)));
        }

        return corrected;
    }
}
