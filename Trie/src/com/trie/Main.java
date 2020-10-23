package com.trie;

import java.util.HashMap;
import java.util.Iterator;

class TrieNode{
    private char character;
    private HashMap<Character,TrieNode> children = new HashMap<Character, TrieNode>();
    private boolean isLeaf;
    public TrieNode(){}
    public TrieNode(Character c){
        this.character = c;
    }
    public HashMap<Character,TrieNode> getChildren(){
        return this.children;
    }
    public Character getChar(){return this.character;}
    public boolean isLeafNode(){return this.isLeaf;}
    public void setLeafNode(boolean isLeaf){
        this.isLeaf = isLeaf;
    }
}
class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode(); //  root node is set empty
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
    public boolean searchWord(String word){
        TrieNode current = this.root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            HashMap<Character,TrieNode> children = current.getChildren();
            if(children.containsKey(c)){
                current = children.get(c);
            }else{
                return false;
            }
        }
        if(current.isLeafNode() && current!=null){
            return true;
        }else{
            return false;
        }

    }
    public void print(){
        StringBuilder seq = new StringBuilder();
        printRec(this.root,seq,0);
    }
    private void printRec(TrieNode node,StringBuilder sequence,int level){
     if(node.isLeafNode()){
         sequence = sequence.insert(level,node.getChar());
         System.out.println(sequence);
     }
         HashMap<Character,TrieNode> children = node.getChildren();
         Iterator<Character> it = children.keySet().iterator();
         while(it.hasNext()){
             char c = it.next();
             sequence = sequence.insert(level,c);
             printRec(children.get(c),sequence,level+1);
             sequence.deleteCharAt(level);
         }


    }
}
public class Main {
    public static void main(String[] args) {
        Trie dictionary = new Trie();
        dictionary.insert("cat");
        dictionary.insert("cook");
        dictionary.insert("camera");
        dictionary.insert("city");
        dictionary.insert("dog");
        dictionary.insert("citric");
        dictionary.insert("doggo");
        dictionary.insert("my");
        dictionary.insert("mine");
        dictionary.insert("there");
        dictionary.insert("their");

        System.out.println(dictionary.searchWord("their"));

        /*
        *                       ROOT(empty)
        *                    /    / \ \
        *                   c    d  m t
        *                 / \  \  .......
        *                o   a  i
        *               /   / \  \
        *              o   m   t  t
        *             /    /   /  /\
        *            k    e   *  y  r
        *           /    /      /    \
        *          *    r      *      i
        *              /               \
        *             a                 c
        *            /                   \
        *           *                     *
        * */
        dictionary.print();
    }
}
