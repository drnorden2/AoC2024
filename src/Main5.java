import java.util.*;

public class Main5 extends Common {

    public static void main(String[] args) {
        String path = "";
        day5_2(read(path + "InputDay5"));
    }

    public static void day5_3(List<String> lines) {
        boolean rules = true;
        Map<Integer, List<Integer>> allRules = new HashMap<>();
        int sum = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                rules = false;
                System.out.println(allRules);
                continue;
            }
            if (rules) {
                int a = Integer.parseInt(line.substring(0, line.indexOf("|")));
                int b = Integer.parseInt(line.substring(line.indexOf("|") + 1));
                List<Integer> list = allRules.get(a);
                if (list == null) {
                    list = new ArrayList<>();
                    allRules.put(a, list);
                }
                list.add(b);
            } else {

                String[] nrs = line.split(",");
                int[] numbers = new int[nrs.length];
                for (int i = 0; i < nrs.length; i++) {
                    numbers[i] = Integer.parseInt(nrs[i]);
                }

                if (check(allRules, numbers)) {
                    continue;
                }
                int target = numbers.length/2;

                for (int i = 0; i < numbers.length - 1; i++) {
                    int nr = numbers[i];
                    List<Integer> potMatches = allRules.get(nr);
                    int counter = 0;
                    for(int j=0;j<numbers.length;j++){
                        if(potMatches.contains(numbers[j])){
                            counter++;
                        }
                    }
                    if(counter==target){
                        sum += numbers[numbers.length / 2];
                        break;
                    }
                }



            }

        }
        System.out.println("Sum is: " + sum);
    }
    public static void day5_2(List<String> lines) {
        boolean rules = true;
        Map<Integer, List<Integer>> allRules = new HashMap<>();
        int sum = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                rules = false;
                System.out.println(allRules);
                continue;
            }
            if (rules) {
                int a = Integer.parseInt(line.substring(0, line.indexOf("|")));
                int b = Integer.parseInt(line.substring(line.indexOf("|") + 1));
                List<Integer> list = allRules.get(a);
                if (list == null) {
                    list = new ArrayList<>();
                    allRules.put(a, list);
                }
                list.add(b);
            } else {
                int corrected = 0;
                String[] nrs = line.split(",");
                int[] numbers = new int[nrs.length];
                for (int i = 0; i < nrs.length; i++) {
                    numbers[i] = Integer.parseInt(nrs[i]);
                }


                String before = Arrays.toString(numbers);
                for (int i = 0; i < numbers.length ; i++) {
                    int nr = numbers[i];
                    List<Integer> others = allRules.get(nr);

                    for (int j = 0; j < i; j++) {
                        if (others.contains(numbers[j])) {
                            int tmp = numbers[j];
                            numbers[j] = nr;
                            numbers[i] = tmp;
                            corrected++;
                            i = -1;
                            System.out.println(before + " => " + Arrays.toString(numbers) + ":" + corrected);
                            break;
                        }
                    }
                }


                if (check(allRules, numbers) && corrected > 0) {
                    sum += numbers[numbers.length / 2];
                }

            }

        }
        System.out.println("Sum is: " + sum);
    }

    public static void day5_1(List<String> lines) {
        boolean rules = true;
        Map<Integer, List<Integer>> allRules = new HashMap<>();
        int sum = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                rules = false;
                System.out.println(allRules);
                continue;
            }
            if (rules) {
                int a = Integer.parseInt(line.substring(0, line.indexOf("|")));
                int b = Integer.parseInt(line.substring(line.indexOf("|") + 1));
                List<Integer> list = allRules.get(a);
                if (list == null) {
                    list = new ArrayList<>();
                    allRules.put(a, list);
                }
                list.add(b);
            } else {
                String[] nrs = line.split(",");
                int[] numbers = new int[nrs.length];
                for (int i = 0; i < nrs.length; i++) {
                    numbers[i] = Integer.parseInt(nrs[i]);
                }

                if (check(allRules, numbers)) {
                    sum += numbers[numbers.length / 2];
                }
            }

        }
        System.out.println("Sum is: " + sum);
    }

    private static boolean check(Map<Integer, List<Integer>> allRules, int[] numbers) {
        boolean ok = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!ok) {
                break;
            }
            int nr = numbers[i];
            List<Integer> others = allRules.get(nr);
            boolean violation = false;

            for (int j = 0; j < i; j++) {
                if (others.contains(numbers[j])) {
                    violation = true;
                    break;
                }
            }
            if (violation) {
                ok = false;
                break;
            }

        }
        return ok;
    }
}
