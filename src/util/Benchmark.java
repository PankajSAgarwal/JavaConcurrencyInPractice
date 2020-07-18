package util;

import java.lang.management.*;

/**
 * DO NOT CHANGE.
 */
public class Benchmark {
    private static final ThreadMXBean tmbean =
            ManagementFactory.getThreadMXBean();
    private static final long CONVERSION = 1_000_000;

    private long cpuTime;
    private long elapsedTime;
    private long userTime;

    public void start() {
        cpuTime = getCurrentThreadCPUTime();
        userTime = getCurrentThreadUserTime();
        elapsedTime = getCurrentElapsedTime();
    }

    public void stop() {
        cpuTime = getCurrentThreadCPUTime() - cpuTime;
        userTime = getCurrentThreadUserTime() - userTime;
        elapsedTime = getCurrentElapsedTime() - elapsedTime;
    }

    private static long getCurrentElapsedTime() {
        return System.currentTimeMillis();
    }

    private static long getCurrentThreadUserTime() {
        return tmbean.getCurrentThreadUserTime() / CONVERSION;
    }

    private static long getCurrentThreadCPUTime() {
        return tmbean.getCurrentThreadCpuTime() / CONVERSION;
    }

    public String toString() {
        return "cpu=" + cpuTime + ",user=" + userTime + ",elapsed=" +
                elapsedTime;
    }
}
