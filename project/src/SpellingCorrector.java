
package project.classes;

import java.io.*;
import java.util.*;

import project.classes.*;

class SpellingCorrector{

    String fileName = "project/data/words/wordlist.txt";
    ArrayList<String> dictionary = new ArrayList<String>();
    
    SpellingCorrector(){
       
        try{

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String line = bufferedReader.readLine(); line!=null; line = bufferedReader.readLine()){
               
               String[] words = line.split(" ");
               Collections.addAll(dictionary,words);
            }
        
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    String correctSpelling(String string){
       return string; 
    }

    ArrayList<String> correctSpelling(ArrayList<String> words){

        ArrayList<String> corrected = new ArrayList<String>();

        for(int i=0; i<words.size(); i++){
            WagnerFischer wagnerFischer = new WagnerFischer();
        }

        return corrected;
    }
}
