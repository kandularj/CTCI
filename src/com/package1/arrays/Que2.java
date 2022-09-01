package com.package1.arrays;

import java.util.HashMap;

/**
Given two strings, write a method to decide if one is a permutation of the
        other.

 */
//abcd -> dcab, adcb, bcda, so on
//both strings should have same length
//each character of first string must be in second string
//we are building frequency map for first string and subtracting frequency of each character while parsing through characters of second string
//Time complexity ->  O(n1 + n1) -> O(2n1) -> O(n1)
//Space complexity -> O(n1)
public class Que2 {
    public boolean isAPermutation(String input1, String input2){

        if(input1 == null && input2 == null)
            return true;
        if(input1 == null || input2 == null)
            return false;

        //checking if both the lengths of strings are same
        if(input1.length() != input2.length())
            return false;

        //creating a hashmap for storing each character with its frequency
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        //traversing through each character in array and storing it to hashmap
        for( char ch : input1.toCharArray()){
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) +1);
            System.out.println(ch);
        }

        //traversing through each character in array and reducing the frequency
        //if frequency is negative that means character is not present in input1
        for( char ch : input2.toCharArray()){
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) -1);
        }

        //checking if the values of each character are zero or not
        for(int i : frequencyMap.values()){
            if(i > 0 || i < 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){

        String input1 = "abcd";
        String input2 = "abdc";
        Que2 q2 = new Que2();
        System.out.println(q2.isAPermutation(input1, input2));
    }
}
