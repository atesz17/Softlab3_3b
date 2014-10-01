package sorszuru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				String line = br.readLine();
				if (line.equals("exit"))
					break;
				else
					if (line.matches(args[0]))
						System.out.println(line);
			}
			br.close();
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		
	}

}
