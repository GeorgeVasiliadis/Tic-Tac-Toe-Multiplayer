import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        super("TicTacToe - Multiplayer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0,1));
        controlPanel.setPreferredSize(new Dimension(200, 600));
        contentPane.add(controlPanel, BorderLayout.WEST);

        JPanel interactionPanel = new JPanel();
        interactionPanel.setLayout(new BorderLayout());
        interactionPanel.setPreferredSize(new Dimension(700,600));
        interactionPanel.setBackground(Color.green);
        contentPane.add(interactionPanel, BorderLayout.CENTER);

        interactionPanel.add(new TTTM_Controller(new TTTM_Model(3)).getViewerPanel());


        pack();
        setVisible(true);
    }
}
