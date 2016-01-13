package algorithm;

import test.test;

public class ValidNumber {

	public static boolean isNumber(String s) {
		s = s.trim();
		int n = s.length();
		if (n < 1)
			return false;
		
		int point = -1;
		int points = 0;
		int e = n;
		int es = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '.') {
				point = i;
				points++;
			}
			else if (ch == 'e' || ch == 'E') {
				e = i;
				es++;
			}
		}
		// no '.' and 'e'
		if (point == -1 && e == n) {
			if (s.charAt(0) == '-' || s.charAt(0) == '+') {
				s = s.substring(1);
			}
			return s.length() > 0 && isDigits(s);
		}
		// have '.' no 'e'
		if (point != -1 && e == n && points == 1) {
			String[] t = s.split("\\.");
			if (t.length == 0 || t.length > 2)	// 3. == 1 \\ .3 == 2
				return false;
			if (t.length == 2) {
				if (t[0].length() > 0 && (t[0].charAt(0) == '-' || t[0].charAt(0) == '+')) {
					t[0] = t[0].substring(1);
				}
				if (t[0].length() == 0)
					return isDigits(t[1]);
				if (t[1].length() == 0)
					return isDigits(t[0]);
				return isDigits(t[0]) & isDigits(t[1]);
			}
			if (t.length == 1) {
				if (t[0].length() > 0 && (t[0].charAt(0) == '-' || t[0].charAt(0) == '+')) {
					t[0] = t[0].substring(1);
				}
				return isDigits(t[0]);
			}
		}
		// no '.' have 'e'
		if (point == -1 && e != n && es == 1) {
			String[] t = s.toLowerCase().split("e");
			if (t.length != 2)
				return false;
			if (t[0].length() > 0 && (t[0].charAt(0) == '-' || t[0].charAt(0) == '+')) {
				t[0] = t[0].substring(1);
			}
			if (t[0].length() == 0) {
//				if (t[1].length() > 0 && (t[1].charAt(0) == '-' || t[1].charAt(0) == '+')) {
//					return isDigits(t[1].substring(1));
//				}
//				return isDigits(t[1]);
				return false;
			}
			if (t[1].length() == 0)
				return false;
			if (t[0].length() > 0 && t[0].charAt(0) == '-' || t[0].charAt(0) == '+') {
				t[0] = t[0].substring(1);
			}
			if (t[1].length() > 0 && t[1].charAt(0) == '-' || t[1].charAt(0) == '+') {
				t[1] = t[1].substring(1);
			}
			return t[0].length() > 0 ? isDigits(t[0]) & isDigits(t[1]) : isDigits(t[1]);
		}
		// have '.' and have 'e'
		if (point > -1 && e < n && point < e && points == 1 && es == 1) {
			String[] t1 = s.split("\\.");
			if (t1.length != 2)
				return false;
			String[] t2 = t1[1].split("e");
			if (t2.length != 2)
				return false;
			if (t1[0].length() > 0 && (t1[0].charAt(0) == '-' || t1[0].charAt(0) == '+')) {
				t1[0] = t1[0].substring(1);
			}
			if (t2[1].length() > 0 && (t2[1].charAt(0) == '-' || t2[1].charAt(0) == '+')) {
				t2[1] = t2[1].substring(1);
			}
			if (t1[0].length() > 0)
				return t2[0].length() > 0 ? isDigits(t1[0]) & isDigits(t2[0]) & isDigits(t2[1]) : isDigits(t1[0]) & isDigits(t2[1]);
				
			return isDigits(t2[0]) & isDigits(t2[1]);
		}
		
		
		return false;
	}
	
	private static boolean isDigits(String s) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i); 
			if (ch < '0' || ch > '9')
				return false;
		}
		return s.length() > 0;
	}
	
	public static void main(String[] args) {
		String s1 = "0";		// t
		String s2 = " 0.1 ";	// t
		String s3 = "abc";		// f
		String s4 = "1 a";		// f
		String s5 = "2e10";		// t
		String s6 = "-1.2e-10";	// t
		String s7 = "-.e-10";	// f
		String s8 = "-2e10.0";	// f
		String s9 = "e9";		// f
		String s10 = ".e1"; 	// f
		String s11 = "3.";		// t
		String s12 = "0..";		// f
		String s13 = ".1.";		// f
		String s14 = "7e69e";	// f
		String s15 = "34.e81";	// t
		String[] t = s14.split("e");
		System.out.println(t.length);
		System.out.println(isNumber(s1));
	}
}
