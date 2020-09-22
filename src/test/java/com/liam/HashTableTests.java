package test.java.com.liam;

import main.java.com.liam.HashTable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class HashTableTests {

    HashTable table = new HashTable();
    
    @Test
    void getBytesWithDuke() throws NoSuchAlgorithmException {
        int[] duke = new int[4];
        int[] hash = table.getBytes("Duke", 32);
        assertEquals(79, hash[0]);
        assertEquals(226, hash[1]);
        assertEquals(75, hash[2]);
        assertEquals(168, hash[31]);
    }
    
}
