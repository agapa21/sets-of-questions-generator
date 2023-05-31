import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "Pytania.txt"; // Wprowadź ścieżkę do wczytywanego pliku
        int numOfOutputFiles = 38; // Liczba generowanych plików wyjściowych

        try {
            List<String> lines = readLinesFromFile(inputFilePath);
            generateOutputFiles(lines, numOfOutputFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
        return lines;
    }

    private static void generateOutputFiles(List<String> lines, int numOfOutputFiles) throws IOException {

        Random random = new Random();
        int randomNumber;

            String outputFileName = "plik" + ".txt";
            FileWriter writer = new FileWriter(outputFileName);

            int n;

            for (int i = 0; i < numOfOutputFiles; i++) {
                n = i+1;
                writer.write("Zestaw " + n + ": \n");
                for (int j = 0; j < 4; j++) {
                    randomNumber = random.nextInt(34);
                    writer.write(lines.get(randomNumber) + "\n");
                }
                writer.write("\n\n\n");
            }

            writer.close();
        }
}

