package Spider_mvc.models.hado_Screen;

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

	private final String letter;
	private final String letterHado;

	HadoLanguageMvc(String letter, String letterHado) {
		this.letter = letter;
		this.letterHado = letterHado;
	}

	public String getLetter() {
		return letter;
	}

	public String getLetterHado() {
		return letterHado;
	}

	public static String hadoLanguagee(String letter) {
		for (HadoLanguageMvc code : HadoLanguageMvc.values()) {
			if (code.getLetter().equalsIgnoreCase(letter)) {
				return Character.isUpperCase(letter.charAt(0)) ?
						code.getLetterHado().toUpperCase() : code.getLetterHado().toLowerCase();
			}
		}
		return letter;
	}
}
