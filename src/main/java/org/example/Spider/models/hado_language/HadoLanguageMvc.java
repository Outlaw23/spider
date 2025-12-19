package org.example.Spider.models.hado_language;

/**
 * Enum representing the mapping between normal letters and Hado letters.
 * Provides methods to translate letters to Hado and back.
 */
public enum HadoLanguageMvc {

	// Row 1
	B("B", "H"),
	H("H", "N"),
	N("N", "Z"),
	Z("Z", "B"),

	// Row 2
	C("C", "J"),
	J("J", "P"),
	P("P", "T"),
	T("T", "X"),
	X("X", "C"),

	// Row 3
	D("D", "K"),
	K("K", "Q"),
	Q("Q", "V"),
	V("V", "D"),

	// Row 4
	F("F", "L"),
	L("L", "R"),
	R("R", "W"),
	W("W", "F"),

	// Row 5
	G("G", "M"),
	M("M", "S"),
	S("S", "Y"),
	Y("Y", "G");

	/** Original letter */
	private final String letter;

	/** Corresponding Hado letter */
	private final String letterHado;

	/**
	 * Constructor to link a normal letter to its Hado equivalent.
	 *
	 * @param letter     original letter
	 * @param letterHado corresponding Hado letter
	 */
	HadoLanguageMvc(String letter, String letterHado) {
		this.letter = letter;
		this.letterHado = letterHado;
	}

	/**
	 * Gets the original letter.
	 *
	 * @return the original letter
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * Gets the corresponding Hado letter.
	 *
	 * @return the Hado letter
	 */
	public String getLetterHado() {
		return letterHado;
	}

	/**
	 * Converts a normal letter to its Hado equivalent.
	 * Preserves the case (upper/lower) of the input letter.
	 *
	 * @param letter the letter to convert
	 * @return the corresponding Hado letter, or the original letter if no match is found
	 */
	public static String hadoLanguagee(String letter) {
		for (HadoLanguageMvc code : HadoLanguageMvc.values()) {
			if (code.getLetter().equalsIgnoreCase(letter)) {
				return Character.isUpperCase(letter.charAt(0)) ?
						code.getLetterHado().toUpperCase() : code.getLetterHado().toLowerCase();
			}
		}
		return letter;
	}

	/**
	 * Converts a Hado letter back to its normal letter equivalent.
	 * Preserves the case (upper/lower) of the input letter.
	 *
	 * @param hadoLetter the Hado letter to convert
	 * @return the corresponding normal letter, or the original Hado letter if no match is found
	 */
	public static String reverseHadoLanguage(String hadoLetter) {
		for (HadoLanguageMvc code : HadoLanguageMvc.values()) {
			if (code.getLetterHado().equalsIgnoreCase(hadoLetter)) {
				return Character.isUpperCase(hadoLetter.charAt(0)) ?
						code.getLetter().toUpperCase() : code.getLetter().toLowerCase();
			}
		}
		return hadoLetter;
	}
}
