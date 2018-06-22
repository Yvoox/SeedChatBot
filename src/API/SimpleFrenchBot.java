package API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Model.Bot;
import Model.Spliter;
import Resources.ChoiceStep;

public class SimpleFrenchBot extends Bot{
	String response;
	
	public File brain = new File("src/Resources/brain.aiml");
	
	public SimpleFrenchBot(String name) {
		this.name = name;
		if(!brain.exists()) {
			System.out.println("Brain doesn't exist");
			try {
				brain.createNewFile();
				System.out.println("Brain successfully created!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else System.out.println("Brain connected");
	}

	@Override
	public int send(String entry) {
		// TODO Auto-generated method stub
		this.words = Spliter.split(entry);
		this.sentence = entry.toLowerCase();
		if(words.length!=0) return 1;
		else return 0;
	}

	@Override
	protected void basicAnalyze() {
		// TODO Auto-generated method stub
		response = ChoiceStep.reply(sentence);
		
	}

	@Override
	protected void NLPAnalyze() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String reply() {
		// TODO Auto-generated method stub
		basicAnalyze();
		return response;
	}

	@Override
	public int learn(String word, String emotionalMeaning, String whatReply) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream(brain);
			//Define the XML shape
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	


}
