package com.trie;

import java.util.HashMap;
//Time complexity :
// preprocessing O(S), where S is the number of all characters in the array, LCP query O(m).
// Trie build has O(S) time complexity. To find the common prefix of qq in the Trie takes in the worst case O(m).
// Space complexity : O(S). We only used additional SS extra space for the Trie.
class TrieNode{
    private char c;
    private HashMap<Character,TrieNode> children = new HashMap<Character, TrieNode>();
    private boolean isLeaf;
    public TrieNode(){}
    public TrieNode(char c){ this.c = c;}
    public HashMap<Character,TrieNode> getChildren(){ return this.children;}
    public boolean isLeafNode(){ return this.isLeaf;}
    public void setLeafNode(boolean isLeaf){ this.isLeaf = isLeaf;}
}
class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            HashMap<Character,TrieNode> children = current.getChildren();
            if(children.containsKey(c)){
                current = children.get(c);
            }else{
                TrieNode node = new TrieNode(c);
                children.put(c,node);
                current = children.get(c);
            }
        }
        current.setLeafNode(true);
    }
    public String Longest_Common_Prefix(){
        // move through the trie until we find a node with more than one children
        TrieNode curr = this.root;
        StringBuilder str = new StringBuilder();
        HashMap<Character,TrieNode> children = curr.getChildren();
        while(children.size()==1){
            for(Character c: children.keySet()){
                str.append(c);
                curr = children.get(c);
            }
            children = curr.getChildren();
        }
        return str.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.insert("hellpo");
        myTrie.insert("hellp");
        myTrie.insert("hellpty");
        myTrie.insert("hellpo");
        System.out.println(myTrie.Longest_Common_Prefix());
    }
}
