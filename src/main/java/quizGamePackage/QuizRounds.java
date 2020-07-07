package quizGamePackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuizRounds {
	ArrayList<Integer> disallowed = new ArrayList<Integer>();
	
	public QuizRounds() {
		
		
	}
	
	public int initializeArrays(Map<String, String[]> powerMap, int RoundNo) {
		int ValueOfRound = ((int) Math.pow((double) RoundNo, 2))*100;
		int rand = 0;
		disallowed.add(51);
		String [] Qarr = new String[powerMap.size()];
		Map<Integer, String[]> numToAns = new LinkedHashMap<Integer, String[]>();
		int index=0;
		for (Entry<String, String[]> entry : powerMap.entrySet()) {
			String key = entry.getKey();
			if (key.contains("&quot;")) {
				key=key.replaceAll("&quot;", "\"");
			}
			key=key.replaceAll("&#039;",  "'");
			key=key.replaceAll("&eacute;", "é");
			Qarr[index]=key;
			String[] value = entry.getValue();
			numToAns.put(index, value);
//			System.out.println("Key is: " + key);
//			System.out.println("Value is: "+ value);
			index+=1;
			}
		boolean trueRandom = false;
		while (trueRandom == false) {
			if (disallowed.contains(rand)) {
					rand = (int) ( (double) powerMap.size() * Math.random());
				}
				else {
					trueRandom = true;
					disallowed.add(rand);
				}
			
		
	}
		
		String relQ = Qarr[rand];
		String [] MCArr = numToAns.get(rand);
		
		System.out.println("Welcome to round " + RoundNo + "!");
		System.out.println("This question is worth " + ValueOfRound +" points!");
		System.out.println("");
		System.out.println("The question is: ");
		System.out.println("");
		System.out.println(relQ);
		for (int i=0; i<MCArr.length; i++) {
			String clean_string = MCArr[i].replace("CORRECT_ANSWER", "").replaceAll("&amp;", "&");
			System.out.println(i+1 + " " + clean_string);
			
		}
		boolean answered = false;
		while (answered == false) {
			Scanner sc = new Scanner(System.in);
			Integer ScannedValue = sc.nextInt();
			if (ScannedValue instanceof Integer) {
				if (MCArr[ScannedValue-1].contains("CORRECT_ANSWER")) {
					System.out.println("Yes indeed! That is the correct answer!");
					answered = true;
					
				}
				else {
					System.out.println("That is wrong :(");
					answered = true;
					
					ValueOfRound=-ValueOfRound;
				}
				
			}
			else {
				System.out.println("Input is invalid, please try again");
			}
		}
		return ValueOfRound;
	}
	
}
