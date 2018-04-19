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
		
/*		System.out.println("Домашнее задание, часть 2:");

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
		SumOfArrayElements instanceOfSOAEInThread1 = new SumOfArrayElements(dividedArrayToFour.get(0));
		SumOfArrayElements instanceOfSOAEInThread2 = new SumOfArrayElements(dividedArrayToFour.get(1));
		SumOfArrayElements instanceOfSOAEInThread3 = new SumOfArrayElements(dividedArrayToFour.get(2));
		SumOfArrayElements instanceOfSOAEInThread4 = new SumOfArrayElements(dividedArrayToFour.get(3));
		Thread thread1 = new Thread(instanceOfSOAEInThread1);
		Thread thread2 = new Thread(instanceOfSOAEInThread2);
		Thread thread3 = new Thread(instanceOfSOAEInThread3);
		Thread thread4 = new Thread(instanceOfSOAEInThread4);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		arraySumUsingThreads = instanceOfSOAEInThread1.getSumOfArrayElements()
				+ instanceOfSOAEInThread2.getSumOfArrayElements() 
				+ instanceOfSOAEInThread3.getSumOfArrayElements()
				+ instanceOfSOAEInThread4.getSumOfArrayElements();
		

		long timeSpentCountingSum = System.currentTimeMillis() - startTimeCountingSum;
		System.out.println("Время выполнения подсчёта в четыре потока: " + timeSpentCountingSum + " ms");

		System.out.println("Сумма элементов массива, используя многопоточность: " + arraySumUsingThreads);

		startTime = System.currentTimeMillis();
		int sumSimpleAlgorytm = instanceOfSOAE.getSumSimpleAlgorytm(initialArray);
		timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Сумма элементов массива в один поток: " + sumSimpleAlgorytm);
		System.out.println("Время выполнения подсчёта в один поток: " + timeSpent + "ms");
*/
		
		/* Часть 4 - копирование файлов */
		
/*		System.out.println("Домашнее задание, часть 3:");
		 
		FileOperation operations = new FileOperation();
		int quantityOfThreads = 1;
		operations.copyFiles("C:\\temp\\My USB\\100NCD90", "C:/Java/DestinationFolder",quantityOfThreads);
		System.out.println("Скопировано в " + quantityOfThreads + " потоков.");
*/		 
		
		/* Часть 5 - проверка состояния заданного каталога */	
		FileOperation operations = new FileOperation();
		operations.folderMonitor("C:\\temp\\My USB\\Test");
	}
}
