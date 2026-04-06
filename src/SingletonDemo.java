import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        SingletonLazyLoading one = SingletonLazyLoading.getSingleton();
        SingletonLazyLoading tow = SingletonLazyLoading.getSingleton();
        System.out.println(one);
        System.out.println(tow);

        SingletonEagerLoading a = SingletonEagerLoading.getSingleton();
        SingletonEagerLoading b = SingletonEagerLoading.getSingleton();
        System.out.println(a);
        System.out.println(b);

        SingletonBillPush x = SingletonBillPush.getSingleton();
        SingletonBillPush y = SingletonBillPush.getSingleton();
        System.out.println(x);
        System.out.println(y);

        BreakSingleton first = BreakSingleton.getSingleton();
        System.out.println("Singleton Object: "+first);

        BreakSingleton second = BreakSingleton.breakSingletonUsingSerialization(first);
        System.out.println("Deserialized Object: "+second);

        System.out.println("Reflected Object: "+BreakSingleton.breakSingletonUsingReflection());

    }

}

class SingletonSynchronized {
    private static SingletonSynchronized INSTANCE;

    private SingletonSynchronized() {

    }

    public static synchronized SingletonSynchronized getSingleton() {
        if(INSTANCE==null){
            INSTANCE = new SingletonSynchronized();
        }
        return INSTANCE;
    }
}

class SingletonEagerLoading {
    private static final SingletonEagerLoading INSTANCE  = new SingletonEagerLoading();

    private SingletonEagerLoading() {

    }

    public static SingletonEagerLoading getSingleton(){
        return INSTANCE;
    }


}
class SingletonLazyLoading {
    private static SingletonLazyLoading INSTANCE;

    private SingletonLazyLoading() {

    }

    public static SingletonLazyLoading getSingleton(){
        if(INSTANCE==null) {
            INSTANCE = new SingletonLazyLoading();
        }
        return INSTANCE;
    }
}

class SingletonBillPush {
    private SingletonBillPush() {

    }

    private static class SingletonHelper {
        private static final SingletonBillPush INSTANCE = new SingletonBillPush();
    }

    public static SingletonBillPush getSingleton() {
        return SingletonHelper.INSTANCE;
    }
}

class BreakSingleton implements Serializable {
    private BreakSingleton() {

    }

    private static class SingletonHelper {
        private static final BreakSingleton INSTANCE = new BreakSingleton();
    }
    public static BreakSingleton getSingleton() {
        return SingletonHelper.INSTANCE;
    }

    /** Implement readResolve method to prevent  */

    protected  Object readResolve() {
        return SingletonHelper.INSTANCE;
    }


    public static BreakSingleton breakSingletonUsingSerialization(BreakSingleton INSTANCE) throws IOException, ClassNotFoundException {
        //Serializing object into file
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.txt"));
        out.writeObject(INSTANCE);
        out.close();

        //Deserializing object from  file
        ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.txt"));
        BreakSingleton INSTANCE2 = (BreakSingleton)input.readObject();
        return INSTANCE2;
    }

    /** Use Enum to prevent reflection  */
    public static BreakSingleton breakSingletonUsingReflection() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        BreakSingleton INSTANCE2 = null;

        Constructor[] constructors = BreakSingleton.class.getDeclaredConstructors();

        for(Constructor constructor: constructors) {
            constructor.setAccessible(true);
            INSTANCE2 =  (BreakSingleton)constructor.newInstance();
        }
        return INSTANCE2;
    }
}

/** This Enum will prevent reflection  */
enum SingletonEnum {
    INSTANCE;

}