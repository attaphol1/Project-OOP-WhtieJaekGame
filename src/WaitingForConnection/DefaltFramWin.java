package src.WaitingForConnection;
import java.util.Scanner;
import javax.swing.JFrame;

public class DefaltFramWin {
    DefaltFramWin(){
        JFrame frame = new JFrame("Win");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WinGame panel = new WinGame();
        frame.add(panel);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        readNumPoints(panel);
    }

    void readNumPoints(WinGame panel) {
    //     Scanner scanner = new Scanner(System.in);
    //     while (true) {
    //         System.out.print("Enter the number of points (0 to quit): ");
    //         int numPoints = scanner.nextInt();
    //         if (numPoints == 0) {
    //             break;
    //         }
    //         panel.setNumPoints(numPoints);
    //     }
    //    scanner.close();
    }
}