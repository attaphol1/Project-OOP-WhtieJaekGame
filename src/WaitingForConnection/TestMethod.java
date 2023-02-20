package src.WaitingForConnection;

import java.util.Scanner;

public class TestMethod {
    public static void main(String[] args) {
        DefaltFramWin w = new DefaltFramWin();
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            w.playerOneWin(n); 
        }
    }
}
