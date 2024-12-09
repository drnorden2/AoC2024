import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Common {
    public static List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(Common.class.getResource(filePath).getPath()) ))) {

            String line =null;
            while (( line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
    public static char[][] loadMap(List<String> lines) {
        char[][] matrix = new char[lines.size()][lines.get(0).length()];
        System.out.println("Matrix:"+matrix.length+"x"+matrix[0].length);

        for(int i=0;i<matrix.length;i++){
            String line = lines.get(i);
            for(int j=0;j<matrix[0].length;j++) {
                matrix[i][j]=line.charAt(j);
            }
        }
        return matrix;
    }
}
