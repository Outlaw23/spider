package spider.building_blocks.screenHadoBuild;

import spider.building_blocks.mastertextarea;
import spider.building_blocks.screenHadoBuild.textArea_hado.text_output;

public class translate_hado {
	public void transform() {
		text_output textOutput = new text_output();
		mastertextarea mastertextarea = new mastertextarea();

		String text = mastertextarea.masterTextArea().getText();
		System.out.println(text + "prima");
		StringBuilder translater = new StringBuilder();
		for (char c : text.toCharArray()) {
			translater.append(HadoLanguage.hadoLanguagee(String.valueOf(c)));
			mastertextarea.setTextOutput(translater.toString());
		}
	}
}
