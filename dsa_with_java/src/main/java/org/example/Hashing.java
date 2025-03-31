package org.example;

import java.util.HashMap;
import java.util.Map;

public class Hashing {
    //Count the number of occurrences of a number in integer array
    // Make a hash array , index should be the element from arr and value should be count of that element
    // O(N)
    public static int countNumber(int[] arr , int target){
        int[] hashArr = new int[12];
        for(int i=0;i< arr.length;i++){
            hashArr[arr[i]]++;
        }
        return hashArr[target];
    }

    // Storing in map { best to avg } O(1)
    //Fetching from map { worst } O(N)
    public static int countNumberUsingMap(int[] arr , int target){
        Map<Integer,Integer> numberMap = new HashMap<>();
        for(int i=0;i< arr.length;i++){
           if(numberMap.containsKey(arr[i])){
               numberMap.put(arr[i] , numberMap.get(arr[i]) + 1);
           }else{
               numberMap.put(arr[i],1);
           }
        }
        return numberMap.get(target);
    }

    //Count the number of occurrences of a character in a string
    // Store them in a similar hash array
    // 'a' should go to index 0 , b to 1 , c to 2 etc.
    // use ASCII for the same , eg. ascii of 'a' is 97 , therefor 'a' to be stored at position 0 i.e. 'a' - 'a'
    // ch - 'a'
    public static int countLetter(String myString , char target){
        char[] charArr = myString.toCharArray();
        int[] hashArr = new int[26];
        for(int i=0 ; i< charArr.length ; i++){
            int hashIndex = charArr[i] - 'a';
            hashArr[hashIndex] ++;
        }
        return hashArr[target - 'a'];
    }
    // Count occurrence of any character
    public static int countAnyChar(String myString , char target){
        char[] charArr = myString.toCharArray();
        int[] hashArr = new int[256]; // ASCII has 256 characters
        for(int i=0 ; i< charArr.length ; i++){
            hashArr[charArr[i]] ++;
        }
        return hashArr[target];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,4,2,2,2};
        System.out.println(countNumber(arr,2)); //Gives answer 4
        System.out.println(countNumberUsingMap(arr,2));
        String str = "hrishi";
        System.out.println(countLetter(str,'h'));
        String str2 = "hrishi--";
        System.out.println(countAnyChar(str2,'-'));
    }
}

