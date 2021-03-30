package com.playfair;

import java.util.*;
class Location{
    int r;
    int c;
    public Location(int i, int j){
        this.r = i;
        this.c = j;
    }
}
public class PlayfairCipher {
    char[][] key;
    Map<Character, Location> map;
    PlayfairCipher(){
        key = new char[5][5];
        map = new HashMap<>();
    }
    public char[][] constructKeyMatrix(String key){
       boolean[] filledAlphabets = new boolean[26];
       int i, j;
       i =  0;
       j = -1;
       boolean flag = false;
       // filling the keys
       for(char k:key.toCharArray()){
           if(j<4) j++;
           else if(i<4){
               i++;
               j=0;
           }
           if(!filledAlphabets[k-65]) {
               if(k=='I' || k=='J') {
                   //when there is either I or J is present
                   filledAlphabets[8] = true;
                   filledAlphabets[9] = true;
                   flag=true;
               }
               this.key[i][j] = k;
               filledAlphabets[k-65] = true;
               map.put(k, new Location(i,j));
           }else{
               j--;
           }
       }
       if(!flag){
           // I or J not present in the key
           // mark 'j' as true
           filledAlphabets[9] = true;
       }

       // filling rest of the alphabets
       for(int k=0;k<26;k++){
           if(j<4) j++;
           else if(i<4){
               i++;
               j=0;
           }
           if(!filledAlphabets[k]){
               this.key[i][j] = (char)(k+65);
               filledAlphabets[k] = true;
               map.put((char)(k+65), new Location(i,j));
           }else j--;
       }
       for(i=0;i<5;i++){
           for(j=0;j<5;j++){
               System.out.printf("%c ",this.key[i][j]);
           }
           System.out.println();
       }
       return this.key;
    }
    public String encrypt(String plaintext){
        StringBuilder enc = new StringBuilder();
        // form pairs, if pair is not forming append 'X' and if letter is repeated append do same.
        int len = plaintext.length();
        int i=0;
        boolean isRepeated=false;
        char c1,c2;
        while(i<len){
            c1 = plaintext.charAt(i);
            c2 = (i+1)>=len ? 'X':plaintext.charAt(i+1);
            // replace J with I
            if(c1=='J') c1 = 'I';
            if(c2=='J') c2 = 'I';

            if(c1==c2){
                c2 = 'X';
                isRepeated = true;
            }
            // i and i+1 forms a pair
            Location l1 = map.get(c1);
            Location l2 = map.get(c2);
            // if both c1 and c2 are in same row

            if(l1.r == l2.r){
                enc.append(key[l1.r][(l1.c+1)%5]).append(key[l2.r][(l2.c+1)%5]);
            }else if(l1.c == l2.c){
                enc.append(key[(l1.r+1)%5][l1.c]).append(key[(l2.r+1)%5][l2.c]);
            }
            else{
                enc.append(key[l1.r][l2.c]).append(key[l2.r][l1.c]);
            }
            if(isRepeated) i++;
            else i+=2;
            isRepeated = false;

        }
        return enc.toString();
    }
    public String decrypt(String ciphertext){
        StringBuilder decryptText = new StringBuilder();
        // form pairs, if pair is not forming append 'X' and if letter is repeated append do same.
        int len = ciphertext.length();
        int i=0;
        char c1,c2;
        while(i<len){
            c1 = ciphertext.charAt(i);
            c2 = ciphertext.charAt(i+1);
            // i and i+1 forms a pair
            Location l1 = map.get(c1);
            Location l2 = map.get(c2);
            // if both c1 and c2 are in same row

            if(l1.r == l2.r){
                int col1 = l1.c>0?l1.c-1:5+(l1.c-1);
                int col2 = l2.c>0?l2.c-1:5+(l2.c-1);
                decryptText.append(key[l1.r][col1]).append(key[l2.r][col2]);
            }else if(l1.c == l2.c){
                int row1 = l1.r>0?l1.r-1:5+(l1.r-1);
                int row2 = l2.r>0?l2.r-1:5+(l2.r-1);
                decryptText.append(key[row1][l1.c]).append(key[row2][l2.c]);
            }
            else{
                decryptText.append(key[l1.r][l2.c]).append(key[l2.r][l1.c]);
            }
            i+=2;

        }
        return decryptText.toString();
    }
    public static void main(String[] args){
        PlayfairCipher pf = new PlayfairCipher();
        char[][] mat = pf.constructKeyMatrix("GravityFalls".toUpperCase());
        String enctext = pf.encrypt("hello world".toUpperCase().replaceAll("\\s",""));
        System.out.println(pf.decrypt(enctext));
    }
}
