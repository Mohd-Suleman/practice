import java.util.ArrayList;
import java.util.List;

public class Convert2DArrayTo1D {
    public static void main(String arg[]) {
        converter();
//        /*for(String str: converter())
//            System.out.println(str);*/

    }
    public static String[] converter() {
        String[][] data = {{"a","b"},{"c","d"},{"e","f"}};
        List<String> list = new ArrayList<>();
        int size = data.length-1;

        for(int i = 0; i<size; i++) {
            for(int j = i; j<size; j++) {
                System.out.println(data[i][j]);
                list.add(data[i][j]);
            }
        }

        return list.toArray(new String[0]);
    }

}
