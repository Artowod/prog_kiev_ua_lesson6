package ua.prog.java.lesson6;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		/* часть 1 - поиск факториала */
		/*
		 * System.out.println("Домашнее задание, часть 1:");
		 * 
		 * for (int factorialOf = 0; factorialOf <= 100; factorialOf++) { Thread
		 * currentThread = new Thread(new FindFactorial(factorialOf));
		 * currentThread.start(); }
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException ex) {
		 * ex.printStackTrace(); }
		 */

		/* часть 2 - подсчета суммы элементов массива целых чисел */
		System.out.println("Домашнее задание, часть 2:");

		long startTime = System.currentTimeMillis();
		int arrayLength = 200000000;
		int[] initialArray = new int[arrayLength];
		for (int arrayElement = 0; arrayElement < arrayLength; arrayElement++) {
			initialArray[arrayElement] = (int) (Math.random() * 1000);
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println(
				"Время генерирования начального массива из " + arrayLength + " элементов: " + timeSpent + " ms");

		long startTimeDividingArrayToFour = System.currentTimeMillis();
		SumOfArrayElements instanceOfSOAE = new SumOfArrayElements();
		List<int[]> dividedArrayToFour = instanceOfSOAE.divideArrayToFour(initialArray);
		long timeSpentDividingArrayToFour = System.currentTimeMillis() - startTimeDividingArrayToFour;
		System.out.println("Время разбития массива на потоки: " + timeSpentDividingArrayToFour + " ms");

		long startTimeCountingSum = System.currentTimeMillis();
		int arraySumUsingThreads = 0;
		Thread[] arrayOfThreads = new Thread[4];
		int a = 0;
		for (int[] partOfArray : dividedArrayToFour) {
			SumOfArrayElements instanceOfSOAEInThread = new SumOfArrayElements(partOfArray);
			Thread thread = new Thread(instanceOfSOAEInThread);
			arrayOfThreads[a++] = thread;
			thread.start();
			arraySumUsingThreads += instanceOfSOAEInThread.getSumOfArrayElements();
		}
		try {
			arrayOfThreads[0].join();
			arrayOfThreads[1].join();
			arrayOfThreads[2].join();
			arrayOfThreads[3].join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long timeSpentCountingSum = System.currentTimeMillis() - startTimeCountingSum;
		System.out.println("Время выполнения подсчёта в четыре потока: " + timeSpentCountingSum + " ms");

		System.out.println("Сумма элементов массива, используя многопоточность: " + arraySumUsingThreads);

		startTime = System.currentTimeMillis();
		int sumSimpleAlgorytm = instanceOfSOAE.getSumSimpleAlgorytm(initialArray);
		timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Сумма элементов массива в один поток: " + sumSimpleAlgorytm);
		System.out.println("Время выполнения подсчёта в один поток: " + timeSpent + "ms");

		/* Часть 3 - копирование файлов */
		/*
		 * System.out.println("Домашнее задание, часть 3:");
		 * 
		 * FileOperation operations = new FileOperation();
		 * operations.copyFiles("C:/Java/SourceFolder", "C:/Java/DestinationFolder");
		 * System.out.println("Скопировано.");
		 */

	}
}
