// package src.WaitingForConnection;
// import javax.swing.*;
// import java.awt.*;

// import java.util.Timer;
// import java.util.TimerTask;

// public class WinGame extends JPanel {
//     private int numPointsPlayerOne = 0;
//     private int numPointsPlayerTwo = 0;
//     Graphics2D g2;
//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g2 = (Graphics2D) g;
//         g2.setStroke(new BasicStroke(5));

//         //----Body player one----//
//         g2.drawLine(50, 100, 50, 700);
//         g2.drawLine(50, 100, 250, 100);
//         g2.drawLine(250, 100, 250, 200);
        
//         if(numPointsPlayerOne > 0){ g2.drawOval(200, 200, 100, 100); }
//         if(numPointsPlayerOne > 1){ g2.drawLine(250, 300, 250, 500); }
//         if(numPointsPlayerOne > 2){ g2.drawLine(250, 350, 150, 400); }
//         if(numPointsPlayerOne > 3){ g2.drawLine(250, 350, 350, 400); }
//         if(numPointsPlayerOne > 4){ g2.drawLine(250, 500, 150, 550); }
//         if(numPointsPlayerOne > 5){ g2.drawLine(250, 500, 350, 550); } 
//         //----Body player one----//

//         //----Body player two----//
//         g2.drawLine(950, 100, 950, 700);
//         g2.drawLine(950, 100, 750, 100);
//         g2.drawLine(750, 100, 750, 200);

//         if(numPointsPlayerTwo > 0){ g2.drawOval(700, 200, 100, 100); }
//         if(numPointsPlayerTwo > 1){ g2.drawLine(750, 300, 750, 500); }
//         if(numPointsPlayerTwo > 2){ g2.drawLine(750, 350, 650, 400); }
//         if(numPointsPlayerTwo > 3){ g2.drawLine(750, 350, 850, 400); }
//         if(numPointsPlayerTwo > 4){ g2.drawLine(750, 500, 650, 550); }
//         if(numPointsPlayerTwo > 5){ g2.drawLine(750, 500, 850, 550); } 
//         //----Body player two----//
//     }

//     public void setPointsPlayerOne(int numPoints) {

//         Timer timer1 = new Timer();
//         timer1.schedule(new TimerTask() {
//             @Override
//             public void run() {
//                 numPointsPlayerOne = numPoints;
//                 repaint();
//             }    
//         },2000);
//     }

//     public void setPointsPlayerTwo(int numPoints) {

//         Timer timer1 = new Timer();
//         timer1.schedule(new TimerTask() {
//             @Override
//             public void run() {
//                 numPointsPlayerTwo = numPoints;
//                 repaint();
//             }    
//         },2000);
//     }

//     public void resetFrame(int numPoints){
//         Timer timer1 = new Timer();
//         timer1.schedule(new TimerTask() {
//             @Override
//             public void run() {
//                 repaint();
//             }    
//         },1000);
//     }
// }
