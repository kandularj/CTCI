package com.package1.arrays;

import java.util.HashMap;
import java.util.Locale;

/**
 * write a function to check if a string is a permutation of a palindrome.
 * */

    // tact coa -> { "taco cat" ,"atco cta"}
    //Solution:
    //for a string to be palindrome the after removing all non-letter characters
    //strings with even length have must have all even counts of characters so that there will be same characters on either side
    //Strings of an odd length must have exactly one character with an odd count so that there will be same characters on either side of the center character
    //ignore special characters and spaces
    //convert the string to lower case so all alphabets are in same case
    //Time Complexity O(n1+n2) -> O(2n1) -> O(n)
    //Space Complexity O(n1)

public class Que4 {
    public boolean isPalindrome(String input){
        //building a frequency table for the characters of the input string
        HashMap<Character, Integer> frequencyTable = new HashMap<>();
        //checking if the input is null
        if(input == null) throw new IllegalArgumentException();
        //converting the input string to lowercase as java is case-sensitive 'a' not same as 'A'
        input = input.toLowerCase(Locale.ROOT);
        //convert string to character array
        //parsing through each character of array and loading it to frequency table
        for(char c : input.toCharArray()){
            //ignore any characters other than alphabets
            if(c < 'a' || c >'z') continue;
            else
                frequencyTable.put(c, frequencyTable.getOrDefault(c, 0)+1);
        }
        int countOdd =0;
        //to check if the number of odd characters are more than 1
        for(int i : frequencyTable.values()){//parsing through each value of frequency table
            if(i % 2 == 1)
                countOdd++;
        }
        System.out.println(frequencyTable);
        return (countOdd <= 1);//if odd number of characters are not zero or one return false
    }
    public static void main(String[] args){
        Que4 q4 = new Que4();
        System.out.println(q4.isPalindrome("ta*tg *oaG offo"));
    }
}
