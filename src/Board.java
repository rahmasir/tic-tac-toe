public class Board {
    private final char[][] board;
    private static final int SIZE = 3;

    public Board() {
        this.board = new char[SIZE][SIZE];
        char count = '1';
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                board[i][j] = count++;
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for(int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for(int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean makeMove(int position, char symbol) {
        if(position < 1 || position > 9)
            return false;
        int row = (position - 1) / SIZE;
        int col = (position - 1) % SIZE;

        if(board[row][col] == 'X' ||  board[row][col] == 'O')
            return false; // already taken

        board[row][col] = symbol;
        return true;
    }

    public boolean isFull() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(board[i][j] == 'O' || board[i][j] == 'X')
                    return false;
            }
        }
        return true;
    }

    public boolean checkWin(char symbol) {
        for(int i = 0; i < SIZE; i++) {
            if(
                (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
            ) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol));
    }
}
