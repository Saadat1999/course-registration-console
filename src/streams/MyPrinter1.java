package streams;

public class MyPrinter1 implements Runnable {
    String text;

    public MyPrinter1(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        synchronized (MyPrinter1.class) {
            for(int i=0; i<10; i++) {
                FileWriter.writeToFile("streams.MyPrinter1.txt", text);
            }
        }
    }
}
