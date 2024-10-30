package dev.pawel;

public class Main {
    public static void main(String[] args) {
        MyList<String> stringMyArrayList = new MyArrayList<>(2);
        stringMyArrayList.add(null);
        String s = new String("test");
        stringMyArrayList.add(s);
        System.out.println(stringMyArrayList.contains("test"));
    }
}