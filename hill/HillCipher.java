import java.util.*;
/*

	[c1 c2 c3] = [p1 p2 p3]K

*/
class HillCipher{
	char[][] keyMat;
	int n;
	HillCipher(int n){
	   this.n = n;
	   keyMat = new char[n][n];
	}
	public void constructKeyMat(String key) throws Exception{
		if(key.length()!=n*n) throw new Exception("[ Key length must be equal to "+n*n+" ]");
		int i=0;
		int j=-1;
		for(char c:key.toCharArray()){
			if(j<(n-1)) j++;
			else if(i<(n-1)){
				i++;
				j=0;
			}
			keyMat[i][j] = c;
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++) System.out.print(" "+keyMat[i][j]);
			System.out.println();
		}
	}
	public String encrypt(String plaintext){
		// form pair of 3
		// if pair can't be formed let it be zero
		StringBuilder enc = new StringBuilder();
		char[] block = new char[this.n];
		int i = 0;
		int plen = plaintext.length();
		while(i<plen){
			int k = 0; // for indexing block
			int j = i;
			while(i<plen && i<j+this.n){
			     block[k++] = plaintext.charAt(i++);
			     //System.out.print(" "+block[k-1]);
			}
			
			//if pair can't be formed add 0 
			if(i>=plen){
			    while(k<n){
			    	block[k++]='0';
			    	// System.out.print(" "+block[k-1]);
			    }
			}
			// do matrix multiplication of block and key mat
			int sum;
		    	for (int m = 0; m < this.n; m++) {
		    		sum = 0;
				for (k = 0; k < this.n; k++){
				    System.out.print((int)block[k]+" "+(int)keyMat[k][m]+" ");
				    sum += (int)block[k]%26 * (int)keyMat[k][m]%26;
				}
				int ascii = (sum)%26+65;
				enc.append((char)(ascii));
		    	}
		    	
			//System.out.println();
		}
		return enc.toString().substring(0, plen);
	}
	public static void main(String[] args){
		int block_size = 2;
		HillCipher hc = new HillCipher(block_size);
		System.out.println("Block Size : "+block_size);
		try{
			hc.constructKeyMat("HILL");
			System.out.println("-----------------");
			String plaintext = "SHORT EXAMPLE";
			System.out.println("Plaintext : "+plaintext);
			String enc = hc.encrypt(plaintext.replaceAll("\\s",""));
			System.out.println("Ciphertext : "+enc);
		}catch(Exception e){
		   System.out.println(e.getMessage());
		}
		
	}
}
