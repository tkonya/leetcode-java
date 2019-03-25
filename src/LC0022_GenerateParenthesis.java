import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LC0022_GenerateParenthesis {


    public static void main(String[] args) {

        LC0022_GenerateParenthesis gen = new LC0022_GenerateParenthesis();
        System.out.println(gen.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {

        List<String> answers = new ArrayList<>();

        // brute force create almost every combination
        for (int i = 0; i < n * 2; ++i) {
            if (answers.size() == 0) {
                answers.add("(");
            } else {
                List<String> otherAnswers = new ArrayList<>();
                for (String answer : answers) {
                    otherAnswers.add(answer + ")");
                    if (i < n * 2 - 1) {
                        // do not put an opening parens if it is the last element
                        otherAnswers.add(answer + "(");
                    }
                }
                answers = otherAnswers;
            }
        }

        System.out.println("Raw elements: "+ answers.size());
        answers = answers.stream().filter(LC0022_GenerateParenthesis::isValid).collect(Collectors.toList());
        System.out.println("Valid elements: "+ answers.size());

        return answers;
    }

    public static boolean isValid(String s) {

        if (s.length() == 0) {
            return true;
        } else if (s.length() == 1) {
            return false;
        }

        // quick way to check if it's invalid - there are not equal numbers of open and close
        if (s.replace("(", "").length() != s.length() / 2) {
            return false;
        }

        // eliminate parens until the length is 0 or there are no more left
        boolean eliminatedParens = true;
        while (eliminatedParens) {
            int sLen = s.length();
            s = s.replace("()", "");
            eliminatedParens = s.length() < sLen;
        }

        return s.length() <= 0;
    }

}
