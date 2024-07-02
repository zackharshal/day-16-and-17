import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static List<String> iterativePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return permutations;
        }

        permutations.add(String.valueOf(str.charAt(0))); // Add the first character

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            List<String> newPermutations = new ArrayList<>();

            for (String permutation : permutations) {
                for (int j = 0; j <= permutation.length(); j++) {
                    String newPermutation = permutation.substring(0, j) + currentChar + permutation.substring(j);
                    newPermutations.add(newPermutation);
                }
            }

            permutations = newPermutations;
        }

        return permutations;
    }

    public static List<String> recursivePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstChar = str.charAt(0);
        String remainingStr = str.substring(1);
        List<String> words = recursivePermutations(remainingStr);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String newPermutation = word.substring(0, i) + firstChar + word.substring(i);
                permutations.add(newPermutation);
            }
        }

        return permutations;
    }

    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "abc";

        List<String> iterativeResult = iterativePermutations(str);
        List<String> recursiveResult = recursivePermutations(str);

        System.out.println("Iterative permutations: " + iterativeResult);
        System.out.println("Recursive permutations: " + recursiveResult);

        boolean areEqual = areListsEqual(iterativeResult, recursiveResult);
        System.out.println("Are the two lists equal? " + areEqual);
    }
}
