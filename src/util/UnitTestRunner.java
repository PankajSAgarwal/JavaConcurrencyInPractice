package util;

import junit.framework.*;
import junit.textui.*;

public class UnitTestRunner {
    private static void run(Class<?> clazz) {
        System.out.println("Running unit tests for " + clazz);
        TestRunner.run(new JUnit4TestAdapter(clazz));
    }

    public static void run() {
        MySecurityManager sm = new MySecurityManager();
        Class<?> clazz = sm.getClassContext()[2];
        run(clazz);
    }

    private static class MySecurityManager extends SecurityManager {
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }
}