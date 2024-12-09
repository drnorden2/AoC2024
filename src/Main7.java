import java.util.Arrays;
import java.util.List;

public class Main7  extends Common {
    public static void main(String[] args) {
        String path = "";
        day7_2(read(path + "InputDay7"));
    }
    public static void day7_2(List<String> lines) {
        long sum = 0;

        for(String line:lines){
            String[] leftRight = line.split(":");
            long result = Long.parseLong(leftRight[0]);
            String[] numbersStr = leftRight[1].trim().split(" ");
            long[] numbers = new long[numbersStr.length];
            for(int i=0;i< numbersStr.length;i++){
                numbers[i] = Long.parseLong(numbersStr[i]);
            }


            System.out.println(result+":"+ Arrays.toString(numbers));
            int options = (int)Math.pow(3,numbers.length-1);
            for(int i=0;i<options;i++){
                String binary = "0000000000000000000000000"+convertIntToBase(i,3);
                binary = binary.substring(binary.length()-(numbers.length-1));
                long output = numbers[0];
                String str = ""+numbers[0];
                for(int j=0;j<binary.length();j++){
                    if(binary.charAt(j)=='0'){
                        output+=numbers[j+1];
                        str +="+"+numbers[j+1];
                    }else if(binary.charAt(j)=='1'){
                        output*=numbers[j+1];
                        str +="*"+numbers[j+1];
                    }else{
                        output = Long.parseLong(""+output+""+numbers[j+1]);
                        str +="||"+numbers[j+1];
                    }
                }
                //System.out.println(str);
                if(output==result){
                    sum +=result;
                    System.out.println(result+"="+str);
                    break;
                }
            }
        }
        System.out.println("sum:"+sum);
    }
    public static void day7_1(List<String> lines) {
        long sum = 0;

        for(String line:lines){
            String[] leftRight = line.split(":");
            long result = Long.parseLong(leftRight[0]);
            String[] numbersStr = leftRight[1].trim().split(" ");
            long[] numbers = new long[numbersStr.length];
            for(int i=0;i< numbersStr.length;i++){
                numbers[i] = Long.parseLong(numbersStr[i]);
            }


            System.out.println(result+":"+ Arrays.toString(numbers));
            int options = (int)Math.pow(2,numbers.length-1);
            for(int i=0;i<options;i++){
                String binary = "0000000000000000000000000"+convertIntToBase(i,2);
                binary = binary.substring(binary.length()-(numbers.length-1));
                long output = numbers[0];
                String str = ""+numbers[0];
                for(int j=0;j<binary.length();j++){
                    if(binary.charAt(j)=='0'){
                        output+=numbers[j+1];
                        str +="+"+numbers[j+1];
                    }else{
                        output*=numbers[j+1];
                        str +="*"+numbers[j+1];
                    }
                }
                //System.out.println(str);
                if(output==result){
                    sum +=result;
                    System.out.println(result+"="+str);
                    break;
                }
            }
        }
        System.out.println("sum:"+sum);
    }

    private static final char[] CHARS = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static String convertIntToBase(long i, long base){
        final StringBuilder builder = new StringBuilder();
        do{
            builder.append(CHARS[(int)(i % base)]);
            i /= base;
        } while(i > 0);
        return builder.reverse().toString();
    }

}