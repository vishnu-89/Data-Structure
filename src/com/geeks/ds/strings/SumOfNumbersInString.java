package com.geeks.ds.strings;

public class SumOfNumbersInString {

    public static void main(String args[]) {
        String str = "11abcs23";
        System.out.println("Sum of numbers in a string "+sumOfNumbersInAString(str, str.length()));
    }

    public static int sumOfNumbersInAString(String str, int n) {

        String temp = "";
        int finalResult = 0;

        for(int i= 0 ; i < n ; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                temp += ch;
            }
            else {
                finalResult += Integer.parseInt(temp);
                temp = "0";
            }

        }
        return finalResult + Integer.parseInt(temp);
    }
}
