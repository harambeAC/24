package com.alex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Solver {

	public static void main(String[] args) {
		char[] operations = new char[] { '+', '-', '*', '/' };
		Set<Object> allOperations = getPermutations(new char[] { '+', '-', '*', '/' });
		Object[] arr = (Object[]) allOperations.toArray();
		System.out.println(Arrays.deepToString(arr));
	}

	public static String solve(int[] numbers) {
		char[] operations = new char[] { '+', '-', '*', '/' };
		Set<Object> allOperations = getPermutations(new char[] { '+', '-', '*', '/' });

		char[][] arr = (char[][]) allOperations.toArray();

		Set<Object> set = getPermutations(numbers);
		for (Object subset : set) {

			for (int i = 0; i < ((int[]) subset).length; i++) {
				Integer value = operate(((int[]) subset)[i], ((int[]) subset)[i + 1], operations[i]);
			}
		}

		return null;
	}

	public static Integer operate(int a, int b, char operator) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return (a % b == 0 ? a / b : null);
		}
		return null;
	}

	public static Set<Object> getPermutations(int[] numbers) {
		Set<Object> allPermutations = new TreeSet<Object>(new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				if (arg0 instanceof int[] || arg1 instanceof int[]) {
					return Arrays.compare((int[]) arg0, (int[]) arg1);
				} else {
					return Arrays.compare((char[]) arg0, (char[]) arg1);
				}
			}

		});
		listPermutations(numbers, 0, allPermutations);
		return allPermutations;
	}

	public static Set<Object> getPermutations(char[] operations) {
		Set<Object> allPermutations = new TreeSet<Object>(new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				if (arg0 instanceof int[] || arg1 instanceof int[]) {
					return Arrays.compare((int[]) arg0, (int[]) arg1);
				} else {
					return Arrays.compare((char[]) arg0, (char[]) arg1);
				}
			}

		});
		listPermutations(operations, 0, allPermutations);
		return allPermutations;
	}

	private static void listPermutations(int[] numbers, int start, Set<Object> allPermutations) {
		if (start >= numbers.length) {
			allPermutations.add(numbers.clone());
		} else {
			for (int i = start; i < numbers.length; i++) {
				int temp = numbers[i];
				numbers[i] = numbers[start];
				numbers[start] = temp;
				listPermutations(numbers, start + 1, allPermutations);
				temp = numbers[i];
				numbers[i] = numbers[start];
				numbers[start] = temp;
			}
		}
	}

	private static void listPermutations(char[] numbers, int start, Set<Object> allPermutations) {
		if (start >= numbers.length) {
			allPermutations.add(numbers.clone());
		} else {
			for (int i = start; i < numbers.length; i++) {
				char temp = numbers[i];
				numbers[i] = numbers[start];
				numbers[start] = temp;
				listPermutations(numbers, start + 1, allPermutations);
				temp = numbers[i];
				numbers[i] = numbers[start];
				numbers[start] = temp;
			}
		}
	}
}
