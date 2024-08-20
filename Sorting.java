/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorting;

import java.util.ArrayList;

/**
 *
 * @author JEFFREY ACKAH AND Keil Barracliffe
 */
  import java.util.ArrayList;

public class Sorting {

    public static void main(String[] args) {
        Sort testing = new Sort();
        for (int i = 10000; i <= 100000; i += 10000) {
            ArrayList<Integer> list = testing.fillRandom(i, 100000);
            long start = System.currentTimeMillis();
            testing.selectionSort(list);
            long end = System.currentTimeMillis();
            System.out.println(i + " values sorted in " + (end - start) + " ms");
        }
    }
}
