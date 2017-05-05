import java.io.*;

public class RenderFirst
{
	public File file;
	public static int width;
	public static int height;
	public char[] cbuf ;
	public RenderFirst(File f)
	{
		file=f;
	}
	public File convertToBin()
	{
		try
		{
			FileReader read= new FileReader(file);
			BufferedReader br = new BufferedReader(read);
		    cbuf = new char[(int) file.length()];
	        br.read(cbuf);  
	       
	        String buf= new String(cbuf);
	        
	        int ind= buf.lastIndexOf("/W");
	        String t="";
	        for(int g= ind+2; g < (int) file.length(); g++)
	        {
	        	if(cbuf[g]!=' ')
	        	{
	        		t+=cbuf[g];
	        	}		
	        }
	    	String[] binaryString;
	        String[] two= t.split("L");
	        if(ind>1)
	        {
	             binaryString = new String[ind-1];
	        }
	        else
	        {
	        	binaryString = new String[cbuf.length];
	        }
	        FileWriter w= new FileWriter(file);
	        int counter=1;
	        for(int i= 0 ;  i < ind-1; i++)
	        {
	        	binaryString[i]= Integer.toBinaryString((int) cbuf[counter]);
	        	if(i < ind-2)
	        	{
	        		String temp="";
	        		int b= binaryString[i].length();
	        		
	        		while(b < 7)
	        		{
	        			temp+="0";
	        			++b;
	        		}
	        		binaryString[i]= temp+binaryString[i];
	        	}
	        	++counter;
	        }
	        	int c= Integer.parseInt(cbuf[0]+"");
	        	
	        	int d= binaryString[binaryString.length-1].length();
	        	String temp="";
	        	if(d > (7-c))
	        	{
	        		while(d!= (7-c))
		        	{
		        		temp+="0";
		        		--d;
		        	}
	        	}
	        	else if( d < (7-c))
	        	{
	        		while(d!= (7-c))
		        	{
		        		temp+="0";
		        		++d;
		        	}
	        	}
	        	binaryString[binaryString.length-1]= temp+binaryString[binaryString.length-1];
	        	
	        for(int i=0; i < binaryString.length; i++)
	        {
	        	w.write(binaryString[i]);
	        }
	        width= Integer.parseInt(two[0]);
	        height= Integer.parseInt(two[1]);
	        read.close();
	        br.close();
	        w.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return file;
	}
}