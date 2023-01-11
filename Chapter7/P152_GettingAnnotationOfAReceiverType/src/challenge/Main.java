package challenge;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException,
            ClassNotFoundException, InvocationTargetException, InstantiationException
            , IllegalAccessException {

        Class<Melon> clazz = Melon.class;
        Method eatMethod = clazz.getDeclaredMethod("eat");

        AnnotatedType annotatedType = eatMethod.getAnnotatedReceiverType();

        // challenge.Melon
        System.out.println("TYpe: " + annotatedType.getType().getTypeName());

        // [@challenge.Ripe()]
        System.out.println("Annotations: "
                + Arrays.toString(annotatedType.getAnnotations()));


        // [interface java.lang.reflect.AnnotatedType]
        System.out.println("Class implementing interfaces: "
                + Arrays.toString(annotatedType.getClass().getInterfaces()));

        AnnotatedType annotatedOwnerType
                = annotatedType.getAnnotatedOwnerType();

        // null
        System.out.println("\nAnnotated owner type: " + annotatedOwnerType);

        Class<?> clazz2 = Class.forName("challenge.Melon");
        Constructor<Melon> melonConstructor = (Constructor<Melon>) clazz2.getConstructor(String.class, Integer.class);
        Melon melonInstance = melonConstructor.newInstance("melon2", 2000);

        // eat melon2
        melonInstance.eat();

        // eat melon2
        eatMethod.invoke(melonInstance);

    }
}
