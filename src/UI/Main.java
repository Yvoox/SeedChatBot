package UI;

import Model.Spliter;

public class Main {

	public static void main(String[] args) {
		String[] test = Spliter.split("Salut c'est cool la, vie, et tu t'es tromp�; h�h�h�");
		for(String it : test) {
			System.out.println(it);
		}

	}

}
