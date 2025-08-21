	package Spider.models.hado_language;


	import Spider.models.Models_Everywhere.mastertextarea;

	public class Hado_Translater {

		// Transform input text from the "mastertextarea" into Hado language and put it in the output
		public void transform(mastertextarea input, mastertextarea output) {
			// Get text from input
			String text = input.gettextinput().getText();
			StringBuilder translator = new StringBuilder();

			// Translate each character using HadoLanguageMvc
			for (char c : text.toCharArray()) {
				translator.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}

			// Set translated text in output
			output.gettextoutput().setText(translator.toString());
		}

		// Transform input text from the "mastertextarea" from Hado language back to normal
		public void transformR(mastertextarea inputR, mastertextarea outputR) {
			// Get text from input
			String text = inputR.gettextinputR().getText();
			StringBuilder translator = new StringBuilder();

			// Reverse-translate each character using HadoLanguageMvc
			for (char c : text.toCharArray()) {
				translator.append(HadoLanguageMvc.reverseHadoLanguage(String.valueOf(c)));
			}

			// Set translated text in output
			outputR.gettextoutputR().setText(translator.toString());
		}
	}

