package basics;

// Slightly more lightweight than extending Thread
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        try {
            for(int i=0; i<5; i++) {
                System.out.println("Runnable is functional");
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
