package com.wuyu.day10.BasisMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入数字:");
//        String strNum = scan.next();
//        boolean result = isPalindrome(strNum);
//        System.out.println(result);
        generatePalindromes(1000000);
//        isPrime(1000);

    }

    public static Boolean isPalindrome(String str) {
        boolean result = false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                result = true;
            } else {
                return result;
            }
        }
        return result;
    }


    public static int[] generatePrimes(int num) {
        ArrayList<Integer> tempRes = new ArrayList<>();
        int[] array = new int[num];
        for (int i = 2; i < num; i++) {
            array[i] = i;
        }
        for (int i = 2; i < num; i++) {
            if (array[i] != 0) {
                int j, temp;
                temp = array[i];
                for (j = 2 * temp; j < num; j = j + temp) {
                    array[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                count++;
                tempRes.add(array[i]);
            }
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = tempRes.get(i);
        }
        return res;
    }

    public static void generatePalindromes(int n) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int tempCount = 0;
        int count = 0;

        int[] primes = generatePrimes(n);
        int[] tempResult = new int[primes.length];
        for (int i = 0; i < primes.length; i++) {
            String numToStr = "" + primes[i];
            char[] temp = numToStr.toCharArray();
            int start = 0;
            int end = temp.length - 1;
            while (start < end) {
                if (temp[start] == temp[end]) {
                    start++;
                    end--;
                } else {
                    break;
                }
            }
            if (start >= end) {
                tempResult[tempCount] = primes[i];
                tempCount++;
            }
        }

        for (int i = 0; i < tempCount; i++) {
            System.out.println(tempResult[i]);
        }
        System.out.println(tempCount);
    }
}

//        int i = 2;
//        while (i < n) {
//            String numToStr = "" + i;
//            char[] temp = numToStr.toCharArray();
//            int len = temp.length;
//            int start = 0;
//            int end = temp.length - 1;
//            while (start < end) {
//                if (temp[start] == temp[end]) {
//                    start++;
//                    end--;
//                } else {
//                    break;
//                }
//            }
//            if (start >= end) {
//                tempResult[tempCount] = i;
//                tempCount++;
//            }
//            i++;
//        }
//
//        System.out.println(count);
//        for (int k = 0; k < count; k++) {
//            System.out.println(result.get(k));
//        }
//    }



