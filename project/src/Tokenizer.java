
package project.classes;

import java.util.*;

import project.classes.*;

/**
 * Tokenizer
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 * 
 * Get tokens from given string of sentence or paragraph
 * White space tokenization algorithm
 *
 * @param void
 * @return void
 *
 * @since 2017-07-12
 *
 */
class Tokenizer{

    private ArrayList<String> Tokens = new ArrayList<String>();
    
    /**
     * Constructor
     * Tokenizer
     *
     * White Space Tokenization 
     *
     * @param data -> string of sentence or paragraph
     * @return void 
     *
     */
    Tokenizer(String data){
        String[] words = data.split(" ");
        Collections.addAll(Tokens, words); 
    }

    /**
     * Function
     * getTokens
     *
     * Get ArrayList of Token generated from a sentence or text
     *
     * @param void
     * @return tokens ->  String token ArrayList
     *
     */
    ArrayList<String> getTokens(){
        return Tokens;
    }

    /**
     * Function
     * getTokenSize
     *
     * Get size of Token ArrayList
     *
     * @param void
     * @return size -> size of Token ArrayList
     *
     *
     */
    int getTokenSize(){
        return Tokens.size(); 
    }
}
