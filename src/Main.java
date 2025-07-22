import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter name of player 1 (X): ");
        String player1_name = scanner.next();
        System.out.print("Enter name of player 2 (O): ");
        String player2_name = scanner.next();

        // create player objects
        Player player1 = new Player(player1_name, 'X');
        Player player2 = new Player(player2_name, 'O');

        // game init
        Board board = new Board();
        Player current_player = player1;
        boolean game_ended = false;

        System.out.println("Game Started ...");
        board.printBoard();

        while(!game_ended) {
            System.out.print("turn of " + current_player.getName() + " (" + current_player.getSymbol() + ") [1-9]: ");
            int position;
            try {
                position = scanner.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("invalid input, please try again!");
                scanner.next(); // clear the invalid input
                continue;
            }

            if(board.makeMove(position, current_player.getSymbol())) {
                board.printBoard();

                if(board.checkWin(current_player.getSymbol())) {
                    game_ended = true;
                    System.out.println("Player " + current_player.getName() + " won!");
                } else if(board.isFull()) {
                    System.out.println("game is draw!");
                } else {
                    current_player = (current_player == player1) ? player2 : player1;
                }
            } else {
                System.out.println("invalid input, please try again!");
            }
        }

        scanner.close();
        System.out.println("game over!!!");
    }
}