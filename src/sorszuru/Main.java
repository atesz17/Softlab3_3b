package sorszuru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{	
			File wd = new File(System.getProperty("user.dir"));
			
			String input = null;
			String output = null;
			String pattern = "";
			for (int i = 0; i < args.length; i++) {
				if ((i+1 < args.length) && args[i].equals("-i")) {
					i++;
					input = args[i];
				} else if ((i+1 < args.length) && args[i].equals("-o")) {
					i++;
					output = args[i];
				} else if ((i+1 < args.length) && args[i].equals("-p")) {
					i++;
					pattern = args[i];
				}
			}
			
			FileReader fr = new FileReader(new File(wd, input));
			BufferedReader br = new BufferedReader(fr);
			while(true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				if (line.matches(pattern))
				{
					FileWriter fw = new FileWriter(output, true);
					PrintWriter pw = new PrintWriter(fw);
					pw.println(line);
					pw.close();
				}
			}
			br.close();
			System.out.println("Done!");
		}
		catch(IOException e)
		{
			e.getMessage();
		}
	}
}
