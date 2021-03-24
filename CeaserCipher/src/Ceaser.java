import java.util.*;
public class Ceaser {
    public static String encrypt(String plaintext, int k){
        StringBuilder stringBuilder = new StringBuilder();
        // remove white spaces
        plaintext = plaintext.trim().replaceAll("\\s","").toUpperCase();
        System.out.println(plaintext);
        for(char enc:plaintext.toCharArray()){
            stringBuilder.append(Character.toString((char)(enc+k)));
        }
        return stringBuilder.toString();
    }
    public static String decrypt(String ciphertext, int k){
        StringBuilder stringBuilder = new StringBuilder();
        // remove white spaces
        ciphertext = ciphertext.trim().replaceAll("\\s","").toUpperCase();
        System.out.println(ciphertext);
        for(char enc:ciphertext.toCharArray()){
            stringBuilder.append(Character.toString((char)(enc-k)));
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter plaintext : ");
        String plaintext = input.nextLine();
        String enc = encrypt(plaintext, 4);
        System.out.println(decrypt(enc, 4));
    }
}
