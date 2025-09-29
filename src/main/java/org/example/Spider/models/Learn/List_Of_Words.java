package org.example.Spider.models.Learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class List_Of_Words {

	public static List<String> list_of_words_op1() {
		List<String> Op1 = new ArrayList<>();
		Op1.add("Tree");
		Op1.add("Water");
		Op1.add("Light");
		Op1.add("House");
		Op1.add("Dream");
		Op1.add("Time");
		Op1.add("Flame");
		Op1.add("Cloud");
		Op1.add("Stone");
		Op1.add("Sound");
		Op1.add("sun");
		Op1.add("moon");
		Op1.add("star");
		Op1.add("sky");
		Op1.add("rain");
		Op1.add("dream");
		Op1.add("forest");
		Op1.add("fire");
		Op1.add("ice");
		Op1.add("stone");
		Op1.add("gold");
		Op1.add("water");
		Op1.add("wind");
		Op1.add("sea");
		Op1.add("mountain");
		Op1.add("light");
		Op1.add("shadow");
		Op1.add("leaf");
		Op1.add("flower");
		Op1.add("grass");
		Op1.add("time");
		Op1.add("road");
		Op1.add("silence");
		Op1.add("power");
		Op1.add("word");
		Op1.add("line");
		Op1.add("mirror");
		Op1.add("thread");
		Op1.add("sound");
		Op1.add("color");
		Op1.add("shape");
		Op1.add("scent");
		Op1.add("path");
		Op1.add("gate");
		Op1.add("tower");
		Op1.add("room");
		Op1.add("book");
		Op1.add("note");
		Op1.add("pen");
		Op1.add("map");

		List<String> Op1Ten = new ArrayList<>();
		Random rand = new Random();
		while (Op1Ten.size() < 10) {
			int random = rand.nextInt(49);
			String word = Op1.get(random).toLowerCase();
			if (!Op1Ten.contains(word)) {
				Op1Ten.add(word);;
			}
		}
		return Op1Ten;
	}
}
