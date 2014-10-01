package sorszuru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{	
			File wd = new File(System.getProperty("user.dir"));
			
			String input = null;
			String output = null;
			String pattern = "";
			String outputGZIP = null;
			String inputGZIP = null;
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
				} else if ((i+1 < args.length) && args[i].equals("-gi")) {
					i++;
					inputGZIP = args[i];
				} else if ((i+1 < args.length) && args[i].equals("-go")) {
					i++;
					outputGZIP = args[i];
				}
				
				
			}
			BufferedReader br;
			if (input != null)
			{
				FileReader fr = new FileReader(new File(wd, input));
				br = new BufferedReader(fr);
			}
			else
			{
				FileInputStream fr = new FileInputStream(inputGZIP);
				GZIPInputStream g = new GZIPInputStream(fr);
				Reader decoder = new InputStreamReader(g, "UTF-8");
				br = new BufferedReader(decoder);
			}
			while(true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				if (line.matches(pattern))
				{
					PrintWriter pw;
					if (output != null)
					{
						FileWriter fw = new FileWriter(output, true);
						pw = new PrintWriter(fw);
					}
					else
					{
						FileOutputStream fo = new FileOutputStream(outputGZIP, true);
						GZIPOutputStream go = new GZIPOutputStream(fo);
						OutputStreamWriter o = new OutputStreamWriter(go);
						pw = new PrintWriter(o, true);
					}
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
