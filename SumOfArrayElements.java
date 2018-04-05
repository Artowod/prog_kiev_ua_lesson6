package ua.prog.java.lesson6;

import java.util.ArrayList;
import java.util.List;

public class SumOfArrayElements implements Runnable {
	private int[] initialArray;
	private int sumOfArrayElements;

	public SumOfArrayElements() {

	}

	public SumOfArrayElements(int[] initialArray) {
		this.initialArray = initialArray;
	}

	public int getSumOfArrayElements() {
		return sumOfArrayElements;
	}

	private void showArray(int[] array) {
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public List<int[]> divideArrayToFour(int[] initialArray) {

		List<int[]> dividedArrays = new ArrayList<int[]>();
		int quarterOfArrayLength = initialArray.length / 4;

		int[] firstPartOfArray = new int[quarterOfArrayLength];
		System.arraycopy(initialArray, 0, firstPartOfArray, 0, quarterOfArrayLength);
		dividedArrays.add(firstPartOfArray);
		int[] secondPartOfArray = new int[quarterOfArrayLength];
		System.arraycopy(initialArray, quarterOfArrayLength, secondPartOfArray, 0, quarterOfArrayLength);
		dividedArrays.add(secondPartOfArray);
		int[] thirdPartOfArray = new int[quarterOfArrayLength];
		System.arraycopy(initialArray, 2 * quarterOfArrayLength, thirdPartOfArray, 0, quarterOfArrayLength);
		dividedArrays.add(thirdPartOfArray);
		int lastQuarterOfArrayLength = 0;
		if (initialArray.length % 4 == 0) {
			lastQuarterOfArrayLength = initialArray.length / 4;
		} else {
			lastQuarterOfArrayLength = initialArray.length / 4 + initialArray.length % 4;
		}
		int[] fourthPartOfArray = new int[lastQuarterOfArrayLength];
		System.arraycopy(initialArray, 3 * quarterOfArrayLength, fourthPartOfArray, 0, lastQuarterOfArrayLength);
		dividedArrays.add(fourthPartOfArray);
		return dividedArrays;
	}

	public int getSumSimpleAlgorytm(int[] initialArray) {
		int arraySum = 0;
		for (int arrayCounter : initialArray) {
			arraySum = arraySum + arrayCounter;
		}
		return arraySum;
	}

	@Override
	public void run() {
		System.out.println("-------------------");
		showArray(initialArray);
		this.sumOfArrayElements = getSumSimpleAlgorytm(initialArray);
		System.out.println("Sum = " + sumOfArrayElements);
	}

}
