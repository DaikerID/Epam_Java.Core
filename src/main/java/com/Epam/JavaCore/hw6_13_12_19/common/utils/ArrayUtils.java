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

    public static Object[] excludeNullableElems(Object[] src, int size) {
        Object[] newMass = new Object[size];
        int index = 0;
        for (Object obj : src) {
            if (obj != null) {
                newMass[index] = obj;
                index++;
            }
        }
        return newMass;
    }

    public static Object[] cutArrayWithout(Object[] src, int iter) {
        Object[] newSrc = new Object[src.length];
        int newIter = 0;
        for (int i = 0; i < src.length; i++) {
            if (i != iter) {
                newSrc[newIter] = src[i];
                newIter++;
            }
        }
        return newSrc;
    }

}
