import java.util.ArrayList;
import java.util.List;

public class Main6 extends Common{
    static  int counter=0;
    public static void main(String[] args) {
        String path = "";
        day6_2(read(path + "InputDay6"));
    }
    public static void day6_2(List<String> lines){
        char[][] maze = loadMap(lines);
        int[] pos = getStart(maze);

        while(pos!=null){
            pos = nextRun(maze,pos);
        }
        List<int[]>pathXY = showAndCountPath(maze);

        int loops = 0;
        boolean skipFirst = true;
        for(int[] xy:pathXY) {
            if(skipFirst){
                skipFirst=false;
                continue;
            }
            maze = loadMap(lines);
            maze[xy[0]][xy[1]]='#';
            pos = getStart(maze);
            while (pos != null) {
                pos = nextRun(maze, pos);
                if (pos!=null && pos[4] == 0) {
                    loops++;
                    break;
                }
            }
        }
        System.out.println("Loops:"+loops);

    }


    public static void day6_1(List<String> lines){
        char[][] maze = loadMap(lines);
        int[] pos = getStart(maze);
        while(pos!=null){
            pos = nextRun(maze,pos);
        }
        int pathLenght = showAndCountPath(maze).size();
        System.out.println("Path lenght:"+pathLenght);

    }
    public static List<int[]> showAndCountPath(char[][] maze) {
        int path =0;
        List <int[]> pathPos = new ArrayList<>();
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                if(maze[i][j]-'0'>=1 && maze[i][j]-'0'<=4){
                    pathPos.add(new int[]{i,j});
                    path++;
                }
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        return pathPos;
    }


    public static int[] nextRun(char[][] maze,int[] pos) {
        boolean stop = false;
        boolean first = true;
        while(!stop){
            if(!first){
                if(maze[pos[0]][pos[1]] != (""+pos[4]).charAt(0)) {
                    maze[pos[0]][pos[1]] = ("" + pos[4]).charAt(0);
                }else{
                    pos[4]=0;
                    return pos;
                }
            }
            first = false;

            if(pos[0]+pos[2] <0 || pos[1]+pos[3]<0 ||pos[0]+pos[2]==maze.length||pos[1]+pos[3]==maze[0].length){
                pos =null;
                stop=true;
            }else {
                if (maze[pos[0] + pos[2]][pos[1] + pos[3]] == '#') {
                    if(pos[4]==1){
                        pos[4]=2;
                        pos[2]=0;
                        pos[3]=1;
                    }else if(pos[4]==2){
                        pos[4]=3;
                        pos[2]=1;
                        pos[3]=0;
                    }else if(pos[4]==3){
                        pos[4]=4;
                        pos[2]=0;
                        pos[3]=-1;
                    }else if(pos[4]==4){
                        pos[4]=1;
                        pos[2]=-1;
                        pos[3]=0;
                    }
                    stop = true;
                } else {
                    pos[0] = pos[0] + pos[2];
                    pos[1] = pos[1] + pos[3];
                }
            }
        }
        return pos;
    }

    public static int[] getStart(char[][] maze) {
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                if(maze[i][j]=='^'){
                    maze[i][j] = '1';
                    return new int[]{i,j,-1,0,1};
                }
            }
        }
        return null;
    }


}
