package main.java.com.liam;

import java.security.NoSuchAlgorithmException;

public class CountMin extends HashTable{

    private int[] table;
    public final int position;
    public int totalTables;

    public CountMin(int size, int position, int totalTables) {
        this.table = new int[size];
        this.position = position;
        this.totalTables = totalTables;
    }

    public void simpleIncrement(String key) throws NoSuchAlgorithmException {
        int index = getBytes(key, totalTables)[position-1];
        table[index]++;
    }

    public int simpleValueLookup(String key) throws NoSuchAlgorithmException {
        int index = getBytes(key, totalTables)[position-1];
        return table[index];
    }

    public void simpleValueInsert(String key, int value) throws NoSuchAlgorithmException {
        int index = getBytes(key, totalTables)[position-1];
        table[index] = value;
    }
}

