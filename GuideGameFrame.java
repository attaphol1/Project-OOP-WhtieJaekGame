import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuideGameFrame {
    private JFrame frame;

    private JTextField text;

    public GuideGameFrame(){
        initVariable();
        initFrame();
    }

    public void initVariable(){
        frame = new JFrame("Guide Game");
        text = new JTextField();

    }

    public void initFrame(){
        text.setText("Hello Game");
        frame.add(text);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
