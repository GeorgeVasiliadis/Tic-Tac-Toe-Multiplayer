import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTM_Setter extends JFrame {
    private boolean playLocally;
    private String username;
    private int size;
    private int PIN;


    private JPanel localSettings;
    private JPanel remoteSettings;

    public TTTM_Setter(){
        super("TTTM_Setter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(0,2));

        contentPane.add(new JLabel("Choose settings:"));

        contentPane.add(new JLabel("")); //Dummy for empty cell

        contentPane.add(new JLabel("Username:"));

        JTextField userNameText = new JTextField("Anonymous");
        contentPane.add(userNameText);

        contentPane.add(new JLabel("General Preferences"));

        JPanel generalPreferences = new JPanel();
        generalPreferences.setBorder(new TitledBorder(new EtchedBorder(), "Hello World!"));
        generalPreferences.setLayout(new GridLayout(0,2));

        generalPreferences.add(new JLabel("Size"));

        generalPreferences.add(new JTextField("3"));

        generalPreferences.add(new JLabel("Symbols"));

        generalPreferences.add(new JLabel("ToDo"));

        contentPane.add(generalPreferences);

        contentPane.add(new JLabel("Mode"));

        JCheckBox localGameCheckBox = new JCheckBox("Play locally");
        localGameCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton button = (AbstractButton) actionEvent.getSource();
                playLocally = button.isSelected();
                toggleSpecificSettings();
            }
        });

        contentPane.add(localGameCheckBox);

        contentPane.add(new JLabel("Specific settings"));

        JPanel specificSettings = new JPanel();
        specificSettings.setBorder(new TitledBorder(new EtchedBorder(), "Local\\Remote Game"));

        localSettings = new JPanel();
        localSettings.setVisible(playLocally);

        localSettings.add(new JLabel("Local Settings"));

        specificSettings.add(localSettings);



        remoteSettings = new JPanel();
        remoteSettings.setVisible(!playLocally);

        remoteSettings.add(new JLabel("Remote Settings"));

        specificSettings.add(remoteSettings);

        contentPane.add(specificSettings);

        JButton playButton = new JButton("Play!");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startGame();
            }});
        contentPane.add(playButton);

        pack();
        setVisible(true);
    }

    private void toggleSpecificSettings(){
        localSettings.setVisible(playLocally);
        remoteSettings.setVisible(!playLocally);
    }

    private void startGame(){
        new TTTM_Model(3);
    }
}
