package Spider.models.hado_language;

public enum HadoLanguageMvc {
	// Rij 1
	B("B", "H"),
	H("H", "N"),
	N("N", "Z"),
	Z("Z", "B"),

	// Rij 2
	C("C", "J"),
	J("J", "P"),
	P("P", "T"),
	T("T", "X"),
	X("X", "C"),

	// Rij 3
	D("D", "K"),
	K("K", "Q"),
	Q("Q", "V"),
	V("V", "D"),

	// Rij 4
	F("F", "L"),
	L("L", "R"),
	R("R", "W"),
	W("W", "F"),

	// Rij 5
	G("G", "M"),
	M("M", "S"),
	S("S", "Y"),
	Y("Y", "G");

	// originele letter
	private final String letter;
	// corresponderende Hado letter
	private final String letterHado;

	// constructor om letters te koppelen
	HadoLanguageMvc(String letter, String letterHado) {
		this.letter = letter;
		this.letterHado = letterHado;
	}

	// getter voor originele letter
	public String getLetter() {
		return letter;
	}

	// getter voor Hado letter
	public String getLetterHado() {
		return letterHado;
	}

	// Zet normale letter om naar Hado letter
	public static String hadoLanguagee(String letter) {
		for (HadoLanguageMvc code : HadoLanguageMvc.values()) {
			if (code.getLetter().equalsIgnoreCase(letter)) {
				// behoud hoofdletter als input een hoofdletter is
				return Character.isUpperCase(letter.charAt(0)) ?
						code.getLetterHado().toUpperCase() : code.getLetterHado().toLowerCase();
			}
		}
		// return originele letter als er geen match is
		return letter;
	}

	// Zet Hado letter terug naar normale letter
	public static String reverseHadoLanguage(String hadoLetter) {
		for (HadoLanguageMvc code : HadoLanguageMvc.values()) {
			if (code.getLetterHado().equalsIgnoreCase(hadoLetter)) {
				// behoud hoofdletter als input een hoofdletter is
				return Character.isUpperCase(hadoLetter.charAt(0)) ?
						code.getLetter().toUpperCase() : code.getLetter().toLowerCase();
			}
		}
		// return originele Hado letter als er geen match is
		return hadoLetter;
	}
}
