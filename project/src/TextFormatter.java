
package project.classes;

import java.util.*;
import java.io.*;

import project.classes.*;


/**
 * TextFormatter
 *
 * Format text files of training data
 *
 * - Tokenization
 * - stop word removal
 * - porter stemming
 * - spelling correction
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 *
 * @param void
 * @return void
 *
 * @since 2017-07-14
 */
class TextFormatter{

    /**
     * main function
     *
     */
    
    public static void main(String[] args){
        
        // text file containing raw sentence

        String positiveData = "project/data/training/positive/trainPositive.txt";
        String negativeData = "project/data/training/negative/trainNegative.txt";
        
        // text file to store preprocessed data

        String positiveWords = "project/data/training/positive/positiveWords.txt";
        String negativeWords = "project/data/training/negative/negativeWords.txt";

        Process(positiveData,positiveWords);
        Process(negativeData,negativeWords);

    }

    /**
     * 
     * Process - function
     *
     * Tokenize, Remove Stop Words, Porter Stemming, Spelling Correction
     *
     * @param fileName - text file name with raw sentences
     * @param resultFile -  text file to store preprocessed data
     *
     * @return void
     *
     */
  
    public static void Process(String fileName, String resultFile){

        try{
            
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(inputFile);

            FileWriter fileWriter = new FileWriter(resultFile);
            String newLine = System.getProperty("line.separator");
            
            Porter porter = new Porter();
            StopWordRemover stopWordRemover = new StopWordRemover();
            
            SpellingCorrector corrector = new SpellingCorrector();

            
            for(String line = bufferedReader.readLine();line!=null;line = bufferedReader.readLine()){ 
                
                Tokenizer tokenizer = new Tokenizer(line);
                ArrayList<String> tokens = tokenizer.getTokens();
                ArrayList<String> result = stopWordRemover.removeStopWords(tokens);
                
                for(int i=0; i<result.size(); i++){
                    result.set(i,porter.stripAffixes(result.get(i)));
                }

                result = corrector.correctSpelling(result);

                String newRow = String.join(" ",result);
                fileWriter.write(newRow+newLine);
	        }
            fileWriter.close();

        }catch(Exception e){
	        System.out.println("Error: "+e.getMessage());
	    }
        
    }
}
