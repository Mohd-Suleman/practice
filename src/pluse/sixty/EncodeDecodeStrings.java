package pluse.sixty;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        String[] strs = {"Hello", "World", "Of", "Java"};
        String encoded = encodeStrings(strs);
        System.out.println("Encoded String: "+encoded);
        System.out.println("Decoded String: "+decode(encoded));
    }

    //Youtube: https://www.youtube.com/watch?v=B1k_sxOSgv8
    //GFG: https://www.geeksforgeeks.org/dsa/encode-and-decode-strings/#approach-2-escapebased-delimiter-encoding
    public static String encodeStrings(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for(String str: strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (i<str.length()) {
            int len = 0;
            while(str.charAt(i) != '#')
            {
                len = len*10 + (str.charAt(i)-'0');
                i++;
            }
            i++;
            String newStr = str.substring(i, i+len);
            list.add(newStr);
            i+=len;
        }
        return list;
    }

}
