package com.ceaser;

import java.util.*;
class Ceaser{
	public static String encrypt(String plaintext, int k){
	   StringBuilder cipherText = new StringBuilder();
	   plaintext = plaintext.toLowerCase().trim();
	   for(char c: plaintext.toCharArray()){

	   	if(Character.isLetter(c)){
	   	  cipherText.append(Character.toString((char)((c+k-97)%26+97)));
	   	}
	   	else cipherText.append(" ");
	   }
	   return cipherText.toString().toUpperCase();
	}
	public static String decrypt(String cipherText, int k){
	   StringBuilder plainText = new StringBuilder();

	   for(char c: cipherText.toCharArray()){
	   	if(Character.isLetter(c)){
	   	  int dec = c-k;
	   	  if(dec<65){
	   	   dec = 65-dec;
	   	   dec = (char)(91-dec);
	   	  }
	   	  plainText.append(Character.toString((char)dec));
	   	}
	   	else plainText.append(" ");
	   }
	   return plainText.toString().toLowerCase();
	}
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter plaintext : ");
	    String plainText = input.nextLine();
	    int key = 8;
	    String cipherText = encrypt(plainText, key);
	    String decryptedText = decrypt(cipherText, key);
	    System.out.println("Key : "+key);
	    System.out.println("Encrypted Text : "+cipherText);
	    System.out.println("Decrypted Text : "+decryptedText);
	}
}
