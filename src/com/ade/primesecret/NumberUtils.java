package com.ade.primesecret;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides static number utilities
 *
 * Created on Apr 23, 2017, 4:01:06 PM
 *
 * @author Ade
 *
 *
 */
public final class NumberUtils {

	/**
	 * This method returns an array consisting of prime numbers less than or equal to the upperLimit parameter
	 *
	 * @param upperLimit
	 * @return
	 */
	public static final int[] getPrimeNumbers(int upperLimit) {
		List<Integer> primes = new ArrayList<>();

		if (upperLimit < 2) {
			return (new int[] {0});	// placeholder for array lenght check
		}

		for (int i = 2; i < upperLimit; i++) {
			if (prime(i)) {
				primes.add(i);
			}
		}

		// java 8 format - need to research further overhead for this operation
		return primes.stream().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * This method determines if a number is a prime number
	 *
	 * @param value
	 * @return
	 */
	public static boolean prime(int value) {
		for (int i = 2; i < value; i++) {
			if ((value % i) == 0) {
				return false;
			}
		}
		
		return true;
	}

}
