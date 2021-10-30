import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class P1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc=new FastReader();
		int t = sc.nextInt();
		StringBuilder st = new StringBuilder();
		while (t-- != 0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int max=Math.max(a, Math.max(b, c));
			// int flag=0;
			// if(a==max) flag++;
			// if(b==max) flag++;
			// if(c==max) flag++;
			// if(flag==1) {
			// 	if(a==max) {
			// 		st.append("0 ");
			// 	}else {
			// 		st.append(max-a+1+" ");
			// 	}
			// 	if(b==max) {
			// 		st.append("0 ");
			// 	}else {
			// 		st.append(max-b+1+" ");
			// 	}
			// 	if(c==max) {
			// 		st.append("0 ");
			// 	}else {
			// 		st.append(max-c+1+" ");
			// 	}
			// }else {
			// 	if(a==max) {
			// 		st.append(1+" ");
			// 	}else {
			// 		st.append(max-a+1+" ");
			// 	}
			// 	if(b==max) {
			// 		st.append(1+" ");
			// 	}else {
			// 		st.append(max-b+1+" ");
			// 	}
			// 	if(c==max) {
			// 		st.append(1+" ");
			// 	}else {
			// 		st.append(max-c+1+" ");
			// 	}
			// }
			st.append("\n");
		}
		System.out.println(st);
	}
 
	static FastReader sc = new FastReader();
 
	public static void solvegraph() {
		int n = sc.nextInt();
 
		int edge[][] = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			edge[i][0] = sc.nextInt() - 1;
			edge[i][1] = sc.nextInt() - 1;
		}
		ArrayList<ArrayList<Integer>> ad = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ad.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n - 1; i++) {
			ad.get(edge[i][0]).add(edge[i][1]);
			ad.get(edge[i][1]).add(edge[i][0]);
		}
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		parent[0] = n;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		int child[] = new int[n];
		Arrays.fill(child, 0);
		ArrayList<Integer> lv = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int toget = queue.getFirst();
			queue.removeFirst();
			child[toget] = ad.get(toget).size() - 1;
			for (int i = 0; i < ad.get(toget).size(); i++) {
				if (parent[ad.get(toget).get(i)] == -1) {
					parent[ad.get(toget).get(i)] = toget;
					queue.addLast(ad.get(toget).get(i));
				}
			}
			lv.add(toget);
		}
 
		child[0]++;
	}
 
	static void sort(int[] A) {
		int n = A.length;
		Random rnd = new Random();
		for (int i = 0; i < n; ++i) {
			int tmp = A[i];
			int randomPos = i + rnd.nextInt(n - i);
			A[i] = A[randomPos];
			A[randomPos] = tmp;
		}
		Arrays.sort(A);
	}
 
	static void sort(long[] A) {
		int n = A.length;
		Random rnd = new Random();
		for (int i = 0; i < n; ++i) {
			long tmp = A[i];
			int randomPos = i + rnd.nextInt(n - i);
			A[i] = A[randomPos];
			A[randomPos] = tmp;
		}
		Arrays.sort(A);
	}
 
	static String sort(String s) {
		Character ch[] = new Character[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ch[i] = s.charAt(i);
		}
		Arrays.sort(ch);
		StringBuffer st = new StringBuffer("");
		for (int i = 0; i < s.length(); i++) {
			st.append(ch[i]);
		}
		return st.toString();
	}
 
	public static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
 
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}