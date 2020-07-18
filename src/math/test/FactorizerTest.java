package math.test;

import math.*;
import org.junit.*;

import java.math.*;
import java.util.*;

import static org.junit.Assert.*;

/**
 * DO NOT CHANGE.
 */
public class FactorizerTest {
    @Test
    public void testIntPrimeFactoring() {
        check(2, 2, 11);
        check(2);
        check(3);
        check(7, 11);
        check(101);
        check(127);
    }

    @Test
    public void testLargeNumberPrimeFactoring() {
        check(173, 739, 967, 4_870_693);
        check(7, 29, 631, 809, 14_481_869);
        check(223, 647, 10651, 30_735_589);
    }

    @Test
    public void testIntLargeNumberPrimeFactoring() {
        check(Integer.MAX_VALUE);
    }

    private void check(int... nums) {
        BigInteger number = BigInteger.ONE;
        for (int i : nums) {
            number = number.multiply(new BigInteger(Long.toString(i)));
        }
        BigInteger[] result = Factorizer.factor(number);
        assertTrue(Arrays.equals(makeBigIntegerArray(nums), result));
    }

    private BigInteger[] makeBigIntegerArray(int... nums) {
        BigInteger[] result = new BigInteger[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BigInteger(Integer.toString(nums[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        util.UnitTestRunner.run();
    }
}
