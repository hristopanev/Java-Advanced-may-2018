import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

@Subject(categories = {"Test", "Pesho"})
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Reflection reflection = new Reflection();

        String name = reflection.getClass().getName();
        String simpleName = reflection.getClass().getSimpleName();

        Class clazz = Class.forName(name);
        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);

        Constructor constructor = clazz.getConstructors()[0];

        Reflection reflection1 = (Reflection) constructor.newInstance();

        System.out.println(reflection1.getWebAddress());

        System.out.println(clazz.getConstructors().length);
        Arrays.stream(clazz.getTypeParameters()).forEach(System.out::println);

        Method[] methods = clazz.getDeclaredMethods();
        Set<Method> getterMethod = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setterMethod = new TreeSet<>(Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                if (method.getParameterCount() == 0) {
                    getterMethod.add(method);
                }
            } else if (method.getName().startsWith("set")) {
                if (method.getParameterCount() == 1) {
                    if (void.class.equals(method.getReturnType())) {
                        setterMethod.add(method);
                    }
                }
            }
        }

        getterMethod.forEach(m -> System.out.println(m.getModifiers() + " " + m));
        setterMethod.forEach(System.out::println);

        getterMethod.stream()
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.println(m.getName() + " have to be public"));


        setterMethod
                .stream()
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.println(m.getName() + " have to be private"));

        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " have to be private"));


        
    }
}
