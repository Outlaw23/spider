package spider.building_blocks.screenHadoBuild;

import spider.building_blocks.mastertextarea;

public class translate_hado {

	// When the button is pressed, transform...
	// transform(TextFieldA a, TextFieldB b)
		// get the text from a -> a.gettextinput()
		// translate that  text
		// put that text in b -> b.gettextoutput("blah blah" )

	public void transform(mastertextarea input, mastertextarea output) {
//		mastertextarea mastertextareainput = new mastertextarea();
//		mastertextarea mastertextareaoutput = new mastertextarea();

		String text = input.gettextinput().getText();
		StringBuilder translater = new StringBuilder();
		for (char c : text.toCharArray()) {
			translater.append(HadoLanguage.hadoLanguagee(String.valueOf(c)));
			output.gettextoutput(translater.toString());
		}
	}
}
