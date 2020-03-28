package com.codewithwilliam.shortner.encoding.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

public class MD5EncodingServiceImpl {

	private static final String alphaNumericString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";

	public static String getEncodedValue(MessageDigest m, String text, int bytes) {

		m.reset();
		byte[] digestArray = m.digest(text.getBytes());
		Long digestLong = getDigesLongValue(digestArray, bytes);
		String parsedString = getString(Math.abs(digestLong));
		return parsedString;

	}

	public static Long getDigesLongValue(byte[] digest, int bytes) {
		BigInteger bigInt = new BigInteger(1, Arrays.copyOfRange(digest, 0, bytes));
		return bigInt.longValue();
	}

	public static String getString(long digestLongValue) {
		StringBuilder builder = new StringBuilder();
		while (digestLongValue > 0) {
			builder.append(alphaNumericString.charAt((int) Math.abs(digestLongValue % alphaNumericString.length())));
			digestLongValue = digestLongValue / alphaNumericString.length();
		}
		return builder.toString();
	}
}