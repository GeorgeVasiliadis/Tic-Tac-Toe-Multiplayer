import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements UI {
    private Pair activePair;
    private JButton[][] buttons;

    public GUI(int size){
        super();
        GridLayout grid = new GridLayout(size, size);
        this.setLayout(grid);
        activePair = new Pair(0,0);
        buttons = new JButton[size][size];
        JButton temp;
        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                int fx = x;
                int fy = y;
                temp = new JButton();
                temp.setPreferredSize(new Dimension(150,150));
                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        //activePair.x = fx;
                        //activePair.y = fy;
                        activePair = new Pair(fx,fy);
                    }
                });
                buttons[x][y] = temp;
                this.add(buttons[x][y]);
            }
        }
        this.pack();
        this.setVisible(true);
    }

    @Override
    public Pair makeMove(){
        return new Pair(activePair.x, activePair.y);
    }

    @Override
    public void updateBoard(Board board) {
        int size = board.getSize();
        for(int y=0; y<size; y++) {
            for (int x = 0; x < size; x++) {
                buttons[x][y].setText("" + symbol(board.getXY(x,y)));

            }
        }
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
