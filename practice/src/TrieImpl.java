import java.util.HashMap;
import java.util.Map;

public class TrieImpl {

    private TrieNode root;

    public static void main(String[] args) {
        TrieImpl t = new TrieImpl();
        t.insert("amit");
        t.insert("akash");
        t.insert("anuj");
        t.insert("nikhil");

        System.out.println(t.exists("amit"));
        System.out.println(t.exists("amita"));
        System.out.println(t.exists("akash"));
        System.out.println(t.exists("anuj"));
        System.out.println(t.exists("nikhil"));
        System.out.println(t.exists("a"));
        System.out.println(t.exists("aka"));

    }

    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++) {
            Character c = word.charAt(i);
            boolean endOfWord = false;
            if(i+1 == word.length()) {
                endOfWord =true;
            }
            if(root == null) {
                root = new TrieNode(new HashMap<Character, TrieNode>(), endOfWord);
                temp = root;
            }
            if(!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode(new HashMap<Character, TrieNode>(), endOfWord));
            }
            temp = temp.children.get(c);
        }
    }

    public boolean exists(String word) {
        TrieNode temp = root;
        boolean wordExists = false;
        for(int i=0; i<word.length(); i++) {
            Character c =  word.charAt(i);
            if(!temp.children.containsKey(c)) {
                return false;
            } else {
                temp = temp.children.get(c);
            }
        }
        if(temp.endOfWord == true) {
            wordExists = true;
        }
        return wordExists;
    }

}
class TrieNode {

    Map<Character, TrieNode> children;
    Boolean endOfWord;

    TrieNode(Map<Character, TrieNode> children, boolean endOfWord) {
        this.children = children;
        this.endOfWord = endOfWord;
    }

}
