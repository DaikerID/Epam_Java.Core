package com.Epam.JavaCore.hw8_18_12_19.common.solutions.utils;

import java.util.List;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    public static void copyArray(Object[] src, Object[] dest) {
        System.arraycopy(src, 0, dest, 0, src.length);
    }

    public static void printArray(Object[] arr) {
        for (Object obj : arr) {
            if (obj != null) {
                System.out.println(obj);
            }
        }
    }

    public static void removeElement(Object[] arr, int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
    }

    public static boolean updateElement(Object[] arr, Object updateElement) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(updateElement)) {
                arr[i] = updateElement;
                return true;
            }
        }
        return false;
    }
}