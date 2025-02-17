package spider.building_blocks;

import javax.swing.*;

public class masterscrollpane {
	mastertextarea mastertextarea = new mastertextarea();
	public JScrollPane masterscrollpane() {
		return new JScrollPane(mastertextarea.masterTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
}
