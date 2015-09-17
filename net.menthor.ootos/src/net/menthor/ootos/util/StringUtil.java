package net.menthor.ootos.util;

import java.text.Normalizer;

public class StringUtil {
	/**
	 * Used to clean up the string with the owl.
	 * Sometimes wildcards can do a mistake in the code.
	 * */
	public static String processSpecialCharacter(String owl) {
		owl = Normalizer.normalize(owl, Normalizer.Form.NFD);
		owl = owl.replaceAll("[^\\p{ASCII}]", "");
		return owl;
	}
}
