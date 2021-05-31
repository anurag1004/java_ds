import java.util.ArrayList;
import java.util.List;

class TrieNode{
    private char c;
    private TrieNode[] children = new TrieNode[26];
    private boolean isLeaf;
    public TrieNode(char c){
        this.c = c;
    }
    public void setLeaf(boolean flag){
        this.isLeaf = flag;
    }
    public char getChar(){ return this.c; }
    public boolean isLeaf() { return this.isLeaf; }
    public TrieNode[] getChildren(){ return this.children; }
}
public class Main {
    public static void insert(TrieNode root, String word){
        for(char w: word.toCharArray()){
            TrieNode[] children = root.getChildren();
            if(children[w-97]==null){
                TrieNode node = new TrieNode(w);
                children[w-97] = node;
                root = children[w-97];
            }else{
                root = children[w-97];
            }
        }
        root.setLeaf(true);
    }
    public static boolean search(TrieNode root, String word){
        for(char w: word.toCharArray()){
            TrieNode[] children = root.getChildren();
            if(children[w-97]!=null){
                root = children[w-97];
            }else{
                return false; // not found
            }
        }
        if(root!=null && root.isLeaf()){
            return true;
        }
        return false;
    }
    public static TrieNode getTheLastNode(TrieNode root, String prefix){
        // go to the final node by comparing character by character
        for(char c: prefix.toCharArray()){
            TrieNode[] children = root.getChildren();
            if(children[c-97]!=null){
                root = children[c-97];
            }else{
                return null;
            }
        }
        return root;
    }
    public static void getAllWordsFromNode(TrieNode node, String prefix, List<String> out){
        if(node==null || out.size()==3)
            return;
        if(node.isLeaf()){
            out.add(prefix);
        }
        TrieNode[] children = node.getChildren();
        for(int i=0;i<26;i++){
            if(children[i]!=null){
                getAllWordsFromNode(children[i], prefix+(char)(i+97),out);
            }
        }
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode('\0');
        String[] words = {"mobile", "mouse", "mousepad","moneypot","monitor"};
        for(String word:words)
            insert(root, word);
        String prefix = "m";
        TrieNode node = getTheLastNode(root, prefix);
        List<String> out = new ArrayList<>();
        getAllWordsFromNode(node,prefix,out);
        System.out.println(out);
    }
}
