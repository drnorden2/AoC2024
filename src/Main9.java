import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main9 extends Common {

    public static void main(String[] args) {
        String path = "";
        day9_2(read(path + "InputDay9"));
    }
    public static final int EMPTY = -1;
    public static void day9_2(List<String> lines) {
        List<Integer> disk = new ArrayList<>();
        //decompress
        String compressed = lines.get(0);
        for(int i=0;i<compressed.length();i++){
            if(i%2==0){
                disk.addAll( xOfy(i/2,(int)(compressed.charAt(i))-'0'));
            }else{
                disk.addAll( xOfy(EMPTY,(int)(compressed.charAt(i))-'0'));
            }
        }
        System.out.println(disk);
        //defragment
        int start = 0;
        int end = disk.size()-1;
        int[] array = new int[disk.size()];
        for(int i=0;i<disk.size();i++){
            array[i]=disk.get(i);
        }
        int lastType =Integer.MAX_VALUE;
        for(int i=array.length-1;i>=0;i--){
            if(array[i]!=EMPTY){
                int blockSize =1;
                int type = array[i];
                if(type>lastType){
                    continue;
                }
                lastType =type;
                while(i-blockSize>=0 && array[i-blockSize]==type){
                    blockSize++;
                }
                System.out.print("Block("+type+","+blockSize+")@+"+(i-blockSize+1)+": ");
                int emptyBlockSize=0;
                for(int j=0;j<i;j++){
                    if(array[j]==EMPTY){
                        emptyBlockSize++;
                        if(emptyBlockSize==blockSize){
                            for(int k=0;k<blockSize;k++){
                                array[j-k]=type;
                                array[i-k] =EMPTY;
                            }
                            System.out.print(" moved to: "+(j-blockSize+1));
                            break;
                        }
                    }else{
                        emptyBlockSize =0;
                    }
                }
                System.out.println();
                i=i-(blockSize-1);
            }
        }
        for(int i=0;i<disk.size();i++){
            System.out.print (array[i]+" ");
        }
        System.out.println();

        //checksum
        long checksum=0;
        //test: array = new int[]{0,0,9,9,2,1,1,1,7,7,7,-1,4,4,-1,3,3,3,-1,-1,-1,-1,5,5,5,5,-1,6,6,6,6,-1,-1,-1,-1,-1,8,8,8,8,-1,-1};
        for(int i=0;i<array.length;i++){
            if(array[i]!=EMPTY) {
                checksum += i * array[i];
            }
        }
        System.out.println("Checksum:"+checksum);

    }
    public static void day9_1(List<String> lines) {
        List<Integer> disk = new ArrayList<>();
        //decompress
        String compressed = lines.get(0);
        for(int i=0;i<compressed.length();i++){
            if(i%2==0){
                disk.addAll( xOfy(i/2,(int)(compressed.charAt(i))-'0'));
            }else{
                disk.addAll( xOfy(EMPTY,(int)(compressed.charAt(i))-'0'));
            }
        }
        System.out.println(disk);
        //defragment
        int end = disk.size()-1;
        List<Integer> newDisk = new ArrayList<>();
        for(int i=0;i<disk.size();i++){
            if(i>=end){
                newDisk.add(disk.get(i));
                break;
            }else if(disk.get(i)==EMPTY){
                while(disk.get(end)==EMPTY){
                    end--;
                }
                newDisk.add(disk.get(end--));
            }else{
                newDisk.add(disk.get(i));
            }
        }
        System.out.println(newDisk);
        //checksum
        long checksum=0;
        for(int i=0;i<newDisk.size();i++){
            checksum+=i*newDisk.get(i);
        }
        System.out.println("Checksum:"+checksum);
    }
    public static List<Integer> xOfy(int number,int times){
        List<Integer> same = new ArrayList<>();
        for(int i=0;i<times;i++){
            same.add(number);
        }
        return same;
    }
}
