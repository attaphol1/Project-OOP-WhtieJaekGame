import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuideGameFrame {
    private JFrame frame;

    private JPanel panel;

    private JLabel text;

    public GuideGameFrame(){
        initVariable();
        initFrame();
    }

    public void initVariable(){
        frame = new JFrame("Guide Game");
        text = new JLabel();
        panel = new JPanel();

    }

    public void initFrame(){
        text.setText("Guide Game");
        panel.add(text);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
