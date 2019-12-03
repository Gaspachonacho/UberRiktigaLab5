package lab5;

import java.util.Scanner;
import java.util.Set;
public class WordQuiz {
	
	Dictionary dict;
	public WordQuiz(Dictionary dict) {
		this.dict = dict;
	}
	
	public void runQuiz() {
		Set<Word> terms = dict.terms();
		int ratt = 0;
		int fel = 0;
		
		
		for(Word term : terms) {
			System.out.println("Första ordet är: " + term);
			
			
			
		}
	
		
	}
	
	private static int showMenu() {
		System.out.println("1. Add Word");
		System.out.println("2. Play Swedish to English");
		System.out.println("3. Play English to Swedish");
		System.out.println("4. Quit");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		return choice;

	}

	public static void main(String[] args) {
// Skapa en tom ordlista på ngt sätt och fyll den med ord. Dictionary
		
		Dictionary sweng = new Dictionary();
		sweng.add("hej", "hello");
		sweng.add("hej", "hi");
		sweng.add("hej", "hey");
		sweng.add("godnatt", "good night");
		sweng.add("nattinatti", "good night");
		sweng.add("fågel", "bird");
		sweng.add("hund", "dog");
		sweng.add("katt", "cat");
		
		System.out.println("Welcome To My Wordquiz");
		System.out.println("======================");
		System.out.println("Select one of the following:");
		
		Scanner input = new Scanner(System.in);
		
		int a = 0;

		while (a != 4) {
			a = showMenu();
			switch(a){
				case 1:
					String t = "";
					String m = "";
					
					System.out.println("Type your word in swedish");
					t = input.nextLine();
					
					System.out.println("Type your word in english");
					m = input.nextLine();
					
					sweng.add(t,m);
					break;
					
				case 2:
					WordQuiz quiz = new WordQuiz(sweng);
					quiz.runQuiz();
					
					break;
				case 3:
					WordQuiz engquiz = new WordQuiz(sweng.inverse());
					System.out.println(sweng);
					engquiz.runQuiz();
					break;
					
				case 4:
					System.out.println("Goodbye!");
					break;
					
				default:
					
					break;
			}
		}
}
}