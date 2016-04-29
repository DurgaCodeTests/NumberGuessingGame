/**
 * 
 */
package codingtest.compugain.guess.numberguess;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Test;

import codingtest.compugain.guess.GuessingNumberGame;

/**
 * @author Durgaprasad
 *
 */
public class GuessingNumberGameTest {

	/**
	 * Test method for
	 * {@link codingtest.compugain.guess.GuessingNumberGame#tryGuess(int, int)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGuessIt() throws IOException {
		GuessingNumberGame mockedGuessingNumberGame = mock(GuessingNumberGame.class);
		mockedGuessingNumberGame.tryGuess(1, 2);
		verify(mockedGuessingNumberGame, atMost(1));
	}

	/**
	 * Test method for
	 * {@link codingtest.compugain.guess.GuessingNumberGame#getBufferedReader()}
	 * .
	 */
	/*
	 * @Test public void testGetBufferedReader() { GuessingNumberGame
	 * guessingNumberGame = mock(GuessingNumberGame.class);
	 * when(guessingNumberGame.getBufferedReader()).thenReturn(mock(
	 * BufferedReader.class)); verify(guessingNumberGame).getBufferedReader(); }
	 */
}
