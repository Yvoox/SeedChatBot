package Resources;

import java.util.Random;

import Model.Bot;

public class ChoiceStep {

	public static String reply(String entry) {
		// Hello event
		if(containsOR(entry,"bonjour","salut","hello",null)) {
			if(containsAND(entry,"ca","va") || containsAND(entry,"comment","va") || containsAND(entry,"va","bien")) return hello(1);
			else return hello(0);
		}
		//How are you event
		if((containsAND(entry,"ca","va") || containsAND(entry,"comment","va") || containsAND(entry,"va","bien")) && containsAND(entry,"va","?")) return howAreYou(0);
		if((containsAND(entry,"ca","va") || containsAND(entry,"va","bien")) && !containsAND(entry,"va","?") && !containsOR(entry,"pas","mal","ne","non")) return howAreYou(1);
		if((containsAND(entry,"va","pas") || containsAND(entry,"va","mal") || containsAND(entry,"ne","va"))  && !containsAND(entry,"va","?")) return howAreYou(2);
		//Who are you
		if((containsAND(entry,"qui","tu") || containsAND(entry,"comment","appelle"))&&containsAND(entry,"?","?")) return whoAreYou(0);
		if(containsAND(entry,"présente","toi")) return whoAreYou(0);
		if(containsAND(entry,"je","appelle") || containsAND(entry,"mon","nom")) return whoAreYou(1);

		return randomFact();
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
	 * int variant enable the bot to response if the user ask him if it's well or say he's well
	 * variant = 0 -> ask if it's well
	 * variant = 1 -> say he's well
	 * variant = 2 -> he's not well
	 */	
	private static String howAreYou(int variant) {
		String[] arr = new String[3];
		if(variant == 0) { 
			arr[0] = "Je vais très bien, et vous ?";
			arr[1] = "Tout va bien. Merci";
			arr[2] = "Je vais bien. Avez vous besoin de quelque chose ?";
		}
		else if(variant == 1){
			arr[0] = "Heureux de l'entendre ! Puis-je vous renseigner ?";
			arr[1] = "Si tout va bien, puis-je faire quelque chose pour vous ?";
			arr[2] = "Vous m'en voyez enchanté. Est ce que je peux vous aider ?";
		}
		else if(variant == 2){
			arr[0] = "Vous m'en voyez désolé.. Comment puis-je améliorer votre journée ?";
			arr[1] = "Tout va bien maintenant puisque nous sommes ensemble. Puis-je vous aider ?";
			arr[2] = Bot.getName()+" est là pour vous aider à aller mieux. Puis-je vous aider ?";
		}

		Random random = new Random();
		return arr[random.nextInt(arr.length)];
	}

	private static String randomFact() {
		String[] arr = new String[3];
			arr[0] = "Je suis désolé mais je ne suis pas sûr de vous suivre..";
			arr[1] = "Pouvez vous reformuler ? Je n'ai pas compris..";
			arr[2] = "C'est sans doute très interessant mais je ne suis pas capable de comprendre..";


		Random random = new Random();
		return arr[random.nextInt(arr.length)];
	}

	/*
	 * int variant enable the bot to response if the user say who he are or ask who it is
	 * variant = 0 -> ask who it is
	 * variant = 1 -> say who he are
	 */	
	private static String whoAreYou(int variant) {
		String[] arr = new String[3];
		if(variant == 0) { 
			arr[0] = "Je m'appelle "+Bot.getName()+" et je suis votre assistant personnel. J'ai été conçu par l'entreprise Seed pour vous aider et répondre à vos questions. Je suis ce qu'on appelle communément un ChatBot, même si ma personnalité est bien plus complexe...";
			arr[1] = "Je suis une intelligence artificielle capable de répondre à toutes vos questions. Mon nom à moi c'est "+Bot.getName()+" et je suis fier d'avoir ma propre personnalité développée au fil du temps et de mes contacts. J'ai été développé par l'entreprise Seed.";
			arr[2] = Bot.getName() +" pour vous servir ! Je suis une inteligence artificielle développée par l'entreprise Seed. Je suis doté d'au moins 75% d'humour.. Mais je n'ai pas toujours le droit de la laisser s'exprimer !";
		}
		else if(variant == 1){
			arr[0] = "Enchanté, moi c'est "+Bot.getName()+" comme vous le savez. J'ai été conçu par l'entreprise Seed afin de vous guider et répondre à vos questions. Cependant, ma personnalité s'est forgée au contact des utilisateurs. Génial non ?";
			arr[1] = "Enchanté, mon nom est "+Bot.getName()+" et j'ai été conçu par l'entreprise Seed pour répondre à toutes vos questions !";
			arr[2] = "Et moi c'est "+Bot.getName()+". J'ai été conçu par l'entreprise Seed afin de vous guider et répondre à vos questions. Cependant, ma personnalité s'est forgée au contact des utilisateurs. Génial non ? ";
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
