package com.scrabblesolver;

import java.util.*;

class Anagrams {

    private final static int MIN_WORD_LENGTH = 2;
    private static final List<Integer> letterScoreTable = Arrays.asList(1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10);
    private static HashMap<String, List<String>> lookupTable;

    public Anagrams(Scanner sc) {
        lookupTable = new HashMap<>();
        loadLookupTable(sc);
    }

    private static void loadLookupTable(Scanner sc) {
        while(sc.hasNextLine()) {
            String curr = sc.nextLine();
            String key = getKey(curr);
            if(!lookupTable.containsKey(key)) {
                List<String> entry = new ArrayList<>();
                entry.add(curr);
                lookupTable.put(key, entry);
            } else {
                lookupTable.get(key).add(curr);
            }
        }
    }

    private HashMap<String, List<String>> getLookupTable() {
        return lookupTable;
    }

    public HashMap<Integer, List<String>> getResults(String s) {
        HashSet<String> set = new HashSet<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        getResultsHelper(getKey(s), set, map);
        return map;
    }

    private void getResultsHelper(String key, HashSet<String> set, HashMap<Integer, List<String>> map) {
        if(key.length() < MIN_WORD_LENGTH) {
            return;
        }
        if(set.contains(key)) {
            return;
        }

        set.add(key);
        int score = wordScore(key);
        if(getLookupTable().containsKey(key)) {
            if(!map.containsKey(score)) {
                List<String> entry = new ArrayList<>(getLookupTable().get(key));
                map.put(score, entry);
            } else {
                map.get(score).addAll(getLookupTable().get(key));
            }
        }

        for(int i = 0; i < key.length(); ++i) {
            StringBuilder sb = new StringBuilder(key);
            if(i+1 < sb.length()) {
                if(sb.charAt(i) == sb.charAt(i+1)) {
                    continue;
                }
            }
            sb.deleteCharAt(i);
            getResultsHelper(sb.toString(), set, map);
        }
    }

    private static String getKey(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    private static int wordScore(String s) {
        int wordScore = 0;
        for(int i = 0; i < s.length(); ++i) {
            char letter = s.charAt(i);
            int letterScore = letterScoreTable.get(letter-'A');
            wordScore += letterScore;
        }
        return wordScore;
    }
}
