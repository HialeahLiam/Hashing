package main.java.com.liam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable {

    private int size;
    private Node[] table;

    public HashTable(){
    }

    public HashTable(int size){
        this.size = size;
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

    // returns key's corresponding value in hash table
    public int lookupValue(String key) throws Exception {
        int index = getBytes(key, 1)[0];
        Node temp = table[index];
        while (temp.key != key && temp != null) temp = temp.next;
        if (temp == null) throw new Exception("Key does not exist");
//        if (temp.next == null) throw new Exception("Key does not exist");
        return temp.value;
    }

    public void insertValue(String key, int value) throws NoSuchAlgorithmException {
        int index = getBytes(key, 1)[0];
        if (table[index] == null) {
            table[index] = new Node(key, value);
        } else {
            Node temp = table[index];
            while (temp.next != null) temp = temp.next;
            temp.next = new Node(key, value);
        }
    }
}
