import java.util.ArrayList;
import java.util.List;

public class LC17_LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("123"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        } else if (digits.length() == 1) {
            return getLetters(digits.charAt(0));
        } else {
            List<String> totalCombinations = new ArrayList<>();
            // get the 3 or 4 letters that may represent the first number, then iterate through them
            for (String prefix : getLetters(digits.charAt(0))) {
                // get every combination of the rest of the letters
                List<String> suffixes = letterCombinations(digits.substring(1));
                for (String suffix : suffixes) {
                    totalCombinations.add(prefix + suffix);
                }
            }
            return totalCombinations;
        }
    }

    private static List<String> getLetters(char digit) {
        List<String> letters = new ArrayList<>();
        switch (digit) {
            case '2':
                letters.add("a"); letters.add("b"); letters.add("c");
                break;
            case '3':
                letters.add("d"); letters.add("e"); letters.add("f");
                break;
            case '4':
                letters.add("g"); letters.add("h"); letters.add("i");
                break;
            case '5':
                letters.add("j"); letters.add("k"); letters.add("l");
                break;
            case '6':
                letters.add("m"); letters.add("n"); letters.add("o");
                break;
            case '7':
                letters.add("p"); letters.add("q"); letters.add("r"); letters.add("s");
                break;
            case '8':
                letters.add("t"); letters.add("u"); letters.add("v");
                break;
            case '9':
                letters.add("w"); letters.add("x"); letters.add("y"); letters.add("z");
                break;
            default:
                letters.add("");
        }
        return letters;
    }

}
