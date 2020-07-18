package util;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

import static org.junit.Assert.*;

/**
 * DO NOT CHANGE.
 */
public class TestHelpers {
    public static void assertTypeIsAnnotated(
            Class<? extends Annotation> annotation, Class<?> type) {
        assertNotNull(
                type.getSimpleName() + " not annotated with @" +
                        annotation.getCanonicalName(),
                type.getAnnotation(annotation));
    }

    public static void assertMethodIsAnnotated(
            Class<? extends Annotation> annotation, Class<?> type,
            String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method method = type.getDeclaredMethod(methodName, parameterTypes);
        assertMethodIsAnnotated(annotation, method);
    }

    public static void assertMethodIsAnnotated(
            Class<? extends Annotation> annotation, Method method) {
        assertNotNull(
                method + " not annotated with @" +
                        annotation.getCanonicalName(),
                method.getAnnotation(annotation));
    }

    public static void assertFieldIsAnnotated(
            Class<? extends Annotation> annotation, Class<?> type,
            String fieldName) throws NoSuchFieldException {
        Field field = type.getDeclaredField(fieldName);
        assertFieldIsAnnotated(annotation, field);
    }

    public static void assertFieldIsAnnotated(
            Class<? extends Annotation> annotation, Field field) {
        assertNotNull(
                field + " not annotated with @" +
                        annotation.getCanonicalName(),
                field.getAnnotation(annotation));
    }

    public static <E> Collection<Class<? extends E>> getClassesExtending(
            Class<E> rootClass, String pattern) throws ClassNotFoundException {
        ArrayList<Class<? extends E>> classes = new ArrayList<Class<? extends E>>();
        File dir = findOriginClassPath(rootClass, pattern);
        for (String filename : dir.list()) {
            if (filename.endsWith(".class")) {
                Class<?> c = Class.forName(pattern.replace('/', '.') + "." + filename.split("\\.")[0], true, Thread.currentThread().getContextClassLoader());
                if (rootClass.isAssignableFrom(c) && c != rootClass) {
                    classes.add(c.asSubclass(rootClass));
                }
            }
        }
        return classes;
    }

    private static <E> File findOriginClassPath(Class<E> rootClass, String pattern) throws ClassNotFoundException {
        String classpathEntry = whereis(rootClass);

        File dir = new File(classpathEntry + pattern);
        System.out.println("dir = " + dir);
        if (dir.isDirectory()) {
            return dir;
        }
        return null;
    }

    public static String whereis(Class<?> clazz) {
        return whereis(clazz.getName(), clazz.getClassLoader());
    }

    public static String whereis(String className, ClassLoader classloader) {
        String filename = className.replace('.', '/') + ".class";
        if (classloader == null)
            classloader = ClassLoader.getSystemClassLoader();
        String url = classloader.getResource(filename).toString();

        String result = url.substring(5, url.length() - className.length() - 6);
        System.out.println("result = " + result);
        return result;
    }
}