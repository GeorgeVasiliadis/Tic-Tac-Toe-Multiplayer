public class TicTacToe {
    private Board board;
    private UI gui;
    private int size;
    private int symbol;

    public TicTacToe(int size){
        board = new Board(size);
        gui = new CLI();
        this.size = size;
        boolean terminalState = false;
        symbol = 1;
        Pair pair;
        gui.updateBoard(board);
        while(!terminalState){
            while(true){
                pair = gui.makeMove();
                if(board.setXY(pair.x, pair.y, symbol)){
                    break;
                }
            }
            gui.updateBoard(board);
            if(symbolWins(symbol)){
                terminalState = true;
                congrats(symbol);
            } else if (isDraw()){
                terminalState = true;
                draw();
            }
            symbol *= -1;
        }

    }

    public TicTacToe(){
        this(3);
    }

    private boolean isDraw(){
        int current;

        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++) {
                current = board.getXY(x, y);
                if (current == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean symbolWins(int symbol){
        boolean threeInRow;

        // Check by rows
        for(int y=0; y<size; y++){
            threeInRow = true;
            for(int x=0; x<size; x++) {
                if (board.getXY(x, y) != symbol) {
                    threeInRow = false;
                    break;
                }
            }
            if(threeInRow){
                return true;
            }
        }

        // Check by columns
        for(int x=0; x<size; x++){
            threeInRow = true;
            for(int y=0; y<size; y++){
                if(board.getXY(x,y) != symbol){
                    threeInRow = false;
                    break;
                }
            }
            if(threeInRow){
                return true;
            }
        }

        // Check primary diagonal
        threeInRow = true;
        for(int i=0; i<size; i++){
            if(board.getXY(i,i) != symbol){
                threeInRow = false;
                break;
            }
        }
        if(threeInRow){
            return true;
        }

        // Check secondary diagonal
        threeInRow = true;
        for(int i=0; i<size; i++){
            if(board.getXY(i, size-i-1) != symbol){
                threeInRow = false;
                break;
            }
        }
        return threeInRow;

    }

    private void congrats(int symbol){
        if(symbol == 1){
            System.out.println("Player 1 Won!");
        } else {
            System.out.println("Player 2 Won!");
        }
    }

    private void draw(){
        System.out.println("The Game is Draw!");
    }
}
