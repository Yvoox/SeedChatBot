package Model;

import java.util.ArrayList;
import java.util.List;

public class Spliter {

	public static String[] split(String entry){
		//List<String> words = new ArrayList<>();
		String[] words = entry.split("\\P{L}+");
		return words;
	}
}
