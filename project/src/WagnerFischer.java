package project.classes;

import project.classes.*;


/**
 * WagnerFischer 
 *
 * Wagner Fischer Minimum Edit Distance algorithm
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
class WagnerFischer{
    
    /**
     *
     * Function getLevensthteinDistance
     *
     * Get Minimum edit distance between two string variables
     *
     * @param first -> distance calculated for string
     * @param seocond -> distance calculated with string
     *
     * @return distance
     *
     */
    
    public int getLevenshteinDistance(String first, String second){
        
        int lenFirst,lenSecond;

		lenFirst = first.length();
		lenSecond = second.length();

		int[][] data = new int[lenFirst + 1][lenSecond + 1];

		for (int i = 0; i <= lenFirst; i++)
            
            data[i][0] = i;
		    for (int i = 1; i <= lenSecond; i++)
		    
                data[0][i] = i;
		        for (int i = 1; i <= lenFirst; i++){
            
                    for (int j = 1; j <= lenSecond; j++){
                        int m = (first.charAt(i - 1) == second.charAt(j - 1)) ? 0:1;                        
		                data[i][j] = Math.min(Math.min(data[i - 1][j] + 1, data[i][j - 1] + 1), data[i - 1][j - 1] + m);
		            }
		        }
    	return data[lenFirst][lenSecond];
    }
}
