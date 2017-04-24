package com.ade.primesecret;

/**
 * My interpretation and solution to the requirement:
 *		You are given a function 'secret()' that accepts
 *		a single integer parameter and returns an integer.
 *		In your favorite programming language, write a
 *		command-line program that takes one
 *		command-line argument (a number) and
 *		determines if the secret() function is
 *		additive [secret(x+y) = secret(x) + secret(y)],
 *		for all combinations x and y, where x and y are
 *		all prime numbers less than the number passed via
 *		the command-line argument.  Describe how to run
 *		your examples. Please generate the list of
 *		primes without using built-in functionality.
 * 
 * Created on Apr 23, 2017, 3:59:34 PM
 *
 * @author Ade
 *
 */
public class PrimeSecret {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int inputVal = 0;
		PrimeSecret primeSecret = new PrimeSecret();

		if (args.length != 1) {
			PrimeSecret.terminate();
		}

		try {
			inputVal = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			PrimeSecret.terminate();
		}

		boolean processed = primeSecret.process(NumberUtils.getPrimeNumbers(inputVal));
		
		if (processed) {
			System.out.println(inputVal + " is Additive.");
		} else {
			System.out.println(inputVal + " is Not Additive.");
		}
	}

	/**
	 * This method processes our prime numbers and submits pairs
	 * to the secret method for evaluation
	 *
	 * @param inputVal
	 */
	private boolean process(int[] primes) {
		boolean isAdditive = false;

		int summedDuringCall = 0;
		int summedAfterCall = 0;
		
		if (primes.length > 1) {
			for (int i = 0; i < primes.length; i++) {
				for (int j = (i + 1); j < (primes.length); j++) {
					summedDuringCall = secret(primes[i] + primes[j]);
					summedAfterCall = secret(primes[i]) + secret(primes[j]);

					// one false response negates our truth table, no need going further
					isAdditive = summedDuringCall == summedAfterCall;
					if (!isAdditive) {
						return false;
					}
				}
			}
		}

		return isAdditive;
	}

	/**
	 * This is our secret function - what it does is a secret :-)
	 * 
	 * @param value
	 * @return
	 */
	private int secret(int value) {
		// shh - lets do something sort of random and secret
		if ((Math.random() +  (value/300)) < 0.5) {
			return 1;
		}
		return 0;
	}

	/**
	 * Exit the application gracefully
	 *
	 */
	private static void terminate() {
		System.out.println("Error - Bad input parameter value.");
		System.out.println("\nFormat:\t  java PrimeSecret integer");
		System.out.println("\nSample:\t  java PrimeSecret 33");

		System.exit(-9);
	}

	/**
	 * Simple helper method to print out our prime numbers
	 * 
	 * @param numbers
	 */
	private void printNumbers(int[] numbers) {
		StringBuilder sb = (new StringBuilder()).append("Prime numbers: ");
		boolean first = true;

		for (int number : numbers) {
			if (first) {
				sb.append(number);
				first = false;
			} else {
				sb.append(", " + number);
			}
		}

		System.out.println("sb = " + sb);
	}
}
