package ua.prog.java.lesson6;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		/* ����� 1 - ����� ���������� */
		/*
		 * for (int factorialOf = 0; factorialOf <= 100; factorialOf++) { Thread
		 * currentThread = new Thread(new FindFactorial(factorialOf));
		 * currentThread.start(); }
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException ex) {
		 * ex.printStackTrace(); }
		 */

		/* ����� 2 - �������� ����� ��������� ������� ����� ����� */

		SumOfArrayElements instanceOfSOAE = new SumOfArrayElements();
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
		List<int[]> dividedArrayToFour = instanceOfSOAE.divideArrayToFour(initialArray);
		long timeSpentDividingArrayToFour = System.currentTimeMillis() - startTimeDividingArrayToFour;
		System.out.println("����� �������� ������� �� ������: " + timeSpentDividingArrayToFour + " ms");

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
		System.out.println("����� ���������� �������� � ������ ������: " + timeSpentCountingSum + " ms");

		System.out.println("����� ��������� �������, ��������� ���������������: " + arraySumUsingThreads);

		startTime = System.currentTimeMillis();
		int sumSimpleAlgorytm = instanceOfSOAE.getSumSimpleAlgorytm(initialArray);
		timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("����� ��������� ������� � ���� �����: " + sumSimpleAlgorytm);
		System.out.println("����� ���������� �������� � ���� �����: " + timeSpent + "ms");
	}
}
