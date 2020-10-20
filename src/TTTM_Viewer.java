import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTM_Viewer extends JPanel implements UI {
    private JButton[][] buttons;

    public TTTM_Viewer(TTTM_Controller controller, TTTM_Model model){
        super();

        int size = model.getSize();

        GridLayout grid = new GridLayout(size, size, 4, 4);
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
                        controller.makeMove(finalX, finalY);
                    }
                });
                this.add(buttons[x][y]);
            }
        }

        setVisible(true);
    }

    @Override
    public void run(){}

    @Override
    public void updateBoard(int x, int y, int symbol) {
        buttons[x][y].setText("" + toSymbol(symbol));
    }

    @Override
    public void info (String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private char toSymbol(int symbol){
        if(symbol == 1){
            return 'X';
        } else if(symbol == -1){
            return 'O';
        } else {
            return ' ';
        }
    }
}
