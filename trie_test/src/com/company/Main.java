package com.company;

import java.util.HashMap;
import java.util.Map;

class Node{
    private Character ch;
    private HashMap<Character, Node> children;
    private boolean isLeaf;
    public Node(){
        children = new HashMap<>();
        isLeaf = false;
    }
    public Node(char ch){
        children = new HashMap<>();
        isLeaf = false;
        this.ch = ch;
    }
    public Character getChar(){ return this.ch; }
    public HashMap<Character, Node> getChildren(){ return this.children; }
    public boolean isLeaf(){ return this.isLeaf; }
    public void setLeaf(boolean isLeaf){
        this.isLeaf = isLeaf;
    }
}
class Trie{
    private Node root;
    public Trie(){
        this.root = new Node();
    }
    public void insert(String word){
        int n = word.length();
        Node current = this.root;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            HashMap<Character, Node> children = current.getChildren();;
            if(children.containsKey(ch)) current = children.get(ch);
            else{
                Node temp = new Node(ch);
                children.put(ch, temp);
                current = children.get(ch);
            }
        }
        current.setLeaf(true);
    }
    public boolean search(String word){
        int n = word.length();
        Node current = this.root;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            HashMap<Character, Node> children = current.getChildren();
            if(children.containsKey(ch)){
                current = children.get(ch);
            }else{
                return false;
            }
        }
        if(current!=null && current.isLeaf()) return true;
        return false;
    }
    public String lcp(){
        StringBuilder str = new StringBuilder();
        Node current = this.root;
        HashMap<Character, Node> children = current.getChildren();
        while(children.entrySet().size()==1){
            for(Map.Entry<Character, Node> e: children.entrySet()){
                str.append(e.getKey());
                children = e.getValue().getChildren();
            }
        }
        return str.toString();
    }
}
public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("helloww");
        trie.insert("hellowwerf");
        trie.insert("hellowwcee");
        System.out.println(trie.lcp());
    }
}
