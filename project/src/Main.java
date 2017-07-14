
package project.classes;

import java.util.*;

import project.classes.*;

/**
 * Main Class for testing purpose of Tokenization/StopWord Removal/
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 *
 * Get String Text and Pass to Tokenizer and Word Remover
 *
 * @param void
 * @return void
 *
 * @since 2017-07-14
 *
 */

class Main{
    public static void main(String[] args){
        String string = new String("#MCFC are working hard to sign French prodigy Kylian Mbappe this summer, according to Graham Hunter - Read here");

        Tokenizer tokenizer = new Tokenizer(string);
        ArrayList<String> tokens = tokenizer.getTokens();

        System.out.println("Tokens with white space tokenization");
        for(int i=0; i<tokens.size(); i++){
            System.out.println(tokens.get(i));
        }  
        
        StopWordRemover stopWordRemover = new StopWordRemover();
        ArrayList<String> result = stopWordRemover.removeStopWords(tokens);
        
        System.out.println("News after stop word removal");
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
        
        Porter porter = new Porter();
        for(int i=0; i<result.size(); i++){
            result.set(i,porter.stripAffixes(result.get(i)));
        }
         
        System.out.println("News after stop word removal");
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
