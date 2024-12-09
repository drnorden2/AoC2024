import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main2 extends Common{
    public static void main(String[] args) {
        String path = "";
        day2_2(read(path+"InputDay2"));

    }
    public static void day2_2(List<String> lines){
        int count=0;
        int negCount=0;
        for(String line:lines){
            String[]report = line.trim().split(" ");
            boolean isSafe = true;
            for(int i =0;i<report.length;i++) {
                isSafe = true;
                Integer last = null;
                int sign = 0;
                int cntLevel =0;
                for (String level : report) {
                    if(cntLevel++==i){
                        continue;
                    }
                    int levelNr = Integer.parseInt(level);
                    if (last != null) {
                        int diff = levelNr - last;
                        if (diff == 0) {
                            isSafe = false;
                            break;
                        }
                        if (sign == 0) {
                            sign = Math.abs(diff) / diff;
                        }
                        if ((sign != (int) Math.abs(diff) / diff) || (Math.abs(diff) > 3)) {
                            isSafe = false;
                            break;
                        }
                    }
                    last = levelNr;
                }
                if(isSafe){
                    break;
                }
            }
            if(isSafe){
                System.out.println("Safe:"+line);

                count++;
            }else{
                negCount++;
            }

        }
        System.out.println("In total "+count+" reports are safe and "+negCount+" are unsafe");
    }

    public static void day2_1(List<String> lines){
        int count=0;
        int negCount=0;
        for(String line:lines){
            String[]report = line.trim().split(" ");
            Integer last = null;
            boolean isSafe =true;
            int sign =0;
            for(String level:report){
                int levelNr = Integer.parseInt(level);
                if(last!=null){
                    int diff = levelNr-last;
                    if(diff==0){
                        isSafe=false;
                        break;
                    }
                    if(sign ==0){
                        sign = Math.abs(diff)/diff;
                    }
                    if((sign != (int)Math.abs(diff)/diff) || (Math.abs(diff)>3) ){
                        isSafe=false;
                        break;
                    }
                }
                last = levelNr;
            }
            if(isSafe){
                System.out.println("Safe:"+line);

                count++;
            }else{
                negCount++;
            }

        }
        System.out.println("In total "+count+" reports are safe and "+negCount+" are unsafe");
    }


}