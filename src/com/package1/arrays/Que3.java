package com.package1.arrays;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * */
public class Que3 {

    public void replaceAllSpaces(char[] str, int trueLength) {
        int index = 0, spaceCount = 0, i = 0;
        //parsing through the char array to check spacecount
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        //finding new length for replacing space with %20
        //we need to triple the space count
        //as true length already have space count in it, we only need to double the space count
        index = trueLength + spaceCount * 2;
        //closing the array
        if(trueLength < str.length) str[trueLength] = '\0';
        //parsing char array from end so that ending character can be moved into the extra space at end of char array
        //without the problem of overrriding the content
        //if it is space it will be replaced with 20%
        //else original character is placed
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
    public static void main(String[] args){

        String input = "Mr John Smith    ";
        System.out.println(input.length());
        //Mr%20John20%Smith
        char[] str = input.toCharArray();
        Que3 q3 = new Que3();
        q3.replaceAllSpaces(str,13);

        //printing the modified char array
        for(int i = 0; i<str.length; i++){
            System.out.print(str[i]);
        }
    }
}
