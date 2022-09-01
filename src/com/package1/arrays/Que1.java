package com.package1.arrays;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

public class Que1 {
    public boolean isUnique(String input) {

        //there are 256 unique characters
        if (input.length() > 256)
            return false;
        //converting string input to character array
        char[] charArray = input.toCharArray();

        //creating a hashmap to store each character with its frequency value
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        //creating an iterator to traverse through hasmap
        Iterator chIterator = charFrequencyMap.entrySet().iterator();

        //for each character in char array increasing the character frequency by 1
        //if we get 'a' twice frequency will be 2
        for (char ch : charArray) {
            charFrequencyMap.put(ch, (charFrequencyMap.getOrDefault(ch, 0)) + 1);
        }
        //looping through map to check if any character frequency is more than 1 -> not unique
        for(int i : charFrequencyMap.values() ){
            if( i > 1 )
                return false;
        }
        return true;
        //traversing through map to check if any character frequency is more than 1 to determine if the characters are unique
    }
    public static void main(String[] args){
            Que1 q = new Que1();
        System.out.println(q.isUnique("abfg&97^#$@"));

    }

}

