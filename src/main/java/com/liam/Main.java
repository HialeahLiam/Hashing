package main.java.com.liam;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        HashTable hashTable = new HashTable();
        int[] firstThreeBytesOfHello = new int[3];
        firstThreeBytesOfHello = hashTable.getBytes("hello",3);
        System.out.println(
                        "firstThreeBytesOfHello = "
                        + firstThreeBytesOfHello[0] + " "
                        + firstThreeBytesOfHello[1] + " "
                        + firstThreeBytesOfHello[2] + " ");
    }
}
