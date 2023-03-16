package src.WaitingForConnection;

class TestMethod{
    public static void main(String[] args) {
        int i = 0;
        while(i < 10){
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                // Handle the exception
            }
            // Do something here after the delay
            System.out.println(i++);
        }
    }
}