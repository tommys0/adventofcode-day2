import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.io.IOException;

public class AoC_Day2_Part2 {

    public static void main(String[] args) {
        int sum = 0;
        String inputFileName = "text.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            for (String s : br.lines().collect(Collectors.toList())) {
                int id = Integer.parseInt(s.substring(5, s.indexOf(':')));
                s = s.substring(s.indexOf(':') + 2);
                int minRed = 0, minGreen = 0, minBlue = 0;

                for (String st : s.split("; ")) {
                    for (String str : st.split(", ")) {
                        int num = Integer.parseInt(str.substring(0, str.indexOf(' ')));
                        if (str.contains("blue")) minBlue = Math.max(minBlue, num);
                        if (str.contains("green")) minGreen = Math.max(minGreen, num);
                        if (str.contains("red")) minRed = Math.max(minRed, num);
                    }
                }

                sum += minBlue * minGreen * minRed;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}
