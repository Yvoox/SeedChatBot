package UI;

import Model.Spliter;

public class Main {

	public static void main(String[] args) {
		String[] test = Spliter.split("Salut c'est cool la, vie, et tu t'es trompé; héhéhé");
		for(String it : test) {
			System.out.println(it);
		}

	}

}
