// Shani Zahavi 211305271, Leon Petrov 314821521
// git- https://github.com/ShaniZah/Assignment2_java

package XO;

import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	// manage user choice
	public static void menu() {
		int choice = 0;
		while (choice != 1 || choice != 2) { // check input validity
			System.out.println("which option would you like?");
			System.out.println("1- thread vs thread");
			System.out.println("2- player vs thread");
			choice = sc.nextInt();
			if (choice == 1) {
				SelfGame selfGame = new SelfGame();
				selfGame.startGame();
				break;
			}

			else if (choice == 2) {
				UserGame userGame = new UserGame();
				userGame.startGame();
				break;
			} else {
				System.out.println("invaid choice, try again");
			}
		}

	}

}
