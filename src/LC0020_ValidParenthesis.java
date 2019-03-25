public class LC0020_ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("({{}()())"));
    }

    public static boolean isValid(String s) {

        boolean eliminatedParens = true;
        while (eliminatedParens) {
            int sLen = s.length();
            s = s.replace("{}", "").replace("[]", "").replace("()", "");
            eliminatedParens = s.length() < sLen;
        }

        return s.length() <= 0;
    }

}
