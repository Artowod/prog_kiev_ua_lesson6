package ua.prog.java.lesson6;

import java.io.IOException;

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

		int arrayLength = 21;
		int[] initialArray = new int[arrayLength];
		for (int arrayElement = 0; arrayElement < arrayLength; arrayElement++) {
			initialArray[arrayElement] = (int) (Math.random() * 10);
			System.out.print(initialArray[arrayElement] + ", ");
		}
		System.out.println();

		for (int[] partOfArray : instanceOfSOAE.divideArrayToFour(initialArray)) {
			Thread thread = new Thread(new SumOfArrayElements(partOfArray));
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		// Thread firstThread = new Thread(new
		// SumOfArrayElements(SumOfArrayElements.firstPartOfArray));
		// Thread secondThread = new Thread(new SumOfArrayElements(secondPartOfArray));
		// Thread thirdThread = new Thread(new SumOfArrayElements(thirdPartOfArray));
		// Thread fourthThread = new Thread(new SumOfArrayElements(fourthPartOfArray));
		// firstThread.start();
		// secondThread.start();
		// thirdThread.start();
		// fourthThread.start();

		// try {
		// Thread currThread = Thread.currentThread();
		// currThread.sleep(1000);
		// } catch (InterruptedException ex) {
		// ex.getStackTrace();
		// }

		// System.out.println("����� ��������� �������, ��������� ���������������: ");
		System.out.println("-------------------");
		System.out
				.println("����� ��������� ������� � ���� �����: " + instanceOfSOAE.getSumSimpleAlgorytm(initialArray));

	}
}
