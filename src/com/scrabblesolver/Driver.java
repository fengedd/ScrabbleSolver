package com.scrabblesolver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Driver {
    public Driver(String[] args) {
        try{
            main(args);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String localDir = System.getProperty("user.dir");
        File dictionary = new File(localDir+"\\dictionary.txt");
        Scanner sc = new Scanner(dictionary);
        Anagrams anagrams = new Anagrams(sc);

        try {
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Input letter tiles or type 'q' to exit: ");
                String tiles = input.next().toUpperCase();
                if(tiles.equals("Q")) break;
                boolean validInput = tiles.chars().allMatch(Character::isAlphabetic);
                if(!validInput) {
                    System.out.println("Invalid input, try again.");
                } else {
                    HashMap<Integer, List<String>> map = anagrams.getResults(tiles);
                    if(map.isEmpty()) {
                        System.out.println("No result.");
                    } else {
                        map.forEach(
                                (k, v) -> {
                                    System.out.println(k + " Points");
                                    System.out.println(v.toString());
                                });
                    }
                }
            } while(true);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
