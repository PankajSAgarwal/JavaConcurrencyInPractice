package math;

import java.math.*;
import java.util.*;

/**
 * DO NOT CHANGE.
 */
public class Factorizer {
    /**
     * This is a super slow way of factorizing numbers.
     *
     * @param number
     * @return
     */
    public static BigInteger[] factor(BigInteger number) {
        if (number.compareTo(new BigInteger(Long.toString(Long.MAX_VALUE))) < 0) {
            return convertToLongs(number);
        }
        Collection<BigInteger> factors = new ArrayList<>();
        for (BigInteger factor = new BigInteger("2");
             factor.compareTo(number) <= 0; factor = factor.add(BigInteger.ONE)) {
            while (number.remainder(factor).equals(BigInteger.ZERO)) {
                factors.add(factor);
                number = number.divide(factor);
            }
        }
        return factors.toArray(new BigInteger[factors.size()]);
    }

    private static BigInteger[] convertToLongs(BigInteger number) {
        long numberAsLong = Long.parseLong(number.toString());
        long[] factors = factor(numberAsLong);
        BigInteger[] result = new BigInteger[factors.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new BigInteger(Long.toString(factors[i]));
        }
        return result;
    }

    public static long[] factor(long number) {
        Collection<Long> factors = new ArrayList<Long>();
        for (long factor = 2; factor <= number; factor++) {
            while (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            }
        }
        long[] result = new long[factors.size()];
        int pos = 0;
        for (Long factor : factors) {
            result[pos++] = factor;
        }
        return result;
    }
}