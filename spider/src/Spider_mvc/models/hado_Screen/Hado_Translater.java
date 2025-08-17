	package Spider_mvc.models.hado_Screen;


	import Spider_mvc.models.Models_Everywhere.mastertextarea;

	public class Hado_Translater {

		// When the button is pressed, transform...
		// transform(TextFieldA a, TextFieldB b)
			// get the text from a -> a.gettextinput()
			// translate that  text
			// put that text in b -> b.gettextoutput("blah blah" )

		public void transform(mastertextarea input, mastertextarea output) {
			String text = input.gettextinput().getText();
			StringBuilder translater = new StringBuilder();

			for (char c : text.toCharArray()) {
				translater.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}
			output.gettextoutput().setText(translater.toString());
		}
	}
