package test.java.com.liam;

import main.java.com.liam.HashTable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.com.liam.Node;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class HashTableTests {

    public static final int SIZE = 256;

    HashTable table = new HashTable(SIZE);
    
    @Test
    void getBytesWithDuke() throws NoSuchAlgorithmException {
        int[] duke = new int[4];
        int[] hash = table.getBytes("Duke", 32);
        assertEquals(79, hash[0]);
        assertEquals(226, hash[1]);
        assertEquals(75, hash[2]);
        assertEquals(168, hash[31]);
    }

    @Test
    void insertValueAndLookupValueNoChaining() throws Exception {
        table.insertValue("Duke", 4);
        assertEquals(4, table.lookupValue("Duke"));
    }

    @Test
    void lookupNonExistantKey() throws NoSuchAlgorithmException {
        assertEquals(0,table.lookupValue("d"));
    }

    @Test
    void incrementValue() throws NoSuchAlgorithmException {
        table.incrementValue("Duke");
        assertEquals(1, table.lookupValue("Duke"));

        table.insertValue("Duke",4);
        table.incrementValue("Duke");
        assertEquals(5, table.lookupValue("Duke"));

    }

    
}
