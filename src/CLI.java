import java.util.Scanner;

public class CLI implements UI {
    private TTTM_Model parent;
    private Board board;

    public CLI(TTTM_Model parent, Board board){
        this.parent = parent;
        this.board = board;
    }

    @Override
    public void run(){
        updateBoard(1,111,1);
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("x: ");
            int x = scanner.nextInt();
            System.out.print("y: ");
            int y = scanner.nextInt();
            parent.makeMove(x, y);
        }

    }

    @Override
    public void updateBoard(int x, int y, int symbol){
        int size = board.getSize();
        System.out.print("   ");
        for(int xg=0; x<size; x++){
            System.out.print("  " + x + " ");
        }
        System.out.println("");

        for(int yg=0; y<size; y++){

            System.out.print("   -");
            for(int i=0; i<size; i++){
                System.out.print("----");
            }
            System.out.println("");
            System.out.print(y +"  |");
            for(int xg=0; x<size; x++){
                System.out.print(" " + symbol(board.getXY(x,y)) + " |");
            }
            System.out.println("");
        }
        System.out.print("   -");
        for(int i=0; i<size; i++){
            System.out.print("----");
        }
        System.out.println("");
    }

    @Override
    public void info(String message){
        System.out.println(message);
    }

    private char symbol(int symbol){
        if(symbol == 1){
            return 'X';
        } else if(symbol == -1){
            return 'O';
        } else {
            return ' ';
        }
    }
}
