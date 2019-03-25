import java.util.HashMap;
import java.util.Map;

public class LC0208_ImplementTrie {

    public static void main(String[] args) {
        new LC0208_ImplementTrie();
    }

    public LC0208_ImplementTrie() {

        Trie obj = new Trie();
        obj.insert("Trie");
        System.out.println(obj.startsWith("a"));


        obj.insert("someday");

        // should be true
        System.out.println(obj.search("something"));
        System.out.println(obj.startsWith("some"));
        System.out.println(obj.startsWith("someday"));

        // should be false
        System.out.println(obj.search("oranges"));
        System.out.println(obj.search("so"));
        System.out.println(obj.startsWith("somethingortheother"));

    }


    class Trie {

        LetterNode rootNode;

        /** Initialize your data structure here. */
        public Trie() {
            rootNode = new LetterNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            rootNode.addWord(word);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return rootNode.search(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return rootNode.startsWith(prefix);
        }
    }

    class LetterNode {

        String value;
        Map<String, LetterNode> children;
        boolean wordEnd = false;

        // constructor for creating the root node, which is blank
        public LetterNode() {
            this.value = null;
            this.children = new HashMap<>();
        }

        // constructor for creating a new node for a segment of a word
        public LetterNode(String word) {
            this.value = word.substring(0, 1);
            this.children = new HashMap<>();
        }

        // wordRemainder should already have the value of this node clipped
        public void addWord(String wordRemainder) {
            String currentLetter = wordRemainder.substring(0, 1);

            if (!children.containsKey(currentLetter)) {
                children.put(currentLetter, new LetterNode(currentLetter));
            }

            if (wordRemainder.length() == 1) {
                System.out.println("Setting word end at '" + wordRemainder + "'");
                children.get(currentLetter).wordEnd = true;
            } else {
                children.get(currentLetter).addWord(wordRemainder.substring(1));
            }
        }

        public boolean startsWith(String searchWord) {
            return find(searchWord, false);
        }

        public boolean search(String searchWord) {
            return find(searchWord, true);
        }

        public boolean find(String searchWord, boolean mustBeEnd) {

            boolean isRoot = (value == null);
            boolean isEndOfSearchWord = searchWord.length() <= 1;

            if (!isRoot) {
                System.out.println("Looking for '" + searchWord + "'");
                if (!searchWord.startsWith(value)) {
                    return false;
                }
                searchWord = searchWord.substring(1);
            }

            if (isEndOfSearchWord) {
                System.out.println("Found the end of search word");
                if (mustBeEnd) {
                    return wordEnd;
                } else {
                    return true;
                }
            }

            if (children.containsKey(searchWord.substring(0, 1))) {
                return children.get(searchWord.substring(0, 1)).find(searchWord, mustBeEnd);
            } else {
                System.out.println("No children match " + searchWord);
                return false;
            }

        }

//        public boolean startsWith(String searchWord) {
//            System.out.println("Searching for starts with '" + searchWord + "'");
//            if (searchWord.startsWith(value)) {
//                if (searchWord.length() <= 1) {
//                    return true;
//                } else {
//                    if ("".equals(value)) {
//                        if (children.containsKey(searchWord.substring(0, 1))) {
//                            return children.get(searchWord.substring(0, 1)).startsWith(searchWord);
//                        } else {
//                            return false;
//                        }
//                    } else {
//                        if (children.containsKey(searchWord.substring(1, 2))) {
//                            return children.get(searchWord.substring(1, 2)).startsWith(searchWord.substring(1));
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//            }
//            return false;
//        }
//
//        public boolean search(String searchWord) {
//            System.out.println("Searching for '" + searchWord + "'");
//            if (searchWord.startsWith(value)) {
//                if (searchWord.length() <= 1) {
//                    return wordEnd;
//                } else {
//                    if ("".equals(value)) {
//                        if (children.containsKey(searchWord.substring(0, 1))) {
//                            return children.get(searchWord.substring(0, 1)).search(searchWord);
//                        } else {
//                            return false;
//                        }
//                    } else {
//                        if (children.containsKey(searchWord.substring(1, 2))) {
//                            return children.get(searchWord.substring(1, 2)).search(searchWord.substring(1));
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//            }
//            return false;
//        }

    }
}
