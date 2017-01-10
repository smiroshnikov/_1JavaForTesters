package chapter9;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArrayOfArraysTest {
    @Test
    public void arraySorting() {
        String[] workdays = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};
        Arrays.sort(workdays);
        for (String day : workdays) {
            System.out.printf("%s%n", day);
            // sort by ascii value lowercase is smaller than uppercase
        }
    }

    @Test
    public void arrayOfArrays() {
        int[][] multi = new int[2][2];
        Arrays.fill(multi[0], -1);
        assertEquals(multi.length, 2);
        int[][] ints;
        ints = new int[][]
                {
                        {1, 2, 3, 4, 5},
                        {11, 22, 33, 44, 55},
                        {111, 222, 333, 444, 555}};
        print2DIntArray(ints);


    }

    public void print2DIntArray(int[][] multi) {
        for (int[] outer : multi) {
            if (outer == null) {
                System.out.print("null");
            } else {
                for (int inner : outer) {
                    System.out.print(inner + ",");
                }
            }
            System.out.println(" ");
        }
    }

    @Test
    public void createRaddedArrayTriangle() {
        int[][] triangularArray = new int[16][];
        for (int i = 0; i < triangularArray.length; i++) {

            // define length of each rugged array
            int[] innerArray = new int[(i + 1)];

            for (int j = 0; j < innerArray.length; j++) {
                innerArray[j] = j; // not so hard !
            }
            triangularArray[i] = innerArray;
        }
        print2DIntArray(triangularArray);
    }
}



