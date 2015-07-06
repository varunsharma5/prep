package com.interview.algorithms.primitive.conversions;

/**
 * It looks complex, debug and you will get to know.
 * 
 * @author ajitkoti
 * 
 */
public class ConvertFloatToString {

	private static String convertFloatToString(float num) {
		char[] fstr = new char[80];
		int m = (int) Math.floor(Math.log10(num));
		int digit;
		int count = 0;
		double precision = 0.0000001;

		while (num > 0 + precision || (m >= 0)) {
			float weight = (float) Math.pow(10.0, m);
			digit = (int) Math.floor(num / weight);
			num -= (digit * weight);
			fstr[count++] = (char) ('0' + digit);
			if (m == 0)
				fstr[count++] = '.';
			m--;
		}
		fstr[count++] = '\0';
		return new String(fstr);
	}

	public static void main(String[] args) {
		System.out.println(convertFloatToString(2.55f));

	}

}
