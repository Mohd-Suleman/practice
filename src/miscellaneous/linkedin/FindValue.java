package miscellaneous.linkedin;

public class FindValue {
    public static void main(String arg[]) {
        for(int i = 0; i < 5; i = increment(i))
            System.out.print(i+" ");

    }

    private static int increment(int i) {
        int num = (++i) + (i++) ;
        return num;
    }
}
