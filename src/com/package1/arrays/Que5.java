package com.package1.arrays;

/**
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away
 */

    //Replacement: if length of both strings are same and only one character is different
    //eg: smart -> kmart
    //Insertion: if length of string1 = length of string2 + 1 and a shift at some point in the string
    //eg: apple -> aple
    //Deletion : if length of string1 = length of string2 + 1 and a shift at some point in the string
    //eg: aple -> apple
    //Insertion and Deletion are similar methods but opposite
    //Time complexity : O(n1+n2) = O(n)

public class Que5 {
    public boolean isOneEditAway(String input1 , String input2){
        //if length is same, possibility is a char is replaced
        if(input1.length() == input2.length())
            return oneEditReplace(input1, input2);
        //if first  input length is one more than second, possibility is first input
        //is formed by inserting a character into second input
        else if(input1.length() == (input2.length() +1))
            return oneEditInsert(input1, input2);
        //if first  input length is one less than second, possibility is first input
            // is formed by removing a character from second input
        //or
        //second input is formed by inserting a character into first input
        //so insertion method can be used for this

        else if(input1.length() == (input2.length() -1))
            return oneEditInsert(input2, input1);
        else
            return false;
    }

    //a-a, p-p, p-l, l-l, e-e
    private boolean oneEditInsert(String input1, String input2) {
        int index1 = 0, index2 = 0;
        while(index1 < input1.length() && index2 < input2.length()){
            //comparing characters of each input array
            if(input1.charAt(index1) != input2.charAt(index2))
            {
                //checks if both indexes are same and increases only first index to check remaining characters of the string
                if (index1 != index2) {
                    return false;//returns false when both indexes are not same and character are not same
                }
                index1++;//increasing only first index when both characters are not same
            }
            else
            {
                index1++;
                index2++;
            }

        }
        return true;
    }
    public boolean oneEditReplace(String input1, String input2) {
        int diff = 0;
            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) != input2.charAt(i))
                        diff++;
                    else
                        continue;

            }
            return (diff == 1);
    }

    public static void main(String[] args){
        Que5 q5 = new Que5();
        System.out.println(q5.isOneEditAway("apple", "aple"));
    }
}
