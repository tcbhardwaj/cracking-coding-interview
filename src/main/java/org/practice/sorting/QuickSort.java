package org.practice.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{6,8,2,4,15,10, 18, 3, 8, 13};
        quickSort(data, 0, data.length-1);
        Arrays.stream(data).forEach(e -> {
            System.out.print(e + ", ");
        });
    }

    public static void quickSort(int[] data, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = partition(data, low, high);
        quickSort(data, low, mid-1);
        quickSort(data, mid+1, high);

    }

    public static int partition(int[] data, int low, int high) {
        int pivot = data[low];

        int l = low;
        int h = high;
        while(l < h) {

            while( l < h && data[l] <= pivot) {
                l++;
            }
            while(data[h] > pivot) {
                h--;
            }

            if( l < h) {
                swap(data, l, h);
            }
        }
        swap(data, low, h);

        return h;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
