package main.java.com.liam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable {

    private static final int EMPTY = 0;

    private Node[] table;


    public HashTable(){
    }

    public HashTable(int size){
        this.table = new Node[size];
    }

    public int[] getBytes(String key, int byteNumber) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(key.getBytes());
        int[] result = new int[byteNumber];
        for(int i=0; i<byteNumber; i++) {
            result[i] = hash[i] & 0xFF;
        }
        return result;
    }

    public void incrementValue(String key) throws NoSuchAlgorithmException {
        if (lookupValue(key) == EMPTY) insertValue(key,1);
        else {
            int inc = lookupValue(key) + 1;
            insertValue(key,inc);
        }
    }



    // returns key's corresponding value in hash table
    public int lookupValue(String key) throws NoSuchAlgorithmException {
        int index = getBytes(key, 1)[0];
        Node temp = table[index];
        if (temp == null) return EMPTY;
        while (!temp.key.equals(key) && temp.next != null) temp = temp.next;
        if (temp.key.equals(key)) return temp.value;
        else return EMPTY;
    }

    public void insertValue(String key, int value) throws NoSuchAlgorithmException {
        int index = getBytes(key, 1)[0];
        if (table[index] == null) {
            table[index] = new Node(key, value);
        } else {
            Node temp = table[index];
            while (temp.next != null && !temp.key.equals(key)) temp = temp.next;
            if (temp.key.equals(key)) temp.value = value;
            else temp.next = new Node(key, value);
        }
    }
}
