package ua.prog.java.lesson6;

import java.util.ArrayList;
import java.util.List;

public class SumOfArrayElements implements Runnable {
	private int[] countedArray;
	private int sumOfArrayElements;
	private long timeSpent;

	public SumOfArrayElements() {

	}

	public SumOfArrayElements(int[] countedArray) {
		this.countedArray = countedArray;
	}

	public long getTimeSpent() {
		return timeSpent;
	}

	public int getSumOfArrayElements() {
		return sumOfArrayElements;
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

	public int getSumSimpleAlgorytm(int[] countedArray) {
		int arraySum = 0;
		for (int arrayCounter : countedArray) {
			arraySum = arraySum + arrayCounter;
		}
		return arraySum;
	}

	@Override
	public void run() {
		this.sumOfArrayElements = getSumSimpleAlgorytm(countedArray);
	}

}
