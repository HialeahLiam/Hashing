package main.java.com.liam;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 256;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        HashTable hashTable = new HashTable(256);
        int[] firstThreeBytesOfHello = new int[3];
        firstThreeBytesOfHello = hashTable.getBytes("hello",3);
        System.out.println(
                        "firstThreeBytesOfHello = "
                        + firstThreeBytesOfHello[0] + " "
                        + firstThreeBytesOfHello[1] + " "
                        + firstThreeBytesOfHello[2] + " ");

        Scanner in = new Scanner(new FileReader("resources/stream.txt"));
        while (in.hasNext()) {
            hashTable.incrementValue(in.next());
        }


        System.out.println("Frequency of \"the\" :\t" + hashTable.lookupValue("the"));
        System.out.println("Frequency of \"are\" :\t" + hashTable.lookupValue("are"));
        System.out.println("Frequency of \"sydney\" :\t" + hashTable.lookupValue("sydney"));
        System.out.println("Frequency of \"london\" :\t" + hashTable.lookupValue("london"));

    }
}
