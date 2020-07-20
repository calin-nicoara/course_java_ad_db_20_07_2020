package ro.esolacad.javaad.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadIdSetter {

    private static ThreadLocal<Long> threadLocalId = new ThreadLocal<>();
    private static AtomicLong atomicLong = new AtomicLong(0);

    public static void setNewValue() {
        threadLocalId.set(atomicLong.incrementAndGet());
    }

    public static Long getThreadId() {
        return threadLocalId.get();
    }
}
