package dev.pawel;

public class Main {
    public static void main(String[] args) {
        String key = "12222";
        int hash = key == null ? 0 : Math.abs(key.hashCode());
        int index = hash % 10;
        System.out.println(index);

    }
}
