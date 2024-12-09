import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 extends Common {
    public static void main(String[] args) {
        String path = "";
        day3_2(read(path + "InputDay3"));
    }
    public static void day3_2(List<String> lines){
        Pattern pattern = Pattern.compile("mul\\([0-9]+\\,[0-9]+\\)");
        StringBuffer b =new StringBuffer();
        for(String line:lines){
            b.append(line);
        }
        String[] dos = b.toString().split("do\\(\\)");

        b =new StringBuffer();
        for(String d:dos){
            String[] donts = d.split("don't\\(\\)");
            String onlyDo = donts[0];
            System.out.println(onlyDo);
            b.append(onlyDo);
        }

        System.out.println(b);
        String p =b.toString();
        Matcher matcher = pattern.matcher(p);
        boolean isMatch = matcher.find();
        //once you find a match, remove it and store it in the arrayList.
        int sum = 0;
        while (isMatch) {

            String s = p.substring(matcher.start(), matcher.end()) ;
            System.out.println(s);
            //System.out.println(p.length());
            //Store it in an array
            //Remove it from the beginning of the string.
            p = p.substring(matcher.end(), p.length());
            matcher = pattern.matcher(p);
            isMatch = matcher.find();
            int aa = Integer.parseInt(s.substring(4,s.indexOf(",")));
            int bb = Integer.parseInt(s.substring(s.indexOf(",")+1, s.indexOf(")")));


            sum+=(aa*bb);
        }
        System.out.println(sum);
    }
    public static void day3_1(List<String> lines){
        Pattern pattern = Pattern.compile("mul\\([0-9]+\\,[0-9]+\\)");
        StringBuffer b =new StringBuffer();
        for(String line:lines){
            b.append(line);
        }
        System.out.println(b);
        String p =b.toString();
        Matcher matcher = pattern.matcher(p);
        boolean isMatch = matcher.find();
        //once you find a match, remove it and store it in the arrayList.
        int sum = 0;
        while (isMatch) {

            String s = p.substring(matcher.start(), matcher.end()) ;
            System.out.println(s);
            //System.out.println(p.length());
            //Store it in an array
            //Remove it from the beginning of the string.
            p = p.substring(matcher.end(), p.length());
            matcher = pattern.matcher(p);
            isMatch = matcher.find();
            int aa = Integer.parseInt(s.substring(4,s.indexOf(",")));
            int bb = Integer.parseInt(s.substring(s.indexOf(",")+1, s.indexOf(")")));


            sum+=(aa*bb);
        }
        System.out.println(sum);
    }
}
