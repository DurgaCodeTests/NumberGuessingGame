package codingtest.compugain.guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is for a simple number guessing game which narrows the search
 * based on user decision.
 * 
 * @author Durga Prasad
 */
public class GuessingNumberGame {

	/**
	 * Number of attempts
	 */
	private int attempts = 0;

	/**
	 * BufferedReader to read input by the user
	 */
	private BufferedReader bufferedReader = null;

	/**
	 * Constructor to create instance of buffered reader to read user input
	 */
	public GuessingNumberGame() {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		} catch (final Exception ex) {
			System.err.println("Exception creating buffered reader -> " + ex.getMessage());
		}
	}

	/**
	 * The main business method which contains the logic to guess the number in
	 * the user's mind. It uses standard Binary Search algorithm for guessing
	 * it.
	 * 
	 * @param lower
	 * @param higher
	 * @throws Exception
	 */
	public void tryGuess(final int lower, final int higher) throws IOException {
		final int guess = (lower + higher) / 2;
		this.attempts++;
		// Binary search, start with the middle number
		System.out.print(
				"Is your guessed nummber -> " + guess + "? (Please enter higher, lower, yes or end to end the game.):");
		while (true) {
			final String input = bufferedReader.readLine();
			if (input != null && input.length() == 0) {
				System.out.println("Invalid input -> Null or blank.");
				System.out.print("Usage -> Enter higher, lower, yes or end the game.");
			} else if (input.equalsIgnoreCase(DecisionEnum.HIGHER.getTypeValue())) {
				tryGuess(guess + 1, higher);
			} else if (input.equalsIgnoreCase(DecisionEnum.LOWER.getTypeValue())) {
				tryGuess(lower, guess - 1);
			} else if (input.equalsIgnoreCase(DecisionEnum.YES.getTypeValue())) {
				System.out.println("Eureka !!! Found it in " + this.attempts + " attempts.");
				break;
			} else if (input.equalsIgnoreCase(DecisionEnum.END.getTypeValue())) {
				// stopping condition
				System.out.println("Game Over....Bye!!!");
				break;
			} else {
				System.out.println("Invalid input !!!");
				System.out.print("Usage -> Enter higher, lower, yes or end to end the game.");
			}
		}
	}

	/**
	 * Closes the buffered reader
	 */
	public void closeReader() {
		try {
			bufferedReader.close();
		} catch (final Exception ex) {
			System.err.println("Exception while closing the buffered reader");
		}
	}

	/**
	 * Getter for the BufferedReader
	 * 
	 * @return
	 */
	public BufferedReader getBufferedReader() {
		return this.bufferedReader;
	}

	/**
	 * Main method to run the program
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final GuessingNumberGame guessingNumberGame = new GuessingNumberGame();
		System.out.println("Think a number between 1 and 10 and enter ready to start guessing!!!");
		try {
			guessingNumberGame.tryGuess(1, 10);
		} catch (final IOException e) {
			System.out.println("Exception occured while doing IO operation");
			e.printStackTrace();
		} finally {
			guessingNumberGame.closeReader();
		}
	}
}