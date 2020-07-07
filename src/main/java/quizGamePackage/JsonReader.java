package quizGamePackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
	@SuppressWarnings("rawtypes")
	Map powerMap = new LinkedHashMap();
	ArrayList<String []> multiple = new ArrayList<String []>();
	
	public JsonReader() {
		
	}
	public Map<String, String []> GetMapofQuestions(String file_path) {
		JSONParser jsonParser = new JSONParser();
//		String file_path="C:\\Users\\Christian\\OneDrive\\Java Stuff\\Test\\src\\main\\java\\quizGamePackage\\FirstAttemptJay.json";
		try (FileReader reader = new FileReader(file_path)) 
		{
			Object obj = jsonParser.parse(reader);
			
			JSONObject QuizList = (JSONObject) obj;
			//System.out.println(QuizList);
			
			JSONArray results = (JSONArray) QuizList.get("results");
			
			results.forEach(x -> parseQuizObject( (JSONObject) x));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return powerMap; 
	}

	@SuppressWarnings("unchecked")
	private void parseQuizObject(JSONObject Question) {
		

		String question = (String) Question.get("question");
		//System.out.println(question);
		
		//Get correct answer
		String raw_correct = (String) Question.get("correct_answer");
		String correct = raw_correct + "CORRECT_ANSWER";
		//System.out.println(correct);
		
		JSONArray incorrect = (JSONArray) Question.get("incorrect_answers");
		
		String [] ordered = new String[4];
		for (int i=0; i<=incorrect.size(); i++) {
//			System.out.println("If correct is to be added to the list then below should be equal");
//			System.out.println("i is: " + i + " incSize is: " + incorrect.size());
			if (i==incorrect.size()) {
				ordered[i]=correct;
			}
			else {
				ordered[i]=(String) incorrect.get(i);
			}
		}
		
		String [] unordered = new String[4];
		for (String i:ordered) {
			boolean unaccepted=true;
			while (unaccepted==true) {
			int RandomInt = (int) ( (double) (incorrect.size()+1) * Math.random());
//			System.out.println("RandomInt is: " + RandomInt);
				if (unordered[RandomInt] != null) {
					;
				}
				else {
					unaccepted=false;
					unordered[RandomInt]=i;
//					System.out.println("Unordered[random] " + unordered[RandomInt]);
				}
				
		}
			
			}
		powerMap.put(question, unordered);
	}
		
		
		
}