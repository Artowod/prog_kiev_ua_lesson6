package ua.prog.java.lesson6;

import java.math.BigInteger;

public class FindFactorial implements Runnable {
	private int factorialOf = 1;

	public FindFactorial() {

	}

	public FindFactorial(int number) {
		this.factorialOf = number;
	}

	private BigInteger getFactorial() {
		BigInteger factorial = BigInteger.valueOf(1);
		if(factorialOf == 0) {
			return BigInteger.valueOf(0);
		} else {
			for (int i = 1; i <= factorialOf; i++) {
				factorial = BigInteger.valueOf(i).multiply(factorial);
			}
			return factorial;
		}
	}

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + ": " + currentThread.getName().substring(7) + "! = "+ getFactorial());
	}

}
