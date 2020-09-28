package com.zerf.demo.algorithm;

/**
 * 〈一句话功能简述〉<br>
 * 〈快速排序〉
 *
 * @author Administrator
 * @create 19/6/17/0017
 * @since 1.0.0
 */
public class QuickSort {
    private static void quickSort(int[] numbers, int low, int high) {
        //soutArray(numbers, low, high);
        int l = low;
        int h = high;
        int middleValue = numbers[l];
        if (h - l < 1) {
            return;
        }
        while (l < h) {
            while (l < h) {
                if (numbers[h] <= middleValue) {
                    numbers[l] = numbers[h];
                    l++;
                    System.out.println("h:" + h);
                    soutArray(numbers);
                    break;
                } else {
                    h--;
                }
            }
            while (l < h) {
                if (numbers[l] >= middleValue) {
                    numbers[h] = numbers[l];
                    h--;
                    System.out.println("l:" + l);
                    soutArray(numbers);
                    break;
                } else {
                    l++;
                }
            }
            numbers[l] = middleValue;
        }
        soutArray(numbers);
        if (low < h - 1) {
            quickSort(numbers, low, h - 1);
        }
        if (h + 1 < high) {
            quickSort(numbers, h + 1, high);
        }
    }

    private static void soutArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                arr[l] = arr[h];
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                arr[h] = arr[l];
                h--;
            }
        }
        arr[l] = povit;
        soutArray(arr);
        System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
        if (l - 1 > low) sort(arr, low, l - 1);
        if (h + 1 < high) sort(arr, h + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 1, 8, 4};
        soutArray(array);
        quickSort(array, 0, array.length - 1);
        //sort(array, 0, array.length - 1);
    }
}