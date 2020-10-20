import javax.swing.*;

public class TTTM_Controller {
    private TTTM_Model model;
    private TTTM_Viewer viewer;

    public TTTM_Controller(TTTM_Model model){
        this.model = model;
        this.viewer = new TTTM_Viewer(this, model);
    }

    public boolean makeMove(int x, int y){
        if(!model.makeMove(x,y)){
            return false;
        } else {
            int player = model.getLastPlayer();

            viewer.updateBoard(x, y, player);
            if (model.playerWins(player)) {
                viewer.info("Player" + (player == 1 ? "1" : "2") + " won!");
            } else if (model.isDraw()) {
                viewer.info("Game is Draw!");
            }
            return true;
        }
    }

    public JPanel getViewerPanel(){
        return viewer;
    }
}
