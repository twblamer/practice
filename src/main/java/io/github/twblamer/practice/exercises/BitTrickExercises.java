package io.github.twblamer.practice.exercises;

import io.github.twblamer.practice.algorithms.BitTricks;

/**
 * @see BitTrickExercisesTest
 */
public class BitTrickExercises {
    //
    // Start here
    //
    public static int clearStartingFromLsb(int num, int i) {
        return BitTricks.clearStartingFromLsb(num, i);
    }

    public static int clearStartingFromMsb(int num, int i) {
        return BitTricks.clearStartingFromMsb(num, i);
    }

    public static int divideByTwo(int num) {
        return BitTricks.divideByTwo(num);
    }

    public static int multiplyByTwo(int num) {
        return BitTricks.multiplyByTwo(num);
    }

    public static int countSetBits(int num) {
        return BitTricks.countSetBits(num);
    }

    public static int log2(int num) {
        return BitTricks.log2(num);
    }

    public static boolean isPowerOf2(int num) {
        return BitTricks.isPowerOf2(num);
    }

    public static int lastSetBit(int num) {
        return BitTricks.lastSetBit(num);
    }
}
