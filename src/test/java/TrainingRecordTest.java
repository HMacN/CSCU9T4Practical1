/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package java.com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author saemundur
 */
public class TrainingRecordTest {
    public TrainingRecordTest() {
    }
    
//    @BeforeAll
//    public void setUpClass() {
//    }
//
//    @AfterAll
//    public void tearDownClass() {
//    }
//
//    @BeforeEach
//    public void setUp() {
//    }
//
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of addEntry method, of class TrainingRecord.
     * You might want to extend this test when you implement the other
     * Entry types
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", "Easy", "", "", "");
        assertEquals(instance.getNumberOfEntries(),1);
    }
    
    /**
     * Test of addEntry with a repeat
     * Adding another entry for the same person on the same day should fail
     */
    @Test
    public void testAddEntryUnique() {
        System.out.println("addEntry -- fail");
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", "Easy", "", "", "");
        instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", "Easy", "", "", "");
        assertEquals(instance.getNumberOfEntries(),1);
        // You might also consider using assertThrows() and let
        // TrainingRecord instance take care of when you're trying to add
        // a none-unique entry
    }

    /**
     * Test of lookupEntry method, of class TrainingRecord.
     */
    @Test
    public void testLookupEntry() {
        System.out.println("lookupEntry");
        TrainingRecord instance = new TrainingRecord();
        String expResult = "No entries found.";
        instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", "Easy", "", "", "");
        instance.addEntry(EnumExerciseType.Swimming, "Bob", "1", "2", "2003", "0", "14", "15", "3", "", "", "", "", "Pool");
        instance.addEntry(EnumExerciseType.Running, "Claire", "7", "3", "2010", "0", "26", "20", "7", "", "", "9", "20", "");
        instance.addEntry(EnumExerciseType.Running, "Claire", "11", "23", "2010", "0", "24", "55", "7", "", "", "9", "20", "");
        String d = "7";
        String m = "3";
        String y = "2010";
        String result = instance.lookupEntry(d, m, y);
        assertNotEquals(expResult, result, "expecting to find the entry");
        result = instance.lookupEntry("1", "2", "1999");
        assertEquals(expResult, result, "expecting to not find the entry");
    }
    
    /**
     * Test of getNumberOfEntries, of class TrainingRecord
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("GetNumberOfEntries");
        TrainingRecord instance = new TrainingRecord();

        assertEquals(instance.getNumberOfEntries(),0);
        instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", "Easy", "", "", "");
        assertEquals(instance.getNumberOfEntries(),1);
        instance.addEntry(EnumExerciseType.Swimming, "Bob", "1", "2", "2003", "0", "14", "15", "3", "", "", "", "", "Pool");
        assertEquals(instance.getNumberOfEntries(),2);
        instance.addEntry(EnumExerciseType.Running, "Claire", "7", "3", "2010", "0", "26", "20", "7", "", "", "9", "20", "");
        assertEquals(instance.getNumberOfEntries(),3);
        instance.addEntry(EnumExerciseType.Running, "Claire", "11", "23", "2010", "0", "24", "55", "7", "", "", "9", "20", "");
        assertEquals(instance.getNumberOfEntries(),4);
    }
    
    /**
     * Test of yet to be implemented lookupEntries, of class TrainingRecord
     * Implement the method and then remove the "fail" line below and
     * un-comment call to the method and the assertion line
     */
    @Test
    public void testLookupEntries() {
        System.out.println("lookupEntries");
        String expectResultsNone = "No entries found.";
        String expectResults = "Alice sprinted 5x3000m in 0:16:7 with 5 minutes recovery on 1/2/2003.\n" +
                                "Bob swam 3.0km outdoors in 0:14:15 on 1/2/2003.\n";
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", "0", "16", "7", "3", "", "", "5", "5", "");
        instance.addEntry(EnumExerciseType.Swimming, "Bob", "1", "2", "2003", "0", "14", "15", "3", "", "", "", "", "outdoors");
       //fail("This method cannot be tested as it does not exist yet");
        String d = "1";
        String m = "2";
        String y = "2003";
        // un-comment the lines below when you've implemented the method
        String resultSuccess = instance.findAllByDate(d,m,y);
        String resultNone = instance.findAllByDate(d,m,"1999");
        assertEquals(expectResultsNone,resultNone);
        assertEquals(expectResults,resultSuccess);
    }
    
}
