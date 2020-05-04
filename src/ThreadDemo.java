import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadDemo {

    static AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) {
        new Thread(() -> process("T1")).start();
        new Thread(() -> process("T2")).start();
        new Thread(() -> process("T3")).start();
    }

    public static void process(String name) {
        System.out.println(name + " -> " + i.incrementAndGet());
    }
}
