package main.java.com.liam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable {

    private int size;
    private ArrayList<ArrayList> table;

    public HashTable(){
    }

    public HashTable(int size){
        this.size = size;
        table = new ArrayList<>(size);
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

    // returns key's corresponding value in hash table
    public int lookupValue(String key) {

    }

    public void insertValue(String key, int value) {

    }
}
