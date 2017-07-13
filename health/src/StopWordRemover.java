
package health.classes;


import java.io.*;
import java.util.*;

import health.classes.*;

/**
 * Stop Word Remover
 *
 * Remover class for removing stop words from a ArrayList of String.
 *
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 *
 * @param void 
 * @return void
 *
 * @since 2017-07-12
 *
 */

class StopWordRemover{
    
    private String fileName = "../data/words/stopwords.txt";
    private ArrayList<String> stopWords = new ArrayList<String>();
    
    /**
     * Constuctor
     *
     * StopWordRemover
     *
     * Read list of stop words from a text file and save 
     * it to Arraylist of string with exception handling
     *
     * @param void
     * @return void
     *
     */ 
    StopWordRemover(){ 
        try{ 
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String word = bufferedReader.readLine();word!=null;word=bufferedReader.readLine()){
                
                String[] tokens = word.split(" ");
                Collections.addAll(stopWords, tokens); 
            }

        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    
    /**
     * Function
     *
     * getStopWordsSize
     * Size of StopWords ArrayList
     *
     * @param void
     * @return int  
     *
     */
    int getStopWordsSize(){
        return stopWords.size();
    }

    /**
     * Function
     *
     * getStopWords
     * ArrayList of StopWords
     *
     * @param void
     * @return ArrayList
     *
     */

    ArrayList<String> getStopWords(){
        return stopWords;
    }

    /**
     * Function
     * removeStopWords from given ArrayList of string
     *
     * @param  sample ArrayList of tokens
     * @return result ArrayList with stop words removed
     *
     */
    ArrayList<String> removeStopWords(ArrayList<String> sample){
        
        sample.removeAll(stopWords);
       
        return sample;
    }
}
