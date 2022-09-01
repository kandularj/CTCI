package com.package1.arrays;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3.
 */

public class Que6 {
    public String compressedString(String input) {
        //using string builder because we can modify string using it
        StringBuilder compressed = new StringBuilder();
        int countCompress = 0;
        for (int i = 0; i < input.length(); i++) {
            //increasing until character changes
            countCompress++;
            // If next character is different than current, append this char to result
            //reset count
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(countCompress);
                countCompress = 0;
            }
        }
        //if length if compressed string is less than original length return compressed string
        //or else return original string as mentioned in question
        if(compressed.length() < input.length())
            return compressed.toString();
        else
            return input;

    }
    public static void main(String[] args){
        Que6 q6 = new Que6();
        String output = q6.compressedString("aabcccccaaa");
        System.out.println(output);
    }
}
