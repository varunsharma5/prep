package com.interview.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;

public class JSONParser {
	public static final int TOKEN_NONE = 0;
	public static final int TOKEN_CURLY_OPEN = 1;
	public static final int TOKEN_CURLY_CLOSE = 2;
	public static final int TOKEN_SQUARED_OPEN = 3;
	public static final int TOKEN_SQUARED_CLOSE = 4;
	public static final int TOKEN_COLON = 5;
	public static final int TOKEN_COMMA = 6;
	public static final int TOKEN_STRING = 7;
	public static final int TOKEN_NUMBER = 8;
	public static final int TOKEN_TRUE = 9;
	public static final int TOKEN_FALSE = 10;
	public static final int TOKEN_NULL = 11;

	private static final int BUILDER_CAPACITY = 2000;

	/// <summary>
	/// Parses the String json into a value
	/// </summary>
	/// <param name="json">A JSON String.</param>
	/// <returns>An ArrayList, a Hashtable, a double, a String, null, true, or false</returns>
	public static Object JsonDecode(String json) {
		boolean success = true;

		return JsonDecode(json, success);
	}

	/// <summary>
	/// Parses the String json into a value; and fills 'success' with the successfullness of the parse.
	/// </summary>
	/// <param name="json">A JSON String.</param>
	/// <param name="success">Successful parse?</param>
	/// <returns>An ArrayList, a Hashtable, a double, a String, null, true, or false</returns>
	public static Object JsonDecode(String json, boolean success)
	{
		success = true;
		if (json != null) {
			char[] charArray = json.toCharArray();
			int index = 0;
			Object value = ParseValue(charArray, index, success);
			return value;
		} else {
			return null;
		}
	}

	/// <summary>
	/// Converts a Hashtable / ArrayList Object into a JSON String
	/// </summary>
	/// <param name="json">A Hashtable / ArrayList</param>
	/// <returns>A JSON encoded String, or null if Object 'json' is not serializable</returns>
	public static String JsonEncode(Object json)
	{
		StringBuilder builder = new StringBuilder(BUILDER_CAPACITY);
		boolean success = SerializeValue(json, builder);
		return (success ? builder.toString() : null);
	}

	protected static Hashtable ParseObject(char[] json,  int index,  boolean success)
	{
		Hashtable table = new Hashtable();
		int token;

		// {
		NextToken(json,  index);

		boolean done = false;
		while (!done) {
			token = LookAhead(json, index);
			if (token == JSONParser.TOKEN_NONE) {
				success = false;
				return null;
			} else if (token == JSONParser.TOKEN_COMMA) {
				NextToken(json,  index);
			} else if (token == JSONParser.TOKEN_CURLY_CLOSE) {
				NextToken(json,  index);
				return table;
			} else {

				// name
				String name = ParseString(json,  index,  success);
				if (!success) {
					success = false;
					return null;
				}

				// :
				token = NextToken(json,  index);
				if (token != JSONParser.TOKEN_COLON) {
					success = false;
					return null;
				}

				// value
				Object value = ParseValue(json,  index,  success);
				if (!success) {
					success = false;
					return null;
				}

				table.put(name, value);
			}
		}

		return table;
	}

	protected static ArrayList ParseArray(char[] json,  int index,  boolean success)
	{
		ArrayList array = new ArrayList();

		// [
		NextToken(json,  index);

		boolean done = false;
		while (!done) {
			int token = LookAhead(json, index);
			if (token == JSONParser.TOKEN_NONE) {
				success = false;
				return null;
			} else if (token == JSONParser.TOKEN_COMMA) {
				NextToken(json,  index);
			} else if (token == JSONParser.TOKEN_SQUARED_CLOSE) {
				NextToken(json,  index);
				break;
			} else {
				Object value = ParseValue(json,  index,  success);
				if (!success) {
					return null;
				}

				array.add(value);
			}
		}

		return array;
	}

	protected static Object ParseValue(char[] json,  int index,  boolean success)
	{
		switch (LookAhead(json, index)) {
			case JSONParser.TOKEN_STRING:
				return ParseString(json,  index,  success);
			case JSONParser.TOKEN_NUMBER:
				return ParseNumber(json,  index,  success);
			case JSONParser.TOKEN_CURLY_OPEN:
				return ParseObject(json,  index,  success);
			case JSONParser.TOKEN_SQUARED_OPEN:
				return ParseArray(json,  index,  success);
			case JSONParser.TOKEN_TRUE:
				NextToken(json,  index);
				return true;
			case JSONParser.TOKEN_FALSE:
				NextToken(json,  index);
				return false;
			case JSONParser.TOKEN_NULL:
				NextToken(json,  index);
				return null;
			case JSONParser.TOKEN_NONE:
				break;
		}

		success = false;
		return null;
	}

	protected static String ParseString(char[] json,  int index,  boolean success)
	{
		StringBuilder s = new StringBuilder(BUILDER_CAPACITY);
		char c;

		EatWhitespace(json,  index);

		// "
		c = json[index++];

		boolean complete = false;
		while (!complete) {

			if (index == json.length) {
				break;
			}

			c = json[index++];
			if (c == '"') {
				complete = true;
				break;
			} else if (c == '\\') {

				if (index == json.length) {
					break;
				}
				c = json[index++];
				if (c == '"') {
					s.append('"');
				} else if (c == '\\') {
					s.append('\\');
				} else if (c == '/') {
					s.append('/');
				} else if (c == 'b') {
					s.append('\b');
				} else if (c == 'f') {
					s.append('\f');
				} else if (c == 'n') {
					s.append('\n');
				} else if (c == 'r') {
					s.append('\r');
				} else if (c == 't') {
					s.append('\t');
				} else if (c == 'u') {
					int remainingLength = json.length - index;
					if (remainingLength >= 4) {
						// parse the 32 bit hex into an integer codepoint
						uint codePoint;
						if (!(success = UInt32.TryParse(new String(json, index, 4), NumberStyles.HexNumber, CultureInfo.InvariantCulture, out codePoint))) {
							return "";
						}
						// convert the integer codepoint to a unicode char and add to String
						s.append(Char.ConvertFromUtf32((int)codePoint));
						// skip 4 chars
						index += 4;
					} else {
						break;
					}
				}

			} else {
				s.append(c);
			}

		}

		if (!complete) {
			success = false;
			return null;
		}

		return s.toString();
	}

	protected static double ParseNumber(char[] json,  int index,  boolean success)
	{
		EatWhitespace(json,  index);

		int lastIndex = GetLastIndexOfNumber(json, index);
		int charLength = (lastIndex - index) + 1;

		double number;
		success = Double.TryParse(new String(json, index, charLength), NumberStyles.Any, CultureInfo.InvariantCulture, out number);

		index = lastIndex + 1;
		return number;
	}

	protected static int GetLastIndexOfNumber(char[] json, int index)
	{
		int lastIndex;

		for (lastIndex = index; lastIndex < json.length; lastIndex++) {
			if ("0123456789+-.eE".IndexOf(json[lastIndex]) == -1) {
				break;
			}
		}
		return lastIndex - 1;
	}

	protected static void EatWhitespace(char[] json,  int index)
	{
		for (; index < json.length; index++) {
			if (" \t\n\r".IndexOf(json[index]) == -1) {
				break;
			}
		}
	}

	protected static int LookAhead(char[] json, int index)
	{
		int saveIndex = index;
		return NextToken(json,  saveIndex);
	}

	protected static int NextToken(char[] json,  int index)
	{
		EatWhitespace(json,  index);

		if (index == json.length) {
			return JSONParser.TOKEN_NONE;
		}

		char c = json[index];
		index++;
		switch (c) {
			case '{':
				return JSONParser.TOKEN_CURLY_OPEN;
			case '}':
				return JSONParser.TOKEN_CURLY_CLOSE;
			case '[':
				return JSONParser.TOKEN_SQUARED_OPEN;
			case ']':
				return JSONParser.TOKEN_SQUARED_CLOSE;
			case ',':
				return JSONParser.TOKEN_COMMA;
			case '"':
				return JSONParser.TOKEN_STRING;
			case '0': case '1': case '2': case '3': case '4':
			case '5': case '6': case '7': case '8': case '9':
			case '-':
				return JSONParser.TOKEN_NUMBER;
			case ':':
				return JSONParser.TOKEN_COLON;
		}
		index--;

		int remainingLength = json.length - index;

		// false
		if (remainingLength >= 5) {
			if (json[index] == 'f' &&
				json[index + 1] == 'a' &&
				json[index + 2] == 'l' &&
				json[index + 3] == 's' &&
				json[index + 4] == 'e') {
				index += 5;
				return JSONParser.TOKEN_FALSE;
			}
		}

		// true
		if (remainingLength >= 4) {
			if (json[index] == 't' &&
				json[index + 1] == 'r' &&
				json[index + 2] == 'u' &&
				json[index + 3] == 'e') {
				index += 4;
				return JSONParser.TOKEN_TRUE;
			}
		}

		// null
		if (remainingLength >= 4) {
			if (json[index] == 'n' &&
				json[index + 1] == 'u' &&
				json[index + 2] == 'l' &&
				json[index + 3] == 'l') {
				index += 4;
				return JSONParser.TOKEN_NULL;
			}
		}

		return JSONParser.TOKEN_NONE;
	}

	protected static boolean SerializeValue(Object value, StringBuilder builder)
	{
		boolean success = true;

		if (value instanceof String) {
			success = SerializeString((String)value, builder);
		} else if (value instanceof Hashtable) {
			success = SerializeObject((Hashtable)value, builder);
		} else if (value instanceof ArrayList) {
			success = SerializeArray((ArrayList<E>)value, builder);
		} else if ((value instanceof Boolean) && ((Boolean)value == true)) {
			builder.append("true");
		} else if ((value instanceof Boolean) && ((Boolean)value == false)) {
			builder.append("false");
		} else if (value instanceof ValueType) {
			// thanks to ritchie for pointing out ValueType to me
			success = SerializeNumber(Convert.ToDouble(value), builder);
		} else if (value == null) {
			builder.append("null");
		} else {
			success = false;
		}
		return success;
	}

	protected static boolean SerializeObject(Hashtable anObject, StringBuilder builder)
	{
		builder.append("{");

		IDictionaryEnumerator e = anObject.GetEnumerator();
		boolean first = true;
		while (e.MoveNext()) {
			String key = e.Key.toString();
			Object value = e.Value;

			if (!first) {
				builder.append(", ");
			}

			SerializeString(key, builder);
			builder.append(":");
			if (!SerializeValue(value, builder)) {
				return false;
			}

			first = false;
		}

		builder.append("}");
		return true;
	}

	protected static boolean SerializeArray(ArrayList anArray, StringBuilder builder)
	{
		builder.append("[");

		boolean first = true;
		for (int i = 0; i < anArray.size(); i++) {
			Object value = anArray[i];

			if (!first) {
				builder.append(", ");
			}

			if (!SerializeValue(value, builder)) {
				return false;
			}

			first = false;
		}

		builder.append("]");
		return true;
	}

	protected static boolean SerializeString(String aString, StringBuilder builder)
	{
		builder.append("\"");

		char[] charArray = aString.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (c == '"') {
				builder.append("\\\"");
			} else if (c == '\\') {
				builder.append("\\\\");
			} else if (c == '\b') {
				builder.append("\\b");
			} else if (c == '\f') {
				builder.append("\\f");
			} else if (c == '\n') {
				builder.append("\\n");
			} else if (c == '\r') {
				builder.append("\\r");
			} else if (c == '\t') {
				builder.append("\\t");
			} else {
				int codepoint = Convert.ToInt32(c);
				if ((codepoint >= 32) && (codepoint <= 126)) {
					builder.append(c);
				} else {
					builder.append("\\u" + Convert.toString(codepoint, 16).PadLeft(4, '0'));
				}
			}
		}

		builder.append("\"");
		return true;
	}

	protected static boolean SerializeNumber(double number, StringBuilder builder)
	{
		builder.append(Convert.toString(number, CultureInfo.InvariantCulture));
		return true;
	}
}
