package src.WaitingForConnection;
import javax.swing.JFrame;

public class DefaltFramWin {
    WinGame panel;
    public DefaltFramWin(){
        JFrame frame = new JFrame("Win");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new WinGame();
        frame.add(panel);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    void playerOneWin(int points) {
        panel.setPointsPlayerTwo(points);
    }

    void playerTwoWin(int points) {
        panel.setPointsPlayerOne(points);
    }
}