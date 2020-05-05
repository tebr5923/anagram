package com.tebr.anagrams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Anagramm anagramm = new Anagramm("a1b2c3d4 iuh!@er e5f6g7 h8i9");

        System.out.println(anagramm.getAnagramm());
        System.out.println(anagramm.reverse());

    }
}
