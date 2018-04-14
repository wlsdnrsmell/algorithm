/**
 * 
 */
package bfs;

import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 8.
 */
public class No10971 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int[] d = new int[n];
		for(int i=0;i<n;i++) {
			d[i]=i;
		}
		int ans = Integer.MAX_VALUE;
		
		do {
			if(d[0]!=0) break;
			boolean flag = true;
			int sum=0;
			for(int i=0;i<n-1;i++) {
				if(a[d[i]][d[i+1]]==0) flag =false;
				else sum+=a[d[i]][d[i+1]];
			}
			if(flag&&a[d[n-1]][d[0]]!=0) {
				sum+=a[d[n-1]][d[0]];
				if(ans>sum) ans =sum;
			}
		}while(next_permutation(d));
		System.out.println(ans);
	}
	public static boolean next_permutation(int[] a) {
		int i = a.length - 1;
		while(i>0&&a[i]<=a[i-1]) {
			i--;
		}
		if(i<=0) return false;
		int j = a.length -1;
		
		while(a[j]<=a[i-1])
			j--;
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length -1;
		while(j>i) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			j--;
			i++;
		}
		return true;
	}
}