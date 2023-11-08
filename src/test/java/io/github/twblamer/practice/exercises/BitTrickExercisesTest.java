package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BitTrickExercisesTest {
    @Test
    public void testClearStartingFromLsb() {
        assertEquals(0b11110000, BitTrickExercises.clearStartingFromLsb(0b11111111, 3));
        assertEquals(0b11111110, BitTrickExercises.clearStartingFromLsb(0b11111111, 0));
        assertEquals(0b00000000, BitTrickExercises.clearStartingFromLsb(0b11111111, 7));
    }

    @Test
    public void testClearStartingFromMsb() {
        assertEquals(0b00000000000, BitTrickExercises.clearStartingFromMsb(0b11111100011, 0));
        assertEquals(0b01111100011, BitTrickExercises.clearStartingFromMsb(0b11111100011, 10));
        assertEquals(0b11111100011, BitTrickExercises.clearStartingFromMsb(0b11111100011, 11));
    }

    @Test
    public void testDivideByTwo() {
        assertEquals(4, BitTrickExercises.divideByTwo(8));
        assertEquals(0, BitTrickExercises.divideByTwo(0));
        assertEquals(-4, BitTrickExercises.divideByTwo(-8));
    }

    @Test
    public void testMultiplyByTwo() {
        assertEquals(16, BitTrickExercises.multiplyByTwo(8));
        assertEquals(0, BitTrickExercises.multiplyByTwo(0));
        assertEquals(-16, BitTrickExercises.multiplyByTwo(-8));
    }

    @Test
    public void testCountSetBits() {
        assertEquals(4, BitTrickExercises.countSetBits(0b10101010));
        assertEquals(0, BitTrickExercises.countSetBits(0));
        assertEquals(32, BitTrickExercises.countSetBits(-1));
    }

    @Test
    public void testLog2() {
        assertEquals(3, BitTrickExercises.log2(8));
        assertEquals(0, BitTrickExercises.log2(1));
        assertEquals(30, BitTrickExercises.log2(Integer.MAX_VALUE));
    }

    @Test
    public void testIsPowerOf2() {
        assertTrue(BitTrickExercises.isPowerOf2(2));
        assertTrue(BitTrickExercises.isPowerOf2(64));
        assertFalse(BitTrickExercises.isPowerOf2(3));
        assertTrue(BitTrickExercises.isPowerOf2(0));
    }

    @Test
    public void testLastSetBit() {
        assertEquals(2, BitTrickExercises.lastSetBit(0b10100));
        assertEquals(3, BitTrickExercises.lastSetBit(0b1000));
        assertEquals(0, BitTrickExercises.lastSetBit(-1));
    }
}