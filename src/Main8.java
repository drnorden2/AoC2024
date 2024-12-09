import java.util.*;

public class Main8  extends Common {
    public static void main(String[] args) {
        String path = "";
        day8_2(read(path + "InputDay8"));
    }
    private static Set<String> exists = new HashSet<>();

    public static void day8_2(List<String> lines) {
        char[][] map = loadMap(lines);
        Map<String,List<int[]>> antennas = getAntennas(map);
        int antinodeCount =0;
        for(List<int[]>list:antennas.values()){
            for(int i=0;i<list.size()-1;i++){
                int[] antennaA = list.get(i);
                for(int j=i+1;j<list.size();j++) {
                    int[] antennaB = list.get(j);
                    int[] delta = new int[]{antennaB[0] - antennaA[0], antennaB[1] - antennaA[1]};
                    for (int k = 0; k < 50; k++) {
                        if (isAntidode(antennaA, delta, k, map.length, map[0].length)) {
                            antinodeCount++;
                        }
                        if (isAntidode(antennaA, delta, k*-1, map.length, map[0].length)) {
                            antinodeCount++;
                        }
                    }

                }
            }
        }
        System.out.println("antinodeCount: "+antinodeCount);
    }
    public static boolean isAntidode(int[] antennaA, int[] delta, int factor,int max1, int max2){
        int[] anti1 = new int[]{antennaA[0]+delta[0]*factor,antennaA[1]+delta[1]*factor};
        if(exists.add(""+anti1[0]+","+anti1[1])) {
            if (anti1[0] >= 0 && anti1[1] >= 0 && anti1[0] < max1 && anti1[1] < max2) {
                return true;
            }
        }
        return false;
    }

    public static void day8_1(List<String> lines) {
        char[][] map = loadMap(lines);
        Map<String,List<int[]>> antennas = getAntennas(map);
        int antinodeCount =0;
        Set<String> exists = new HashSet<>();
        for(List<int[]>list:antennas.values()){
            for(int i=0;i<list.size()-1;i++){
                int[] antennaA = list.get(i);
                for(int j=i+1;j<list.size();j++){
                    int[] antennaB = list.get(j);
                    int[] delta = new int[]{antennaB[0]-antennaA[0],antennaB[1]-antennaA[1]};
                    int[] anti1 = new int[]{antennaA[0]-delta[0],antennaA[1]-delta[1]};
                    int[] anti2 = new int[]{antennaB[0]+delta[0],antennaB[1]+delta[1]};
                    if(exists.add(""+anti1[0]+","+anti1[1])) {
                        if (anti1[0] >= 0 && anti1[1] >= 0 && anti1[0] < map.length && anti1[1] < map[0].length) {
                            antinodeCount++;
                        }
                    }
                    if(exists.add(""+anti2[0]+","+anti2[1])) {
                        if (anti2[0] >= 0 && anti2[1] >= 0 && anti2[0] < map.length && anti2[1] < map[0].length) {
                            antinodeCount++;
                        }
                    }
                }
            }
        }
        System.out.println("antinodeCount: "+antinodeCount);
    }

    public static Map<String,List<int[]>> getAntennas(char[][] map){
        Map<String,List<int[]>> antennas = new HashMap<>();

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]!='.') {
                    String key = ""+map[i][j];
                    List<int[]> list = antennas.get(key);
                    if(list==null){
                        list = new ArrayList<int[]>();
                        antennas.put(key,list);
                    }
                    list.add(new int[]{i,j});
                }
            }
        }
        return antennas;
    }
}
