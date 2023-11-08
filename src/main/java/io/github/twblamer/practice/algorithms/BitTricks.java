package io.github.twblamer.practice.algorithms;

public class BitTricks {
    /**
     * Clears the bits starting from the least significant bit up to and including
     * the i-th bit.
     * 
     * @param num the number to clear bits from
     * @param i   the index of the bit to clear up to (inclusive)
     * @return the resulting number after clearing the bits
     */
    public static int clearStartingFromLsb(int num, int i) {
        var mask = ~((1 << i + 1) - 1);
        return num & mask;
    }

    /**
     * Clears the bits starting from the most significant bit down to and including
     * the i-th bit.
     * 
     * @param num the number to clear bits from
     * @param i   the index of the bit to clear up to (inclusive)
     * @return the resulting number after clearing the bits
     */
    public static int clearStartingFromMsb(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    /**
     * Divides a number by 2 using bit shifting.
     * 
     * @param num the number to divide
     * @return the resulting number after division by 2
     */
    public static int divideByTwo(int num) {
        return num >> 1;
    }

    /**
     * Multiplies a number by 2 using bit shifting.
     * 
     * @param num the number to multiply
     * @return the resulting number after multiplication by 2
     */
    public static int multiplyByTwo(int num) {
        return num << 1;
    }

    /**
     * Counts the number of set bits (bits with value 1) in a number.
     * 
     * @param num the number to count set bits in
     * @return the number of set bits in the number
     */
    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    /**
     * Calculates the logarithm base 2 of a number.
     * 
     * @param num the number to calculate the logarithm of
     * @return the logarithm base 2 of the number
     */
    public static int log2(int num) {
        int res = 0;
        while ((num >>= 1) != 0)
            res++;
        return res;
    }

    /**
     * Checks if a number is a power of 2.
     * 
     * @param num the number to check
     * @return true if the number is a power of 2, false otherwise
     */
    public static boolean isPowerOf2(int num) {
        return (num & (num - 1)) == 0;
    }

    /**
     * Finds the position of the least significant set bit (bit with value 1) in a
     * number.
     * 
     * @param num the number to find the position of the least significant set bit
     *            in
     * @return the position of the least significant set bit in the number
     */
    public static int lastSetBit(int num) {
        if (num == 0) {
            return -1; // No set bit found
        }

        int position = 0; // Assuming positions start at 0 (i.e., rightmost bit is position 0)

        while ((num & 1) == 0) {
            num >>= 1;
            position++;
        }

        return position;
    }
}
