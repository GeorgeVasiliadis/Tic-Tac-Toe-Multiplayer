public class TTTM_Model {
    private Board board;
    private int size;
    private int player;

    public TTTM_Model(int size){
        board = new Board(size);
        this.size = size;
        player = -1;
    }

    public int getSize(){
        return size;
    }

    public boolean makeMove(int x, int y){
        if(!board.setXY(x, y, getNextPlayer())) {
            return false;
        } else {
            player = getNextPlayer();
            return true;
        }
    }

    public boolean isDraw(){
        int cell;

        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++) {
                cell = board.getXY(x, y);
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean playerWins(int player){
        boolean threeInRow;

        // Check by rows
        for(int y=0; y<size; y++){
            threeInRow = true;
            for(int x=0; x<size; x++) {
                if (board.getXY(x, y) != player) {
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
                if(board.getXY(x,y) != player){
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
            if(board.getXY(i,i) != player){
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
            if(board.getXY(i, size-i-1) != player){
                threeInRow = false;
                break;
            }
        }
        return threeInRow;
    }

    public int getNextPlayer(){
        return -player;
    }
    public int getLastPlayer(){ return player;}
}
