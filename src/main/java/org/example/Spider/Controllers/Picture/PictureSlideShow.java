package org.example.Spider.Controllers.Picture;

import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;
import org.example.Spider.models.Picture.Img_Paths_Pictures;

public class PictureSlideShow {

	private static final String[] images = {
			Img_Paths_Pictures.book,
			Img_Paths_Pictures.cloud,
			Img_Paths_Pictures.flame,
			Img_Paths_Pictures.flower,
			Img_Paths_Pictures.gold,
			Img_Paths_Pictures.house,
			Img_Paths_Pictures.sea,
			Img_Paths_Pictures.stone,
			Img_Paths_Pictures.tower,
			Img_Paths_Pictures.tree
	};

	private static int index = 0;

	public static void next() {
		index = (index + 1) % images.length;
		Picture_Learn_Component.setImage(images[index]);
	}

}
