package com.tebr.anagrams;
public class Main {
    public static void main(String[] args) {
        String string = "a123b c4d5t6f7";
        Anagramm anagramm = new Anagramm(string);
        System.out.println(string);
        System.out.println(anagramm.reversed());
    }
}
