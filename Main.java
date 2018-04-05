package ua.prog.java.lesson6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		/* часть 1 - поиск факториала */
		/*
		 * for (int factorialOf = 0; factorialOf <= 100; factorialOf++) { Thread
		 * currentThread = new Thread(new FindFactorial(factorialOf));
		 * currentThread.start(); }
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException ex) {
		 * ex.printStackTrace(); }
		 */

		/* часть 2 - подсчета суммы элементов массива целых чисел */

		SumOfArrayElements instanceOfSOAE = new SumOfArrayElements();
		long startTime = System.currentTimeMillis();
		int arrayLength = 200000000;
		int[] initialArray = new int[arrayLength];
		for (int arrayElement = 0; arrayElement < arrayLength; arrayElement++) {
			initialArray[arrayElement] = (int) (Math.random() * 1000);
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Время генерирования начального массива из " + arrayLength + " элементов: "  + timeSpent+ " ms");
		
		long startTimeDividingArrayToFour = System.currentTimeMillis();
		List<int[]> dividedArrayToFour = instanceOfSOAE.divideArrayToFour(initialArray);
		long timeSpentDividingArrayToFour = System.currentTimeMillis() - startTimeDividingArrayToFour;
		System.out.println("Время разбития массива на потоки: "  + timeSpentDividingArrayToFour+ " ms");

		long startTimeCountingSum = System.currentTimeMillis();
		int arraySumUsingThreads = 0;
		for (int[] partOfArray : dividedArrayToFour) {
			SumOfArrayElements ss = new SumOfArrayElements(partOfArray);
			Thread thread = new Thread(ss);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			arraySumUsingThreads += ss.getSumOfArrayElements();
		}
		long timeSpentCountingSum = System.currentTimeMillis() - startTimeCountingSum;
		System.out.println("Время выполнения подсчёта в четыре потока: "  + timeSpentCountingSum + " ms");

		System.out.println("Сумма элементов массива, используя многопоточность: " + arraySumUsingThreads);
		
		startTime = System.currentTimeMillis();
		int sumSimpleAlgorytm = instanceOfSOAE.getSumSimpleAlgorytm(initialArray); 
		timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Сумма элементов массива в один поток: " + sumSimpleAlgorytm);
		System.out.println("Время выполнения подсчёта в один поток: " + timeSpent+ "ms");
	}
}
