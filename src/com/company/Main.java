package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {2, 1, 4, 7, 2, 1};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                break;
            }
        }
    }
}
