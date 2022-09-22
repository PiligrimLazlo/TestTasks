package Main.problems;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AverageStudents {

    public static void main(String[] args) throws IOException {
        //input: AverageStudents.txt
        //output:
        // 1 -
        // 2 -
        // 3 -
        // 4 -
        // 5 -
        // 6 156.0
        // 7 158.0
        // 8 -
        // 9 -
        // 10 -
        // 11 - 172.0

        System.out.println(parseAverageGrowth());
    }

    private static String parseAverageGrowth() throws IOException {

        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> helperMap = new HashMap<>();

        FileInputStream fis = new FileInputStream("src/Main/problems/AverageStudents.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split(" ");
            int grade = Integer.parseInt(splitLine[0]);
            int growth = Integer.parseInt(splitLine[2]);

            int currentSum = out.getOrDefault(grade, 0) + growth;
            out.put(grade, currentSum);
            helperMap.put(grade, helperMap.getOrDefault(grade, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 11; i++) {
            result.append(i).append(" ");
            double averageGrowth = 0;
            if (out.get(i) != null) {
                averageGrowth = Double.valueOf(out.get(i)) / helperMap.get(i);
                result.append(averageGrowth);
            } else {
                result.append("-");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
