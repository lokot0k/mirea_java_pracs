package prac4;

import java.util.Arrays;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(3);
        for (int i = 0; i < 10; i++) {
            int taskNum = i;
            executorService.submit(() -> System.out.println("Number" + taskNum + " executed by thread " + Thread.currentThread().getName()));
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.err.println(e);
        }
        executorService.shutdown();
    }
}