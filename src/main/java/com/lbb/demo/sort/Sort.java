package com.lbb.demo.sort;

/**
 * @author lbb
 * @date 2021/7/12 10:09 上午
 */
public class Sort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partIndex = partion(arr, left, right);
            quickSort(arr, left, partIndex -1);
            quickSort(arr, partIndex +1 , right);
        }
    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i<=right ; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index - 1 ;
    }

    private static void swap(int[] arr, int i, int pivot) {
        int tmp = arr[i];
        arr[i]= arr[pivot];
        arr[pivot] = tmp;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 2, 34, 4};
        quickSort(arr, 0, 5);
        // 插入排序
//        for (int i=1; i< arr.length; i++) {
//            int preIndex = i -1;
//            int current = arr[i];
//            while(preIndex >=0 && arr[preIndex] > current) {
//                arr[preIndex + 1] = arr[preIndex];
//                preIndex--;
//            }
//            arr[preIndex + 1] = current;
//        }

        // 选择排序
//        for (int i = 0; i< arr.length -1 ; i++) {
//            int minIndex = i;
//            for(int j = i+1; j< arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            int tmp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = tmp;
//        }

        // 冒泡排序
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = 0; j < arr.length -1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
