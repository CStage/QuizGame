package quizGamePackage;

public class Player {
	public String name;
	public int score = 0;
	protected static int counter = 0;
	public int playerNumber;
	
	public Player(String name) {
		this.name = name;
		counter += 1;
		this.playerNumber=counter;
	}
	
	public void AwardScore(int addition) {
		this.score += addition;
	}
	
	public void StateTheFacts() {
		System.out.println("I'm player " + this.playerNumber + ", and my name is: " + this.name + "!");
		if (this.score > 500) {
			System.out.println("And my score of: " + this.score + " is super fucking high!");
		}
		else if (250 < this.score && this.score < 500) {
			System.out.println("And my score of: " + this.score + " is pretty okay, I guess...");
		}
		
		else {
			System.out.println("And I guess I should just quit, because my score of: " + this.score + " is pretty pathetic.");
		} 
		
	}
}
