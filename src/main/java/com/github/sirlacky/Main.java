package com.github.sirlacky;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wpisz tekst: ");
        String oryginal = scan.nextLine();

        //String oryginal = "ala ma kota, kot koduje w Javie kota";
        String lowerCasesNoPunct = oryginal.toLowerCase().replaceAll("\\p{Punct}", "");

        Set<String> noDoubleSet = new TreeSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(lowerCasesNoPunct, " ");

        while (stringTokenizer.hasMoreTokens()) {
            String str = stringTokenizer.nextToken();
            noDoubleSet.add(str);
        }



        Iterator<String> iterator = noDoubleSet.iterator();
        Map<Character, Set<String>> firstMap = new HashMap<>();

        while (iterator.hasNext()) {
            String word = iterator.next();
            char[] wordChar = word.toCharArray();

            for (char c : wordChar) {

                Set<String> tempSet = firstMap.get(c);

                if (tempSet == null) {
                    Set<String> wordsSet = new TreeSet<>();
                    wordsSet.add(word);
                    firstMap.put(c, wordsSet);
                } else {
                    tempSet.add(word);
                }
            }
        }

        firstMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString().replaceAll("[\\[\\],]", "")
            );
        });
    }
}