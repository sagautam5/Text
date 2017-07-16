package project.classes;

import java.io.*;
import java.util.*;

import project.classes.*;

/**
 * Count
 *
 * @author sagar sagautam5@gmail.com
 * @version 1.0
 *
 * String count in each class;
 * 
 * @param void
 * @return void
 *
 * @since 2017-07-16 
 * 
 */

class Count{

    int countInPos;
    int countInNeg;
    
    /**
     * Default Constructor
     *
     * Empty values initialization
     *
     * @param void
     * @return void
     */
    Count(){

        countInPos = 0;
        countInNeg = 0;
    }

    /**
     * Constructor
     *
     * String value and zero counts
     *
     * @param String -- Word
     * @return void
     *
     */
    Count(int countPos, int countNeg){

        countInPos = countPos;
        countInNeg = countNeg;
    }

    /**
     * Set word count in Positive class
     *
     * @param Integer -- count
     * @return void
     *
     */
    void setPosCount(int count){
        countInPos = count;
    }

    /**
     * Set word count in Negative class
     *
     * @param Integer -- count
     * @return void
     *
     */
    void setNegCount(int count){
        countInNeg = count;
    }

    /**
     * Get word count in Positive class
     *
     * @param void
     * @return Integer -- count
     *
     */
    int getPosCount(){
        return countInPos;
    }
    
    /**
     * Get word count in Negative class
     *
     * @param void
     * @return Integer -- count
     *
     */
    int getNegCount(){
        return countInNeg;
    }

    /**
     *
     * Increment Positive count
     *
     * @param void
     * @return void
     *
     */
    void addPositive(){
        countInPos++;
    }
    /**
     *
     * Increment Negative count
     *
     * @param void
     * @return void
     *
     */
    void addNegative(){
        countInNeg++;
    }
}
