package com.masai;

import java.util.Scanner;

public class Diagonal {

	void sumOfDiagonal(int[][] arr, int n) {

		int left = 0;
		int i = 0;
		int j = 0;
		while (i < n && j < n) {
			left += arr[i][j];
			i++;
			j++;
		}

		int right = 0;
		int k = 0;
		int l = n - 1;
		while(k<n && l>=0) {
			right += arr[k][l];
			k++;
			l--;
		}
		

		System.out.println(left - right);

	}

	public static void main(String[] args) {
		Diagonal d = new Diagonal();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size of the matrix:");
		int n = sc.nextInt();
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		d.sumOfDiagonal(mat, n);
	}

}
