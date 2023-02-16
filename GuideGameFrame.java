import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class GuideGameFrame {
    private JFrame frame;
    private JLabel welcome;
    private JLabel rule;

    GuideGameFrame(){
        setText();
        frameGuide();
    }
    void setText(){
        frame = new JFrame("   Label Example");
        welcome = new JLabel("<html><pre> __          __  _                            _         __          ___     _ _       _            _    <br>"+
                                        " \\ \\        / / | |                          | |        \\ \\        / / |   (_) |     (_)          | |   <br>"+
                                        "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___    \\ \\  /\\  / /| |__  _| |_ ___ _  __ _  ___| | __<br>"+
                                        "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\    \\ \\/  \\/ / | '_ \\| | __/ _ \\ |/ _` |/ __| |/ /<br>"+
                                        "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |    \\  /\\  /  | | | | | ||  __/ | (_| | (__|   &lt; <br>"+
                                        "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/      \\/  \\/   |_| |_|_|\\__\\___| |\\__,_|\\___|_|\\_\\<br>"+
                                        "                                                                                    _/ |                <br>"+
                                        "                                                                                   |__/                 <br>"+
                                        "</pre></html>");
                                        
        rule = new JLabel           ("<html><pre>"+"Here are some basic strategies for playing blackjack:<br>"+
                                        "<br>"+
                                        "Always assume the dealer's face down card is a 10. <br>This means if the dealer has a face up 7, assume their total is 17.<br>"+
                                        "If your hand value is 11 or less, always hit. If your hand value is 17 or more, always stand.<br>"+
                                        "If the dealer's face up card is a 2 through 6, consider doubling down on a hand value of 9 or 10.<br>"+
                                        "If the dealer's face up card is a 7 or higher, and your hand value is 12-16, consider standing.<br>"+
                                        "These are just a few basic rules and strategies for playing blackjack. As you play more,<br>you will develop your own preferred strategies and techniques.<br>Remember, while the game is simple to learn, mastering it requires time and practice.<br>"
                                        +"</pre></html>");
        welcome.setBounds(0, 0, 1500, 150);
        welcome.setForeground(Color.GREEN);
        rule.setBounds(20, 190, 900, 200);
        rule.setForeground(Color.green);
        rule.setFont(new Font("Arial", Font.PLAIN, 15));
    }
    
    void frameGuide(){
        frame.add(welcome);
        frame.add(rule);
        frame.setSize(900,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
    }
}
