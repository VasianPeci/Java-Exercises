import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class StudentGradeProcessor {

    public static void main(String[] args) {
        String inputPath = "input/notat.txt";
        String outputPath = "output/notatMesatare.txt";

        String[] names;
        double[] averages;

        int studentCount = countLines(inputPath);
        if (studentCount == 0) {
            System.out.println("No data found in input file.");
            return;
        }

        names = new String[studentCount];
        averages = new double[studentCount];

        readStudentData(inputPath, names, averages);
        sortDescending(names, averages);
        writeOutput(outputPath, names, averages);

        System.out.println("✅ Processing completed. Check 'output/notatMesatare.txt'");
    }

    private static int countLines(String filePath) {
        int lines = 0;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                if (!scanner.nextLine().trim().isEmpty()) {
                    lines++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ Input file not found: " + filePath);
        }
        return lines;
    }

    private static void readStudentData(String filePath, String[] names, double[] averages) {
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                names[index] = parts[0];
                double sum = 0;

                for (int i = 1; i < parts.length; i++) {
                    try {
                        sum += Double.parseDouble(parts[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Invalid grade for " + names[index] + ": " + parts[i]);
                    }
                }

                averages[index] = sum / (parts.length - 1);
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ Failed to read input file: " + filePath);
        }
    }

    private static void sortDescending(String[] names, double[] averages) {
        for (int i = 0; i < averages.length - 1; i++) {
            for (int j = 0; j < averages.length - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }
    }

    private static void writeOutput(String filePath, String[] names, double[] averages) {
        File outputFile = new File(filePath);
        outputFile.getParentFile().mkdirs(); // create output folder if it doesn't exist

        try (PrintStream output = new PrintStream(outputFile)) {
            for (int i = 0; i < names.length; i++) {
                output.printf("%s %.2f%n", names[i], averages[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ Could not write to output file: " + filePath);
        }
    }
}