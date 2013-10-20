package com.soebes.training.maven.simple;



/**
 * Maven Unit Integration Test Guide
 *
 * @author Karl Heinz Marbaise
 *
 */
public class BitMask2 {

    private long bitMaskValue;

    public long getBitMaskValue() {
        return bitMaskValue;
    }

    public BitMask2() {
        bitMaskValue = 0;
    }

    public BitMask2(long currentValue) {
        this.bitMaskValue = currentValue;
    }

    public void setBit(int bit) {
        long bitMask = Long.rotateLeft(1, bit);
        bitMaskValue |= bitMask;
    }

    public void unsetBit(int bit) {
        long bitMask = Long.rotateLeft(1, bit);
        bitMaskValue ^= bitMask;
    }

    public boolean isBitSet(int bit) {
        long bitMask = Long.rotateLeft(1, bit);
        long result = this.bitMaskValue & bitMask;
        if (result != 0) {
            return true;
        }
        return false;
    }
}
