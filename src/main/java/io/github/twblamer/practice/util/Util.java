package io.github.twblamer.practice.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class Util {
    public static List<Integer> iteratorToList(Iterator<Integer> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false).toList();
    }

    public static int[] reversedCopyOfIntArray(int[] a) {
        return Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[]::new)).reversed().stream()
                .mapToInt(Integer::intValue).toArray();
    }

    public static int[] stringArrayToIntArray(String[] args) {
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] splitStringToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void throwErrorIfNotSorted(int[] a) throws Error {
        if (a.length < 2) {
            return;
        }

        var max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < max) {
                throw new Error("array is out of order");
            }
            max = a[i];
        }
    }

    public static void prettyPrint(BinaryTreeNode root) {
        PrettyPrintImpl.prettyPrint(root);
    }

    public static void visualize(BaseGraph g) {
        VisualizeImpl.visualize(g);
    }
}
