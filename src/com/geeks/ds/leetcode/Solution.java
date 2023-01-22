package com.geeks.ds.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        String str = "PAYPALISHIRING";
        int numRows = 3;

        String res = convert(str, numRows);

        System.out.println(res);
    }
    public static String convert(String s, int numRows) {

        if(s.length() < numRows || numRows == 1) {
            return s;
        }

        List<List<Character>> rows = new ArrayList<>();
        for(int i = 0 ; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        boolean reverse = false;
        int curRow = 0;

        for(int i = 0 ; i < s.length(); i++) {

            rows.get(curRow).add(s.charAt(i));

            if(!reverse) {
                curRow++;
            }
            else {
                curRow--;
            }

            if(curRow == numRows - 1 || curRow == 0) {
                reverse = !reverse;
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < numRows ; i++) {
            for(int j = 0 ; j < rows.get(i).size() ; j++) {
                result.append(rows.get(i).get(j));
            }
        }

        return result.toString();

    }
}
