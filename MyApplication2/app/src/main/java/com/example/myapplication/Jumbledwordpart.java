package com.example.myapplication;

import java.util.Random;

public class Jumbledwordpart {
    public static final Random R = new Random();
    public static final String[] Words = {"book","ironic","irregardless","colonel","abscond","advocate",
    "affluent","pen","original","conventional","innovative","orthodox","cognizant","dance", "bring",
            "brother", "budget", "build", "building", "business","career","carry","case", "catch",
   " cause", "cell","center","central ","century" , "certain","certainly", "chair","difficult","dinner"," direction","director","discover" ,"discuss" ,"discussion"," disease"};

    public static String randomword() {
        return Words[R.nextInt(Words.length)];
    }

    public static String shuffleword(String w) {
        if (w != null && !"".equals(w)) {
            char a[] = w.toCharArray();

            for (int i = 0; i < a.length; i++) {
                int j = R.nextInt(a.length);
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }
            return new String(a);
        }
        return w;

    }
}