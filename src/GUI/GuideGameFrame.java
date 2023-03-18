package src.GUI;
import java.awt.Font;
import javax.swing.*;

public class GuideGameFrame {
    private JFrame frame;
    private JLabel welcome;
    private JTextArea rule;

    public GuideGameFrame(){
        setText();
        frameGuide();
    }
    void setText(){
        frame = new JFrame("How to play");
        welcome = new JLabel("<html><pre> __          __  _                            _         __          ___     _ _       _            _    <br>"+
                                        " \\ \\        / / | |                          | |        \\ \\        / / |   (_) |     (_)          | |   <br>"+
                                        "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___    \\ \\  /\\  / /| |__  _| |_ ___ _  __ _  ___| | __<br>"+
                                        "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\    \\ \\/  \\/ / | '_ \\| | __/ _ \\ |/ _` |/ __| |/ /<br>"+
                                        "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |    \\  /\\  /  | | | | | ||  __/ | (_| | (__|   &lt; <br>"+
                                        "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/      \\/  \\/   |_| |_|_|\\__\\___| |\\__,_|\\___|_|\\_\\<br>"+
                                        "                                                                                    _/ |                <br>"+
                                        "                                                                                   |__/                 <br>"+
                                        "</pre></html>");
                                        
        rule = new JTextArea           ("\t\t\t\t--------How to play--------\n\n"+
                                            "⚫ ให้ผู้เล่นจั่วการ์ดจนท่านพอใจในผลรวม แต่ผลรวมต้องไม่เกินตัวเลข Victory ที่สุ่มมา (21 - 41)\n"+
                                            "⚫ โดยในแต่ละรอบ จะสลับกันว่าใครจะได้จั่วก่อน\n"+
                                            "⚫ จากนั้นกดปุ่ม \"Stand\" หมายถึงปุ่มพอใจกับผลรวมการ์ดในมือ\n"+
                                            "⚫ หากใครชนะในรอบนั้น จะแสดงหน้าจอสำหรับต่อตัวละคร\n"+
                                            "⚫ ถ้าใครต่อตัวละครได้ครบก่อน จะเป็นผู้ชนะที่แท้จริง!!!\n"+
                                            "⚫ การตรวจสอบผลแพ้-ชนะ\n"+
                                            "   ⚫ ถ้าผลรวมเท่ากับเลข Victory --> win\n"+
                                            "   ⚫ ถ้าผลรวมมากกว่าฝั่งตรงข้าม แต่ไม่เกินตัวเลข Victory --> win\n"+
                                            "   ⚫ ถ้าผลรวมเกินเลข Victory --> lose\n"+
                                            "   ⚫ ถ้าผลรวมน้อยกว่าฝั่งตรงข้าม --> lose"
                                        );
        welcome.setBounds(20, 0, 860, 200);
        welcome.setFont(new Font("Courier",Font.BOLD, 13));
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
        frame.setLocationRelativeTo(null);
    }
}
