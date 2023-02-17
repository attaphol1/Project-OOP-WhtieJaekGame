import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class GuideGameFrame {
    private JFrame frame;
    private JLabel welcome;
    private JTextArea rule;

    GuideGameFrame(){
        setText();
        frameGuide();
    }
    void setText(){
        frame = new JFrame("Guide Game");
        welcome = new JLabel("<html><pre> __          __  _                            _         __          ___     _ _       _            _    <br>"+
                                        " \\ \\        / / | |                          | |        \\ \\        / / |   (_) |     (_)          | |   <br>"+
                                        "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___    \\ \\  /\\  / /| |__  _| |_ ___ _  __ _  ___| | __<br>"+
                                        "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\    \\ \\/  \\/ / | '_ \\| | __/ _ \\ |/ _` |/ __| |/ /<br>"+
                                        "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |    \\  /\\  /  | | | | | ||  __/ | (_| | (__|   &lt; <br>"+
                                        "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/      \\/  \\/   |_| |_|_|\\__\\___| |\\__,_|\\___|_|\\_\\<br>"+
                                        "                                                                                    _/ |                <br>"+
                                        "                                                                                   |__/                 <br>"+
                                        "</pre></html>");
                                        
        rule = new JTextArea           ("Here are some basic strategies for playing blackjack:\n"+
                                        "\tAlways assume the dealer's face down card is a 10.This means if the dealer has a face up 7,\n"+
                                        "assume their total is 17. If your hand value is 11 or less, always hit. If your hand value is 17 or more,\n"+
                                        "always stand. If the dealer's face up card is a 2 through 6, consider doubling down on a hand value of 9 or\n"+
                                        "10. If the dealer's face up card is a 7 or higher, and your hand value is 12-16, consider standing.\n"+
                                        "These are just a few basic rules and strategies for playing blackjack. As you play more, you will develop\n"+
                                        "your own preferred strategies and techniques. Remember, while the game is simple to learn, mastering it\n"+
                                        "requires time and practice.");
        welcome.setBounds(20, 0, 860, 200);
        welcome.setFont(new Font("Courier",Font.BOLD, 14));
        rule.setBounds(40, 200, 820, 300);
        rule.setBackground(null);
        rule.setFont(new Font("Courier", Font.PLAIN, 16));
        rule.setEditable(false);
    }
    
    void frameGuide(){
        frame.add(welcome);
        frame.add(rule);
        frame.setSize(900,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
