import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JPanel Main_Panel;



    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(new Main().Main_Panel);
        frame.pack();
        frame.setVisible(true);


    }

}
