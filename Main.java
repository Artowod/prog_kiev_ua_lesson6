package ua.prog.java.lesson6;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		/* ����� 1 - ����� ���������� */
		/*
		 * System.out.println("�������� �������, ����� 1:");
		 * 
		 * for (int factorialOf = 0; factorialOf <= 100; factorialOf++) { Thread
		 * currentThread = new Thread(new FindFactorial(factorialOf));
		 * currentThread.start(); }
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException ex) {
		 * ex.printStackTrace(); }
		 */

		/* ����� 2 - �������� ����� ��������� ������� ����� ����� */
		System.out.println("�������� �������, ����� 2:");

		long startTime = System.currentTimeMillis();
		int arrayLength = 200000000;
		int[] initialArray = new int[arrayLength];
		for (int arrayElement = 0; arrayElement < arrayLength; arrayElement++) {
			initialArray[arrayElement] = (int) (Math.random() * 1000);
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println(
				"����� ������������� ���������� ������� �� " + arrayLength + " ���������: " + timeSpent + " ms");

		long startTimeDividingArrayToFour = System.currentTimeMillis();
		SumOfArrayElements instanceOfSOAE = new SumOfArrayElements();
		List<int[]> dividedArrayToFour = instanceOfSOAE.divideArrayToFour(initialArray);
		long timeSpentDividingArrayToFour = System.currentTimeMillis() - startTimeDividingArrayToFour;
		System.out.println("����� �������� ������� �� ������: " + timeSpentDividingArrayToFour + " ms");

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
		System.out.println("����� ���������� �������� � ������ ������: " + timeSpentCountingSum + " ms");

		System.out.println("����� ��������� �������, ��������� ���������������: " + arraySumUsingThreads);

		startTime = System.currentTimeMillis();
		int sumSimpleAlgorytm = instanceOfSOAE.getSumSimpleAlgorytm(initialArray);
		timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("����� ��������� ������� � ���� �����: " + sumSimpleAlgorytm);
		System.out.println("����� ���������� �������� � ���� �����: " + timeSpent + "ms");

		/* ����� 3 - ����������� ������ */
		/*
		 * System.out.println("�������� �������, ����� 3:");
		 * 
		 * FileOperation operations = new FileOperation();
		 * operations.copyFiles("C:/Java/SourceFolder", "C:/Java/DestinationFolder");
		 * System.out.println("�����������.");
		 */

	}
}
