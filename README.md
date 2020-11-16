# QuizGame
 Basic Java quiz game made as an exam project after learning basic Java
__________________________________________________________________________
__________________________________________________________________________
0. Introduction
1. Purpose
	1.1. Learning how to read .json-files in Java
	1.2. Getting used to Java-workflow
2. List of classes
	2.1. JsonReader
	2.2. Player
	2.3. QuizRounds
	2.4. Main
3. Final notes and future work

______________________________
0. Introduction
________________________________
After having taken a course in Python by Tech With Tim and finishing several MIT-assignments, I created this quiz game as a sort of "final exam" for me. The program reads questions from a .json-file obtained from "opentdb.com" and is designed to take any .json-file with the same format regardless of length.

______________________________
1. Purpose
________________________________

______________________________
1.1. Learning how to read .json-files in Java
________________________________
Having been used to Python and the ease of reading .txt-files I wanted to learn how to read .json in Java. This project gave me a deeper understanding of how to refer to elements in and iterate over a .json-file.

______________________________
1.2. Getting used to Java-workflow
________________________________
The Java-setup of creating classes in different files and then importing, combining, etc. is quite different from the workflow in Python. By using three different classes and a Main, this project allowed me to get comfortable with the Java-workflow and the advantages of it.



______________________________
2. List of classes
________________________________

______________________________
2.1. JsonReader
________________________________
JsonReader is the type class that reads .json-files and has the following methods:
GetMapofQuestions, which takes the file path of a valid .json-file and returns a map of the file's contents.
parseQuizObject, which takes a JSONObject and returns a map of the questions to their multiple choice answers in a random order.

______________________________
2.2. Player
________________________________
The game allows for an unlimited amount of players which hold the following attributes:
name: String of the player's name
score: int of the players score
counter = static int which increases by 1 for each initiated player
playerNumber = int of the player's number

Player uses the following methods:
AwardScore, which takes an int that is then added to the player's current score.
StateTheFacts, which is a void and prints out one of three possible statements depending on the player's current score.

______________________________
2.3. QuizRounds
________________________________
QuizRounds only holds one attribute:
disallowed: ArrayList<Integer> which holds all the question-numbers that have already been used earlier in the current game.

QuizRounds uses the following methods:
InitializeArrays, which takes a map similar of the type returned by JsonReader.parseQuizObject and an int of the given number of the round. The method then initializes a round, calculates the amount of points a player will get for answering correctly and prints a question, the possible answers and different answers depending on if the player gets it right or wrong.

______________________________
2.4. Main
________________________________
Main uses two different loops. One that allows for the initialization of Players and one for playing different rounds. As a standard I have hard-coded the amount of rounds in to be =5.´

______________________________
3. Final Notes and Future Work
________________________________
This is a very simple application used to practice basic Java. It can be highly improved by:
Further testing and bug-fixing, e.g. when number of quiz-rounds is higher than 50, the program will crash at some point because the .json-file runs out of questions.
Replace the need for a local .json-file with API-integration to "opentdb.com".
Clean up names of variables etc.

I have however decided not to put more work into it as I am currently working on more exciting Java-projects and this was just a little practice session :)