import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearchWord {

    public static <T extends Comparable<T>> boolean binarySearch(T[] array, T key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = key.compareTo(array[mid]);

            if (result == 0) {
                return true;
            }

            if (result > 0) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static String[] readWordsFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return content.split(",");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            String filePath = "words.txt"; // Update with your file path
            String[] words = readWordsFromFile(filePath);

            Arrays.sort(words);

            System.out.println("Sorted words: " + Arrays.toString(words));

            System.out.print("Enter a word to search: ");
            String wordToSearch = scanner.nextLine();

            boolean found = binarySearch(words, wordToSearch);

            if (found) {
                System.out.println("The word \"" + wordToSearch + "\" is found in the list.");
            } else {
                System.out.println("The word \"" + wordToSearch + "\" is not found in the list.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
