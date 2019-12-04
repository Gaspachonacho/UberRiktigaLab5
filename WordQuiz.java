package lab5;

import java.util.*;
public class WordQuiz {
	
	Dictionary dictionary;
	public WordQuiz(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	public void runQuiz() {
		Set<Word> keys = dictionary.terms();
		Scanner scan = new Scanner(System.in);
		List<Word> list = new ArrayList<>(keys);
		List<Word> rattList = new ArrayList<>();
		int ratt = 0;
		int fel = 0;
		int wordCount = 1;
		while(!(list.isEmpty())) {
			
			for(Word key : list) {
				System.out.println("Word " + wordCount + " is: " + key);
				Word value = new Word(scan.nextLine());
				
				if(dictionary.lookup(key).contains(value)) {
					System.out.println("Rätt!");
					ratt++;
					rattList.add(key);
				} else {
					System.out.println("Fel!");
					fel++;
				}	
				wordCount++;
			}
			for(Word key : rattList) {
				list.remove(key);
			}
			if (list.size() != 0) {
			System.out.println("Du hade " + fel + " fel, kör igen!");
			wordCount = 1;
			}
		}
		
		System.out.println("Du hade " + ratt + " rätt och " + fel + " Fel");
		
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
		sweng.add("nutter", "nuts");
		sweng.add("nötter", "nuts");
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
					engquiz.runQuiz();
					break;
					
				case 4:
					System.out.println("Goodbye!");
					System.exit(0);
					break;
					
				default:
					System.out.println("Skriv in ett nummer mellan 1-4 din sopa");
					break;
			}
		}
}
}