package com.interview.algorithm.string;

public class LongestCommonSubstring {
	//	public int LongestCommonSubstring(string str1, string str2, out string sequence)
	//	{
	//		sequence = string.Empty;
	//		if (String.IsNullOrEmpty(str1) || String.IsNullOrEmpty(str2))
	//			return 0;
	//	 
	//		int[,] num = new int[str1.Length, str2.Length];
	//		int maxlen = 0;
	//		int lastSubsBegin = 0;
	//		StringBuilder sequenceBuilder = new StringBuilder();
	//	 
	//		for (int i = 0; i < str1.Length; i++)
	//		{
	//			for (int j = 0; j < str2.Length; j++)
	//			{
	//				if (str1[i] != str2[j])
	//					num[i, j] = 0;
	//				else
	//				{
	//					if ((i == 0) || (j == 0))
	//						num[i, j] = 1;
	//					else
	//						num[i, j] = 1 + num[i - 1, j - 1];
	//	 
	//					if (num[i, j] > maxlen)
	//					{
	//						maxlen = num[i, j];
	//						int thisSubsBegin = i - num[i, j] + 1;
	//						if (lastSubsBegin == thisSubsBegin)
	//						{//if the current LCS is the same as the last time this block ran
	//							sequenceBuilder.Append(str1[i]);
	//						}
	//						else //this block resets the string builder if a different LCS is found
	//						{
	//							lastSubsBegin = thisSubsBegin;
	//							sequenceBuilder.Length = 0; //clear it
	//							sequenceBuilder.Append(str1.Substring(lastSubsBegin, (i + 1) - lastSubsBegin));
	//						}
	//					}
	//				}
	//			}
	//		}
	//		sequence = sequenceBuilder.ToString();
	//		return maxlen;
	//	}

	public static int longestSubstr(String first, String second) {
		if (first == null || second == null || first.length() == 0 || second.length() == 0) {
			return 0;
		}

		int maxLen = 0;
		int fl = first.length();
		int sl = second.length();
		int[][] table = new int[fl+1][sl+1];

		for(int s=0; s <= sl; s++)
			table[0][s] = 0;
		for(int f=0; f <= fl; f++)
			table[f][0] = 0;

		int lastSubsBegin = 0;
		StringBuilder sequenceBuilder = new StringBuilder();

		for (int i = 1; i <= fl; i++) {
			for (int j = 1; j <= sl; j++) {
				if (first.charAt(i-1) == second.charAt(j-1)) {
					if (i == 1 || j == 1) {
						table[i][j] = 1;
					}
					else {
						table[i][j] = table[i - 1][j - 1] + 1;
					}
					if (table[i][j] > maxLen) {
						maxLen = table[i][j];
						int thisSubsBegin = i - table[i][j] + 1;
						if (lastSubsBegin == thisSubsBegin)
						{//if the current LCS is the same as the last time this block ran
							sequenceBuilder.append(first.charAt(i));
						}
						else //this block resets the string builder if a different LCS is found
						{
							lastSubsBegin = thisSubsBegin;
							sequenceBuilder.setLength(0);
							sequenceBuilder.append(first.substring(lastSubsBegin, (i + 1) - lastSubsBegin));
						}
					}
				}
			}
		}
		String sequence = sequenceBuilder.toString();
		System.out.println(sequence);
		return maxLen;
	}

	private static String longestCommonSubstring(String S1, String S2)
	{
		int Start = 0;
		int Max = 0;
		for (int i = 0; i < S1.length(); i++) {
			for (int j = 0; j < S2.length(); j++) {
				int x = 0;
				while (S1.charAt(i + x) == S2.charAt(j + x)) {
					x++;
					if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
				}
				if (x > Max) {
					Max = x;
					Start = i;
				}
			}
		}
		return S1.substring(Start, (Start + Max));
	}

	public static void main(String[] args) {
//		System.out.println(longestCommonSubstring("abcdefgh", "dsadasdsadasdabcdefghsdadsadsadsadasd"));
		System.out.println(longestSubstr("abcdefgh", "dsadasdsadasdabcdefghsdadsadsadsadasd"));

	}
}
