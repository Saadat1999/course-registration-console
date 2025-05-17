package streams;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        MyPrinter1 printer = new MyPrinter1(System.nanoTime()+" Hello\n");
        MyPrinter1 printer2 = new MyPrinter1(System.nanoTime()+" Bye\n");

        MyPrinter2 printer3 = new MyPrinter2(System.nanoTime()+" Hello\n");
        MyPrinter2 printer4 = new MyPrinter2(System.nanoTime()+" Bye\n");

        ExecutorService exc = Executors.newCachedThreadPool();
        exc.execute(printer);
        exc.execute(printer2);
        exc.execute(printer3);
        exc.execute(printer4);


        exc.shutdown();
        exc.awaitTermination(1, TimeUnit.SECONDS);
    }
}
