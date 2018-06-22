package Resources;

import java.util.Random;

import Model.Bot;

public class ChoiceStep {

	public static String reply(String entry) {
		if(containsOR(entry,"bonjour","salut","hello",null)) {
			if(containsAND(entry,"ca","va") || containsAND(entry,"comment","va") || containsAND(entry,"va","bien")) return hello(1);
			else return hello(0);
		}
		return "Désolé je ne suis pas sûr de bien comprendre";
	}

	/*
	 * int variant enable the bot to response if the user ask him he's well or not
	 * variant = 0 -> simple hello
	 * variant = 1 -> improved hello
	 */
	private static String hello(int variant) {
		String[] arr = new String[3];
		if(variant == 0) { 
			arr[0] = "Bonjour, comment allez vous ? Je m'appelle "+ Bot.getName() +". Est ce que je peux vous être utile ?";
			arr[1] = "Hello, je suis "+Bot.getName()+", que puis-je pour vous ?";
			arr[2] = "Vous m'avez appelé ? Laissez moi me présenter, je m'appelle "+ Bot.getName()+" et je suis à votre service.";
		}
		else {
			arr[0] = "Bonjour, je vais très bien, merci et vous ? Je m'appelle "+ Bot.getName() +". Est ce que je peux vous être utile ?";
			arr[1] = "Hello, très bien, merci. Je suis "+Bot.getName()+", que puis-je pour vous ?";
			arr[2] = "Bonjour ! Il ne fait pas très beau aujourd'hui mais"+Bot.getName()+" va toujours bien. Et vous ?";
	}

	Random random = new Random();
	return arr[random.nextInt(arr.length)];
}

	/*
	 * Allow to find if an entry contains one of 4 strings.
	 * Put null if you want find less than 4 Strings
	 */
	private static boolean containsOR(String entry, String s1, String s2, String s3, String s4) {
		String[] matches = new String[] {s1, s2 , s3 , s4};

		for (String s : matches)
		{
			if(s != null) {
				  if (entry.contains(s)) return true;
			}

		}
		return false;
	}
	
	/*
	 * Allow to find if an entry contains two Strings
	 */
	private static boolean containsAND(String entry, String s1, String s2) {
		if(entry.contains(s1) && entry.contains(s2)) {
			return true;
		}
		return false;
	}

}
