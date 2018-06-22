package UI;

import java.util.Scanner;

import API.SimpleFrenchBot;
import Model.Spliter;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the bot name :");
		String botName = sc.nextLine();
		
		SimpleFrenchBot bot = new SimpleFrenchBot(botName);

		while(true) {
			System.out.print("> User: ");
			String str = sc.nextLine();
			bot.send(str);
			System.out.println("> "+botName+": "+bot.reply());

		}

	}

}
