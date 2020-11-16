package quizGamePackage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;


public class Main {
	
	public static String TakeInput() {
		Scanner InputScanner = new Scanner(System.in);
		String input = InputScanner.nextLine();
		
		
		return input;
	}

	public static void main(String[] args) {
		boolean done = false;
		int playerCounter = 0;
		ArrayList<Player> players = new ArrayList<Player>();
		System.out.println("Hello! Welcome to the quiz game!");
		System.out.println("So... Who will be playing tonight?");
		while (done == false) {
			boolean stopInputs = false;
			playerCounter+=1;
			System.out.println("Input the name of player " + playerCounter + ": ");
			String input = TakeInput();
			Player player = new Player(input);
			players.add(player);
			while (stopInputs==false) {
				System.out.println("Do you wish to input more players?");
				String inputtedVal = TakeInput();
				if (inputtedVal.equalsIgnoreCase("no")) {
					done=true;
					stopInputs=true;
				}
				else if (inputtedVal.equalsIgnoreCase("yes")) {
					System.out.println("Okay cool, let's add more!");
					stopInputs=true;
				}
				else {
					System.out.println("Invalid input");
				}
					
				}
			}
		
		
		JsonReader p = new JsonReader();
		String basepath = System.getProperty("user.dir");
		String ActualPath = basepath + "\\src\\main\\java\\quizGamePackage\\FirstAttemptJay.json";
		Map<String, String[]> x = p.GetMapofQuestions(ActualPath);
		System.out.println(x);
		QuizRounds qr = new QuizRounds();
		for (int i=0; i<5; i++) {
			
		for (Player j:players) {
			System.out.println("This question is for: " + j.name);
			int potentialPoints = qr.initializeArrays(x, i+1);
			j.score+=potentialPoints;
		}
	}
		int compareVal=0;
		String currentLeader="";
		for (Player i:players) {
			if (compareVal==0) {
				compareVal= i.score;
				currentLeader=i.name;
			}
			else if (compareVal<i.score) {
				compareVal=i.score;
				currentLeader=i.name;
			}
			i.StateTheFacts();
		}
		System.out.println("");
		System.out.println("And thus it is evident that the winner is: " + currentLeader);
	}

}
