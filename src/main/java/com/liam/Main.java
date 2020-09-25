package main.java.com.liam;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 256;
    public static final int r = 5;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        HashTable hashTable = new HashTable(256);
        CountMin[] countMins = new CountMin[r];
        countMins[0] = new CountMin(SIZE,1,r);
        countMins[1] = new CountMin(SIZE,2,r);
        countMins[2] = new CountMin(SIZE,3,r);
        countMins[3] = new CountMin(SIZE,4,r);
        countMins[4] = new CountMin(SIZE,5,r);


        int[] firstThreeBytesOfHello = new int[3];
        firstThreeBytesOfHello = hashTable.getBytes("hello",3);
        System.out.println(
                        "firstThreeBytesOfHello = "
                        + firstThreeBytesOfHello[0] + " "
                        + firstThreeBytesOfHello[1] + " "
                        + firstThreeBytesOfHello[2] + " ");

        Scanner in = new Scanner(new FileReader("resources/stream.txt"));
        while (in.hasNext()) {
            String s = in.next();
            hashTable.incrementValue(s);
            for (CountMin r : countMins) r.simpleIncrement(s);
        }


        System.out.println("Frequency of \"the\" :\t" + hashTable.lookupValue("the"));
        System.out.println("Frequency of \"are\" :\t" + hashTable.lookupValue("are"));
        System.out.println("Frequency of \"sydney\" :\t" + hashTable.lookupValue("sydney"));
        System.out.println("Frequency of \"london\" :\t" + hashTable.lookupValue("london"));


        String key = "paris";
        int minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"paris\":\t" + minValue);

        key = "her";
        minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"her\":\t" + minValue);

        key = "well";
        minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"well\":\t" + minValue);

        key = "the";
        minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"the\":\t" + minValue);

        key = "are";
        minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"are\":\t" + minValue);

        key = "sydney";
        minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"sydney\":\t" + minValue);

        key = "london";
        minValue = countMins[0].simpleValueLookup(key);
        for (CountMin r : countMins) {
            if (r.simpleValueLookup(key) < minValue) minValue= r.simpleValueLookup(key);
        }

        System.out.println("CMS estimate for \"london\":\t" + minValue);



    }
}
