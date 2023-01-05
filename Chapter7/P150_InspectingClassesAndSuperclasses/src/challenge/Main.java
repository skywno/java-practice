package challenge;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Pair pair = Pair.of(5, 4);
        Class<?> clazz = pair.getClass();

        System.out.println("clazz.getName() = " + clazz.getName());

        System.out.println("clazz.getSimpleName() = " + clazz.getSimpleName());

        System.out.println("clazz.getCanonicalName() = " + clazz.getCanonicalName());

        clazz = Pair.class;
        System.out.println("clazz.getName() = " + clazz.getName());
        clazz = Class.forName("challenge.Pair");
        System.out.println("clazz.getName() = " + clazz.getName());

        int modifiers = clazz.getModifiers();

        System.out.println("Is Pair class public? "
                + Modifier.isPublic(modifiers)); // true
        System.out.println("Is Pair class final? "
                + Modifier.isFinal(modifiers)); // true
        System.out.println("Is Pair class abstract? "
                + Modifier.isAbstract(modifiers)); // false

        System.out.println("Is Tuple class abstract? " + Modifier.isAbstract(Class.forName("challenge.Tuple").getModifiers()));

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("interfaces = " + Arrays.toString(interfaces));

        Constructor<?>[] constructors = clazz.getConstructors();

        // public modern.challenge.Pair(java.lang.Object,java.lang.Object)
        System.out.println("Constructors: " + Arrays.toString(constructors));

        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fields = " + Arrays.toString(fields));
        List<String> fieldsNames =
                Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
        System.out.println("fieldsNames = " + fieldsNames);

        Module module = clazz.getModule();
        System.out.println("module = " + module);

        Class<?> superClass = clazz.getSuperclass();
        // modern.challenge.Tuple
        System.out.println("Superclass: " + superClass.getName());

        System.out.println("clazz.toGenericString() = " + clazz.toGenericString());
        System.out.println("Runnable.class.toGenericString() = " + Runnable.class.toGenericString());
        System.out.println("Map.class.toGenericString() = " + Map.class.toGenericString());
    }
}
