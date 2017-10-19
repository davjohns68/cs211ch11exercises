/*
 * Chapter 11 exercises: 6, 7, 8, 13, 15
 * Created by David Johnson, October 8, 2017
 * for CS211 course, Bellevue College
 */
package cs211ch11exercises;

import java.util.*;

public class Cs211ch11exercises {

    public static void main(String[] args) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        List<Integer> testListI = new ArrayList<>();
        // Build an array of Strings
        String[] arrayS = {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia"};
        List<String> testListS = new ArrayList<>();
        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);
        Set<String> testSetS = new TreeSet<>(testListS);
        Set<String> testSetS2 = new TreeSet<>();
        // Exercise 11.8
        System.out.println(testSetS2);
        System.out.println("maxLength="+maxLength(testSetS2));
        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<>();
        String[] array2 = {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        // Exercise 11.13System.out.println(testMapSS);
        System.out.println("isUnique="+isUnique(testMapSS));
        
        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        numbers1.add(3);
        numbers1.add(7);
        numbers1.add(3);
        numbers1.add(-1);
        numbers1.add(2);
        numbers1.add(3);
        numbers1.add(7);
        numbers1.add(2);
        numbers1.add(15);
        numbers1.add(15);
        
        numbers2.add(-5);
        numbers2.add(15);
        numbers2.add(2);
        numbers2.add(-1);
        numbers2.add(7);
        numbers2.add(15);
        numbers2.add(36);
        
        System.out.println(countUnique(numbers1));
        System.out.println(countUnique(numbers2));
        System.out.println(countCommon(numbers1, numbers2));
        System.out.println(maxOccurrences(numbers2));
    }
    
    // Exercise 6
    // Returns the number of unique integer values in the list
    public static int countUnique(List<Integer> numbers) {
        Set<Integer> uniqueSet = new HashSet<>();
        
        // Set automatically only retains unique elements
        for(int number: numbers) {
            uniqueSet.add(number);
        }
        return uniqueSet.size();
    }
    
    // Exercise 7
    // Returns the number of unique integers that occur in both lists
    public static int countCommon(List<Integer> nums1, List<Integer> nums2) {
        // Create a new Set based on the first list
        Set<Integer> uniqueUnion = new HashSet<>(nums1);
        
        // Keep all items in the Set that are in both lists
        uniqueUnion.retainAll(nums2);
        return uniqueUnion.size();
    }
    
    // Exercise 8
    // Returns the length of the longest string in the list
    public static int maxLength(Set<String> strings) {
        Iterator<String> itr = strings.iterator();
        int longest = 0;
        
        while(itr.hasNext()) {
            String current = itr.next();
            if(current.length() > longest) {
                longest = current.length();
            }
        }
        return longest;
    }
    
    // Exercise 13
    // Returns true if no two keys map to the same value (false if two or more keys do)
    public static boolean isUnique(Map<String, String> strings) {
        List<String> valuesL = new ArrayList<>();
        for(String string: strings.values()) {
            valuesL.add(string);
        }
        Set<String> valuesS = new HashSet<>(valuesL);
        return valuesL.size() == valuesS.size();
    }
    
    // Exercise 15
    // Returns the number of times the most frequently occurring integer (the mode) occurs in the list
    public static int maxOccurrences(List<Integer> numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int mostFrequentCount = 0;
        
        for(int number: numbers) {
            if(frequencyMap.containsKey(number)) {
                int counter = frequencyMap.get(number);
                frequencyMap.put(number, counter + 1);
            } else {
                frequencyMap.put(number, 1);
            }
        }
        
        for(int number: frequencyMap.keySet()) {
            if(frequencyMap.get(number) > mostFrequentCount) {
                mostFrequentCount = frequencyMap.get(number);
            }
        }
        return mostFrequentCount;
    }
    
}
