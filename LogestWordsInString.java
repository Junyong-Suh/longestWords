// return the longest word or words from a given sentence

import java.util.ArrayList; 

public class LogestWordsInString {
    public static void main(String[] args) {
        String[] result = {};
        
        // should return ["antidisestablishmentarian"]
        result = getLongestWords("You are just an old antidisestablishmentarian");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        
        // should return ["present", "parents"]
        result = getLongestWords("I gave a present to my parents");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        
        // should return ["buffalo"] or ["Buffalo"]
        result = getLongestWords("Buffalo buffalo Buffalo buffalo buffalo buffalo Buffalo buffalo");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }   
    
    public static String[] getLongestWords(String s) {
        ArrayList<String> result = new ArrayList<String>();
    
        if (s.isEmpty()) {
            String[] sResult = new String[result.size()];
            sResult = result.toArray(sResult);
            return sResult;
        }
        
        // split by space
        String[] words = s.split(" ");
        int maxLength = 0;
        
        // loop through the words - O(n) where n is the # of words in the given string
        for (int i = 0; i < words.length; i++) {
            // check the length of each word, if it's the longest length word by far, 
            if (words[i].length() > maxLength) {
                // update the max length
                maxLength = words[i].length();
                
                // clear the result
                result.clear();  
                // put the word into the result as case-insensitive
                result.add(words[i].toLowerCase());
            } else if (words[i].length() == maxLength) {
                // check if the result already has the case-insensitive word
                if (!result.contains(words[i].toLowerCase())) {
                    // if it's not there, put it
                    result.add(words[i].toLowerCase());
                }
            }
        }
                
        // return the result
        String[] sResult = new String[result.size()];
        sResult = result.toArray(sResult);
        return sResult;
    }
}
