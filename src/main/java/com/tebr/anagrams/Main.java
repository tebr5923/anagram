package com.tebr.anagrams;
public class Main {
    public static void main(String[] args) {
        String string = "a1b2c3d4 iuh!@er e5f6g7 h8i9";
        CachedAnagramm anagramm = new CachedAnagramm(string);
        System.out.println(string);
        System.out.println(anagramm.getAnagramm());
    }
}
