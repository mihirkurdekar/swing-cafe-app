package src.CafeApp;

import java.io.*;
public class FileOperations {
	
	/*
	 * writes the op of Exec class into a txt file
	 * can be used to check the exact output before printing
	 */
	public static void fileWriter()throws IOException{
		
		Writer output = null;
		
		File file = new File("bill.txt");
		output = new BufferedWriter(new FileWriter(file));
		String temp=new String (Exec.op);
		output.write(temp);
		output.close();
	}
}

