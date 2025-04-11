package org.example;

public class PairUtils {
    public static <T, U> String processPair(Pair<T, U> pair) {
        T first = pair.getFirst();
        U second = pair.getSecond();

        if (first instanceof Number && second instanceof Number) {
            double sum = ((Number) first).doubleValue() + ((Number) second).doubleValue();
            return String.valueOf(sum);
        } else if (first instanceof String && second instanceof String) {
            return (String) first + (String) second;
        } else {
            throw new IllegalArgumentException("Unsupported types: " + first.getClass().getSimpleName() + " and " + second.getClass().getSimpleName());
        }
    }
}


