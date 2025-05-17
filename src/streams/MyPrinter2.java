package streams;

public class MyPrinter2 implements Runnable {
    String text;


    public MyPrinter2(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for(int i=0; i< 10; i++) {
            FileWriter.writeToFile("streams.MyPrinter2.txt", text);
        }
    }
}
