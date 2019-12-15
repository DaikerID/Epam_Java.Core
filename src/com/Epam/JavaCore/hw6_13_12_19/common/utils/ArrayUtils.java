package com.Epam.JavaCore.hw6_13_12_19.common.utils;

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

    public static void cutArray(Object[] src, Object[] dest) {
        int index = 0;
        for (Object obj : src) {
            if (obj != null) {
                dest[index] = obj;
                index++;
            }
        }
    }

}
