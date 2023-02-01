package twoplayers;

/**
 * Class for Tic Tac Toe gameboard
 * 
 * @author Put Name Here
 */
public class GameBoard {

	/**
	 * An array of 9 GameTiles representing the TicTacToe gameboard
	 */
	GameTile[] board;

	/**
	 * Constructs an empty gameboard of 9 GameTiles and fills it with unowned tiles
	 */
	public GameBoard() {
		board = new GameTile[9];
		for (int i = 0; i < 9; i++)
			board[i] = new GameTile();
	}

	/**
	 * This will allow a player to claim a GameTile on the TicTacToe board
	 * 
	 * @return A boolean true if the player successfully played on a tile, false if
	 *         that tile is already owned or the index is out of bounds
	 * @param player A String indicating which player is to own the tile ("X" or
	 *               "O")
	 * @param tile   An integer representing the tile the player wishes to claim
	 */
	public boolean play(String player, int tile) {
		// Enter code for this method here
		if (!board[tile - 1].owned()) { // must -1 since array starts at 0
			board[tile - 1].setOwner(player);
			return true;
		}

		return false;
	}

	/**
	 * This will check to see if there are three tiles in a row belonging to a
	 * player
	 * 
	 * @return A boolean true if the player has three tiles in a row, false
	 *         otherwise
	 * @param player A String indicating which player to check for a win ("X" or
	 *               "O")
	 */
	public boolean checkWin(String player) {
//Enter code for this method here
		for (int i = 0; i < 3; i++) { // making a loop with a variable to not hard code the values
			// vertical check
			if (board[i].owner.equals(player) && board[i + 3].owner.equals(player)
					&& board[i + 6].owner.equals(player)) {
				return true;
			}

			// horizontal check
			else if (board[i * 3].owner.equals(player) && board[(i * 3) + 1].owner.equals(player)
					&& board[(i * 3) + 2].owner.equals(player)) {
				return true;
			}

			// diagonal check #1
			if (board[0].owner.equals(player) && board[4].owner.equals(player) && board[8].owner.equals(player)) {
				return true;
			}

			// diagonal check #2
			if (board[2].owner.equals(player) && board[4].owner.equals(player) && board[6].owner.equals(player)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This will draw the current gameboard on the screen
	 */
	public void drawBoard() {
		// Enter code for this method here
		for (int i = 0; i < 9; i++) {
			if (board[i].owner == null) {
				board[i].owner = " ";
			}
		}

		System.out.println(board[0].owner + " | " + board[1].owner + " | " + board[2].owner);
		System.out.println("---------");
		System.out.println(board[3].owner + " | " + board[4].owner + " | " + board[5].owner);
		System.out.println("---------");
		System.out.println(board[6].owner + " | " + board[7].owner + " | " + board[8].owner);

	}
}// end class
