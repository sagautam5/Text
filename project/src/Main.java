
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
        Scanner reader = new Scanner(System.in);
        while(true){
            System.out.println("Enter Text: ");
            String text = reader.nextLine();

            BayesClassifier bayesClassifier = new BayesClassifier();
            bayesClassifier.preprocess(text);
        
            double probPos = bayesClassifier.getPositiveProbability();
            double probNeg = bayesClassifier.getNegativeProbability();

            System.out.println("Positive: "+probPos);
            System.out.println("Negative: "+probNeg);

            if(probPos>probNeg){
                System.out.println("Positive");
            }
            else{
                 System.out.println("Negative"); 
            }
        }
        
    }
}
