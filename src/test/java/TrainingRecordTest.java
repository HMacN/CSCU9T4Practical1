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
        instance.addEntry(EnumExerciseType.Running, "Claire", "23", "11", "2010", "0", "24", "55", "7", "", "", "9", "20", "");
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
        instance.addEntry(EnumExerciseType.Running, "Claire", "23", "11", "2010", "0", "24", "55", "7", "", "", "9", "20", "");
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


    /**
     * Test of deleteSpecifiedEntry.
     */
    @Test
    public void testDeleteSpecifiedEntry() {
        System.out.println("DeleteSpecifiedEntry");
        TrainingRecord instance = new TrainingRecord();
        String expResult = "No entries found.\n";
        instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", "Easy", "", "", "");
        instance.addEntry(EnumExerciseType.Swimming, "Bob", "1", "2", "2003", "0", "14", "15", "3", "", "", "", "", "Pool");
        instance.addEntry(EnumExerciseType.Running, "Claire", "7", "3", "2010", "0", "26", "20", "7", "", "", "9", "20", "");
        instance.addEntry(EnumExerciseType.Running, "Claire", "23", "11", "2010", "0", "24", "55", "7", "", "", "9", "20", "");

        instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        String result = instance.lookupEntry("1", "2", "2003");
        assertNotEquals(expResult, result, "Expecting not to find the entry.");

        instance.deleteSpecifiedEntry("Bob", "1", "2", "2003");
        result = instance.lookupEntry("1", "2", "2003");
        assertNotEquals(expResult, result, "Expecting not to find the entry.");

        instance.deleteSpecifiedEntry("Claire", "7", "3", "2010");
        result = instance.lookupEntry("7", "3", "2010");
        assertNotEquals(expResult, result, "Expecting not to find the entry.");

        instance.deleteSpecifiedEntry("Claire", "23", "11", "2010");
        result = instance.lookupEntry("23", "11", "2010");
        assertNotEquals(expResult, result, "Expecting not to find the entry.");
    }


    /**
     * Test of Name input.
     */
    @Test
    public void testNameInputs()
    {
        System.out.println("Testing all Name Inputs.");
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Name field.\n";
        expectedResults[1] = "Record added.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Record added.\n";
        expectedResults[14] = "Record added.\n";
        expectedResults[15] = "Record added.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, testString[i], "1", "2", "2003", "0", "16", "7", "3", "", "", "5", "5", "");
            System.out.println("Result " + (i + 1) + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
        }
    }


    /**
     * Test of Day input.
     */
    @Test
    public void testDayInputs()
    {
        System.out.println("Testing all Day Inputs.");
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[2] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[10] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[11] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[12] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Day field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Day field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", testString[i], "2", "2003", "0", "16", "7", "3", "", "", "5", "5", "");
            System.out.println("Result " + (i + 1) + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
        }
    }

    /**
     * Test of Month input.
     */
    @Test
    public void testMonthInputs()
    {
        System.out.println("Testing all Month Inputs.");
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[2] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[6] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[7] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[8] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[9] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[10] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[11] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[12] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Month field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Month field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", testString[i], "2003", "0", "16", "7", "3", "", "", "5", "5", "");
            System.out.println("Result " + (i + 1) + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
        }
    }

    /**
     * Test of Year input.
     */
    @Test
    public void testYearInputs()
    {
        System.out.println("Testing all Year Inputs.");
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Year field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Year field.\n";
        expectedResults[2] = "Please check that you have put a valid entry in the Year field.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Year field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Year field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Year field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", testString[i], "0", "16", "7", "3", "", "", "5", "5", "");
            System.out.println("Result " + (i + 1) + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
        }
    }

    /**
     * Test of Hour input.
     */
    @Test
    public void testHourInputs()
    {
        System.out.println("Testing all Hour Inputs.");
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[8] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[9] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[10] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[11] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[12] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Hour field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Hour field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", testString[i], "16", "7", "3", "", "", "5", "5", "");
            System.out.println("Result " + (i + 1) + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }


    /**
     * Test of Minute input.
     */
    @Test
    public void testMinuteInputs()
    {
        System.out.println("Testing all Minute Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Minute field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Minute field.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Please check that you have put a valid entry in the Minute field.\n";
        expectedResults[12] = "Please check that you have put a valid entry in the Minute field.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Minute field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Minute field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Minute field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", "0", testString[i], "7", "3", "", "", "5", "5", "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }


    /**
     * Test of Second input.
     */
    @Test
    public void testSecondInputs()
    {
        System.out.println("Testing all Second Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Seconds field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Seconds field.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Please check that you have put a valid entry in the Seconds field.\n";
        expectedResults[12] = "Please check that you have put a valid entry in the Seconds field.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Seconds field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Seconds field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Seconds field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", "0", "16", testString[i], "3", "", "", "5", "5", "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }


    /**
     * Test of Distance input.
     */
    @Test
    public void testDistanceInputs()
    {
        System.out.println("Testing all Distance Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Distance field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Distance field.\n";
        expectedResults[2] = "Please check that you have put a valid entry in the Distance field.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Record added.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Distance field.\n";
        expectedResults[15] = "Record added.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", "0", "16", "7", testString[i], "", "", "5", "5", "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }



    /**
     * Test of Cycling Surface input.
     */
    @Test
    public void testCyclingSurfaceInputs()
    {
        System.out.println("Testing all Cycling Surface Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Surface Type field.\n";
        expectedResults[1] = "Record added.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Record added.\n";
        expectedResults[14] = "Record added.\n";
        expectedResults[15] = "Record added.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", testString[i], "Easy", "5", "5", "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }



    /**
     * Test of Cycling Difficulty input.
     */
    @Test
    public void testCyclingDifficultyInputs()
    {
        System.out.println("Testing all Cycling Difficulty Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Route Difficulty field.\n";
        expectedResults[1] = "Record added.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Record added.\n";
        expectedResults[14] = "Record added.\n";
        expectedResults[15] = "Record added.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Cycling, "Alice", "1", "2", "2003", "0", "16", "7", "3", "Track", testString[i], "5", "5", "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }



    /**
     * Test of Sprinting Repetitions input.
     */
    @Test
    public void testSprintingRepetitionsInputs()
    {
        System.out.println("Testing all Sprinting Repetitions Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Repetitions field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Repetitions field.\n";
        expectedResults[2] = "Please check that you have put a valid entry in the Repetitions field.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Repetitions field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Repetitions field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Repetitions field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", "0", "16", "7", "3", "", "", testString[i], "5", "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }


    /**
     * Test of Sprinting Recovery input.
     */
    @Test
    public void testSprintingRecoveryInputs()
    {
        System.out.println("Testing all Sprinting Recovery Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Recovery field.\n";
        expectedResults[1] = "Please check that you have put a valid entry in the Recovery field.\n";
        expectedResults[2] = "Please check that you have put a valid entry in the Recovery field.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Please check that you have put a valid entry in the Recovery field.\n";
        expectedResults[14] = "Please check that you have put a valid entry in the Recovery field.\n";
        expectedResults[15] = "Please check that you have put a valid entry in the Recovery field.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Running, "Alice", "1", "2", "2003", "0", "16", "7", "3", "", "", "5", testString[i], "");
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }


    /**
     * Test of Swimming Location input.
     */
    @Test
    public void testSwimmingLocationInputs()
    {
        System.out.println("Testing all Swimming Location Inputs.");
        //Result Number:        0    1     2    3    4     5     6     7    8      9     10    11    12      13           14                15
        String[] testString = {"", "-1", "0", "1", "12", "13", "23", "24", "31", "32", "59", "60", "3000", "1.01", "PerArduaAdAstra", "123456789012"};
        String actualResults;
        String[] expectedResults = new String[16];
        expectedResults[0] = "Please check that you have put a valid entry in the Location field.\n";
        expectedResults[1] = "Record added.\n";
        expectedResults[2] = "Record added.\n";
        expectedResults[3] = "Record added.\n";
        expectedResults[4] = "Record added.\n";
        expectedResults[5] = "Record added.\n";
        expectedResults[6] = "Record added.\n";
        expectedResults[7] = "Record added.\n";
        expectedResults[8] = "Record added.\n";
        expectedResults[9] = "Record added.\n";
        expectedResults[10] = "Record added.\n";
        expectedResults[11] = "Record added.\n";
        expectedResults[12] = "Record added.\n";
        expectedResults[13] = "Record added.\n";
        expectedResults[14] = "Record added.\n";
        expectedResults[15] = "Record added.\n";

        TrainingRecord instance = new TrainingRecord();

        for (int i = 0; i < 16; i++)
        {
            actualResults = instance.addEntry(EnumExerciseType.Swimming, "Alice", "1", "2", "2003", "0", "16", "7", "3", "", "", "5", "5", testString[i]);
            System.out.println("Result " + i + ": " + actualResults);
            assertEquals(actualResults, expectedResults[i]);
            instance.deleteSpecifiedEntry("Alice", "1", "2", "2003");
        }
    }


}
