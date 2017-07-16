package project.classes;

import java.io.*;
import java.util.*;

import project.classes.*;

/**
 * Frequency Table
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 *
 * Each different word frequency in text file
 *
 * @param text file name
 * @return void
 *
 * @since 2017-07-16
 */
class FrequencyTable{

    int totalNegWords;
    int totalPosWords;

    String filePositive = "project/data/training/positive/positiveWords.txt";
    String fileNegative = "project/data/training/negative/negativeWords.txt";
    
    HashMap<String, Count> dataTable = new HashMap<String, Count>();
    
    /**
     *
     * Constuctor
     *
     * Creating frequency table from training data
     *
     * @param void
     * @return void
     *
     */
    FrequencyTable(){
        this.readPositiveTrainingData(filePositive);
        this.readNegativeTrainingData(fileNegative);
    }

    /**
     *
     * Creating Frequency Table of Positive data
     *
     * @param String -- filename of positive data
     * @return void
     *
     */

    void readPositiveTrainingData(String fileName){
        totalPosWords = 0;
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String line = bufferedReader.readLine(); line!=null; line = bufferedReader.readLine()){
                String[] tokens = line.split(" ");
                
                for(String token :tokens){ 
                    
                    totalPosWords++;

                    if(dataTable.containsKey(token)){ 
                    
                        Count exist = dataTable.get(token);
                        Count update = new Count(exist.getPosCount()+1,exist.getNegCount());
                        dataTable.put(token,update);
                    
                    }else{
                        Count count = new Count(1,0);
                        dataTable.put(token,count);
                    }
                }

            }
            System.out.println(totalPosWords);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }


    /**
     *
     * Creating Frequency Table of Positive data
     *
     * @param String -- filename of positive data
     * @return void
     *
     */
    void readNegativeTrainingData(String fileName){
        totalNegWords = 0;
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String line = bufferedReader.readLine(); line!=null; line = bufferedReader.readLine()){
                String[] tokens = line.split(" ");
                
                for(String token :tokens){
                    
                    totalNegWords++;
                    
                    if(dataTable.containsKey(token)){
                    
                        Count exist = dataTable.get(token);
                        Count update = new Count(exist.getPosCount(),exist.getNegCount()+1);
                        dataTable.put(token,update);
                    
                    }else{
                        Count count = new Count(0,1);
                        dataTable.put(token,count);
                    }
                }

            }
            System.out.println(totalNegWords);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    /*void display(){
        System.out.println("word count in Hash Map");
        System.out.println("---------------------------------------");
        for (Map.Entry<String, Count> entry : dataTable.entrySet())
        {
            System.out.println(entry.getKey() + ": \t" + entry.getValue().getPosCount()+" \t"+entry.getValue().getNegCount());
        }
    }*/

    double getPositiveProbability(String token){
        
        int wordCount = 0;

        if(dataTable.containsKey(token)){
            wordCount = dataTable.get(token).getPosCount();
        }

        wordCount = wordCount+1;
        
        return (double)wordCount/(totalPosWords+dataTable.size());
    }

    double getNegativeProbability(String token){
        
        int wordCount = 0;

        if(dataTable.containsKey(token)){
            wordCount = dataTable.get(token).getNegCount();
        }

        wordCount = wordCount+1;
        
        return (double)wordCount/(totalNegWords+dataTable.size());
     
    }

}
