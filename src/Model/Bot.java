package Model;

import java.io.File;
import java.util.Stack;

public abstract class Bot {
	protected String[] words;
	protected static String name;
	protected String sentence;


	
	/*
	 * After NLP analysis, keep the emotional state of the entrees
	 */
	protected Stack emotionalState = new Stack<String>(); 

	/*
	 * return statement will inquire the receipt
	 * 0 : lost
	 * 1 : receive
	 */
	abstract public int send(String entry);
	
	/*
	 * Provide a simple analyze of the sentence
	 */
	abstract protected void basicAnalyze();
	
	/*
	 * Provide a NLP analyze of the sentence
	 * Use the emotionalState to record every words meaning
	 */
	abstract protected void NLPAnalyze();
	
	/*
	 * Prepare and return the Bot's reply
	 */
	abstract public String reply();
	
	/*
	 * Learn a new word, meaning and what to answer
	 * 0 : learn failed
	 * 1 : learn ok
	 */
	abstract public int learn(String word, String emotionalMeaning, String whatReply);
	
	public static String getName() {
		return name;
	}
	
	
}
