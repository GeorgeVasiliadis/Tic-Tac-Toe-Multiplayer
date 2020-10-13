public class TicTacToe {
    private Board board;
    private UI ui;
    private int size;
    private int symbol;

    public TicTacToe(int size){
        board = new Board(size);
        this.size = size;
        symbol = 1;
        ui = new GUI(this, board);
        ui.run();
    }

    public void makeMove(int x, int y){
        if(!board.setXY(x, y, symbol)) {
            return;
        }
        ui.updateBoard(board);
        if(symbolWins(symbol)) {
            ui.info("Player" + (symbol == 1 ? "1" : "2") + " won!");
            exit();
        } else if (isDraw()){
            ui.info("Game is Draw!");
            exit();
        }
        symbol *= -1;
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

    private void exit(){
        ui.info("Goodbye");
        System.exit(0);
    }
}
