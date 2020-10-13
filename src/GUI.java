import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements UI {
    private JButton[][] buttons;

    public GUI(TicTacToe parent, Board board){
        super("Tic-Tac-Toe-Multiplayer");

        int size = board.getSize();

        GridLayout grid = new GridLayout(size, size);
        setLayout(grid);

        buttons = new JButton[size][size];
        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                int finalX = x;
                int finalY = y;
                buttons[x][y] = new JButton();
                buttons[x][y].setPreferredSize(new Dimension(150,150));
                buttons[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        parent.makeMove(finalX, finalY);
                    }
                });
                this.add(buttons[x][y]);
            }
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run(){}

    @Override
    public void updateBoard(Board board) {
        int size = board.getSize();
        for(int y=0; y<size; y++) {
            for (int x = 0; x < size; x++) {
                buttons[x][y].setText("" + symbol(board.getXY(x,y)));

            }
        }
    }

    @Override
    public void info (String message){
        JOptionPane.showMessageDialog(null, message);
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
