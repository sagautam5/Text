package project.classes;

import java.io.*;
import java.util.*;

import project.classes.*;

/**
 * Bayes Classification
 * Probabilistic classification model
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 *
 * @param void
 * @return void
 *
 * @since 2017-07-16
 *
 */

class BayesClassifier{
    
    FrequencyTable table;
    
    private double priorPos = 0.5;
    private double priorNeg = 0.5;

    ArrayList<String> processedTokens;
    
    BayesClassifier(){ 
        table = new FrequencyTable();
    }
    
    void preprocess(String text){
        
        Tokenizer tokenizer = new Tokenizer(text);
        ArrayList<String> tokens = tokenizer.getTokens();

        StopWordRemover stopWordRemover = new StopWordRemover();
        ArrayList<String> result = stopWordRemover.removeStopWords(tokens);

        Porter porter = new Porter();
        for(int i=0; i<result.size(); i++){
            result.set(i,porter.stripAffixes(result.get(i)));
        }
        
        SpellingCorrector corrector = new SpellingCorrector();
        ArrayList<String> finalTokens = corrector.correctSpelling(result);
        
        processedTokens = finalTokens;
    }

    double getPositiveProbability(){
       
        double result = 1;

        for(int i=0;i<processedTokens.size();i++){
            result = result * table.getPositiveProbability(processedTokens.get(i));
        }
       
        return priorPos*result; 
    }

    double getNegativeProbability(){ 
        
        double result  = 1;
        
        for(int i=0;i<processedTokens.size();i++){
            result = result * table.getNegativeProbability(processedTokens.get(i));
        }

        return priorNeg*result; 
    }
}
