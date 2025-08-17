package Spider_mvc.models.Models_Everywhere;

import javax.swing.*;

public class masterscrollpane {
	private JScrollPane scrollPane;
	mastertextarea mastertextarea = new mastertextarea();

	public masterscrollpane() {
		scrollPane = new JScrollPane(mastertextarea.masterTextArea(),
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public mastertextarea getMasterTextArea() {
		return mastertextarea;
	}


}
