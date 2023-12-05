import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AoC_Day2_Part1 {
    static int maxBlue = 14;
    static int maxGreen = 13;
    static int maxRed = 12;

    public static void main(String[] args) {
        String inputfile = "text.txt";
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputfile))) {
            String line;
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line.substring(5, line.indexOf(':')));
                line = line.substring(line.indexOf(':') + 2);
                boolean foundFaulty = false;

                outerLoop: for (String segment : line.split("; ")) {
                    for (String str : segment.split(", ")) {
                        int num = Integer.parseInt(str.substring(0, str.indexOf(' ')));
                        if (str.contains("blue") && num > maxBlue) {
                            foundFaulty = true;
                            break outerLoop;
                        }
                        if (str.contains("green") && num > maxGreen) {
                            foundFaulty = true;
                            break outerLoop;
                        }
                        if (str.contains("red") && num > maxRed) {
                            foundFaulty = true;
                            break outerLoop;
                        }
                    }
                }

                sum += foundFaulty ? 0 : id;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error occurred: " + e.toString());
        }

        System.out.println("Sum: " + sum);
    }
}
