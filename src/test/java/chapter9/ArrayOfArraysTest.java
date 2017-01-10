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
        print2DArray(ints);


    }

    public void print2DArray(int[][] A) {
        for (int[] anInt : A) {
            if (anInt == null) {
                System.out.println("null");
            } else {
                //System.out.println(ints[0][i]);
                for (int j = 0; j < A[0].length; j++) {
                    System.out.print(anInt[j] + ",");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void createRaddedArrayTriangle() {
        int[][] adskiyTriangle = new int[15][];
        for (int i = 0; i < adskiyTriangle.length; i++) {
            int[] innerArray = new int[(i + 1)];

            Arrays.fill(innerArray, i);
            adskiyTriangle[i] = innerArray;

        }
        System.out.printf("0 element length is %d%n", adskiyTriangle[0].length);
        System.out.printf("5 element length is %d%n", adskiyTriangle[5].length);
        System.out.printf("last element length is %d%n", adskiyTriangle[14].length);
        print2DArray(adskiyTriangle);

    }


}



