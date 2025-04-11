package org.example;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> numberPair = new Pair<>(56, 44);
        System.out.println("Sum: " + PairUtils.processPair(numberPair));

        Pair<String, String> stringPair = new Pair<>("Hello, ", "world!");
        System.out.println("Concatenation: " + PairUtils.processPair(stringPair));
    }
}