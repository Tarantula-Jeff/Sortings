/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author: Jeffrey Ackah and Keil Barracliffe
 */
public class Sort {

    public ArrayList<Integer> fillRandom(int n, int bound) {
        Random rng = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(rng.nextInt(bound));
        }
        return list;
    }

    public void bubbleSort(ArrayList<Integer> numbers) {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    // Swap elements
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, temp);

                    sorted = false;
                }
            }
        }
    }

    public void shellSort(ArrayList<Integer> numbers) {
        int gap = numbers.size() / 2;

        while (gap >= 1) {
            for (int i = gap; i < numbers.size(); i++) {
                int temp = numbers.get(i);
                int j = i;
                while (j >= gap && numbers.get(j - gap) > temp) {
                    numbers.set(j, numbers.get(j - gap));
                    j -= gap;
                }
                numbers.set(j, temp);
            }
            gap /= 2;
        }
    }

    public void selectionSort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int min = numbers.get(i);
            int minIndex = i;

            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(j) < min) {
                    min = numbers.get(j);
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = numbers.get(i);
                numbers.set(i, min);
                numbers.set(minIndex, temp);
            }
        }
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> numbers) {
        if (numbers.size() > 1) {
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            int middle = numbers.size() / 2;
            for (int i = 0; i < middle; i++) {
                left.add(numbers.get(i));
            }
            for (int i = middle; i < numbers.size(); i++) {
                right.add(numbers.get(i));
            }

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        } else {
            return numbers;
        }
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> finMerge = new ArrayList<>();
        int i = 0, k = 0;
        while (i < list1.size() && k < list2.size()) {
            if (list1.get(i) < list2.get(k)) {
                finMerge.add(list1.get(i));
                i++;
            } else {
                finMerge.add(list2.get(k));
                k++;
            }
        }
        while (i < list1.size()) {
            finMerge.add(list1.get(i));
            i++;
        }
        while (k < list2.size()) {
            finMerge.add(list2.get(k));
            k++;
        }
        return finMerge;
    }

    public void insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > current) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

    public void heapSort(ArrayList<Integer> list) {
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            heaping(list, list.size(), i);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            heaping(list, i, 0);
        }
    }

    public void heaping(ArrayList<Integer> list, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && list.get(left) > list.get(largest)) {
            largest = left;
        }

        if (right < heapSize && list.get(right) > list.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            heaping(list, heapSize, largest);
        }
    }
}
