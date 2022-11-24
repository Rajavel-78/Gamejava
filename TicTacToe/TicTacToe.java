import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	private Scanner scanner = new Scanner(System.in);
	static String bord[] = new String[9];
	static String trun = "X";

	public static void main(String[] args) {
		System.out.println("WELCOME TO Tic Tac Toe");
		for (int i = 0; i < 9; i++) {
			bord[i] = String.valueOf(i + 1);
		}
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.printBord();
		ticTacToe.startGame();
	}

	public void printBord() {
		System.out.println("|___________|");
		System.out.println("|           |");
		System.out.println("| " + bord[0] + " | " + bord[1] + " | " + bord[2] + " |");
		System.out.println("|           |");
		System.out.println("| " + bord[3] + " | " + bord[4] + " | " + bord[5] + " |");
		System.out.println("|           |");
		System.out.println("| " + bord[6] + " | " + bord[7] + " | " + bord[8] + " |");
		System.out.println("|___________|");
	}

	public void startGame() {
		String winner = "";
		while (winner.equals("")) {
			System.out.println("ENTER THE INPUTS");
			int position = scanner.nextInt();
			if (position > 0 && position <= 9) {

			} else {
				System.out.println("Out of Position");
				continue;
			}
			if (!(bord[position - 1]).equals("X") && !(bord[position - 1]).equals("O")) {
				bord[position - 1] = trun;
			} else {
				System.out.println("Position is Already exites");
				continue;
			}
			if (trun.equals("X")) {
				trun = "O";
			} else {
				trun = "X";
			}
			this.printBord();
			winner = checkOption();
			if (winner.equals("X") || winner.equals("O")) {
				System.out.println(winner + " is winner");
			}
			if (winner.equals("draw")) {
				System.out.println("Draw");
			}
		}
	}

	private String checkOption() {
		String line = "";
		for (int i = 0; i < 9; i++) {
			line = "";
			switch (i) {
			case 0:
				line = bord[0] + bord[1] + bord[2];
				break;
			case 1:
				line = bord[3] + bord[4] + bord[5];
				break;
			case 2:
				line = bord[6] + bord[7] + bord[8];
				break;
			case 3:
				line = bord[0] + bord[3] + bord[6];
				break;
			case 4:
				line = bord[1] + bord[4] + bord[7];
				break;
			case 5:
				line = bord[2] + bord[5] + bord[8];
				break;
			case 6:
				line = bord[0] + bord[4] + bord[8];
				break;
			case 7:
				line = bord[2] + bord[4] + bord[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			}
			if (line.equals("OOO")) {
				return "O";
			}
		}
		int count = 0;
		for (int j = 0; j <= 8; j++) {

			if ((!(bord[j].equals("X")) && !(bord[j].equals("O")))) {

				count++;
			}
		}
		if (count == 0) {
			return "draw";
		}
		return "";
	}
}