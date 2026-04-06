public class TestStringSlash {
    public static void main(String arg[]) throws InterruptedException {
        String str = "hello"+ "\\," +"Java";
        String newStr = str;
        System.out.println(str);
        Thread.sleep(1000);
        System.out.println(str);
    }
}
