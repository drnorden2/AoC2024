import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 extends Common{

    public static void main(String[] args) {
        String path = "";
        day4_2(read(path + "InputDay4"));
    }
    public static void day4_2(List<String> lines){
        char[][] matrix = new char[lines.size()][lines.get(0).length()];
        System.out.println("Matrix:"+matrix.length+"x"+matrix[0].length);
        int sum =0;

        for(int i=0;i<matrix.length;i++){
            String line = lines.get(i);
            for(int j=0;j<matrix[0].length;j++) {
                matrix[i][j]=line.charAt(j);
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='A'){
                    sum +=checkDir2(matrix,i,j);
                }
            }
        }
        System.out.println("XMAS was found "+sum+" times");
    }
    public static void day4_1(List<String> lines){
        char[][] matrix = new char[lines.size()][lines.get(0).length()];
        System.out.println("Matrix:"+matrix.length+"x"+matrix[0].length);
        int sum =0;

        for(int i=0;i<matrix.length;i++){
            String line = lines.get(i);
            for(int j=0;j<matrix[0].length;j++) {
                matrix[i][j]=line.charAt(j);
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='X'){
                    sum +=checkDir(matrix,i,j,0,1);
                    sum +=checkDir(matrix,i,j,1,0);
                    sum +=checkDir(matrix,i,j,0,-1);
                    sum +=checkDir(matrix,i,j,-1,0);
                    sum +=checkDir(matrix,i,j,1,1);
                    sum +=checkDir(matrix,i,j,-1,-1);
                    sum +=checkDir(matrix,i,j,1,-1);
                    sum +=checkDir(matrix,i,j,-1,1);
                }
            }
        }
        System.out.println("XMAS was found "+sum+" times");
    }
    public static int checkDir(char[][] matrix,int i, int j, int dirX, int dirY ){
        System.out.println(".");
        if(i+dirX*3<0|| j+dirY*3<0||i+dirX*3>=matrix.length|| j+dirY*3>=matrix[0].length){
            return 0;
        }
        String rest = "MAS";
        for(int k=0;k<rest.length();k++){
            if(rest.charAt(k)!=matrix[i+dirX*(k+1)][j+dirY*(k+1)]){
                return 0;
            }
        }
        return 1;
    }
    public static int checkDir2(char[][] matrix,int i, int j){
        System.out.println(".");
        if(i-1<0|| j-1<0||i+1>=matrix.length|| j+1>=matrix[0].length){
            return 0;
        }

        if(((matrix[i+1][j+1]=='M' && matrix[i-1][j-1]=='S')||
                (matrix[i+1][j+1]=='S' && matrix[i-1][j-1]=='M')) &&(
                ((matrix[i-1][j+1]=='M' && matrix[i+1][j-1]=='S')||
                        (matrix[i-1][j+1]=='S' && matrix[i+1][j-1]=='M'))
                )){
            return 1;
        }

        return 0;
    }
}
