import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Trial 
{
	int[] pixels;
	public static int[][] pix2D;
	public static RenderPanel can;
    Node treeRoot, myRoot;
    int counter;
    int width, height;
    int numOfNodes = 0;
    String coded="";
	int size;
	BufferedImage thisImage;
	String[] myString;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	HashMap<String, String> printmap = new HashMap<String, String>();
	public Trial(){}
	public Trial(BufferedImage image, BufferedWriter write) throws IOException
	{
		long start= System.currentTimeMillis();
		pixels = image.getRGB(0,0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		thisImage= image;
	    width = image.getWidth();
	    height = image.getHeight();
        for (int i = 0; i <(width*height); i++) 
	    {   
	         if(map.containsKey(pixels[i])){
	              int freq = map.get(pixels[i]);
	               map.put(pixels[i], freq+1);
	          }else{
                  map.put(pixels[i], 1);
              }
	     
	    }
	    writeHuff(write);
	    long end= System.currentTimeMillis();
	    System.out.println("Time: "+ (end-start));
	}
	public void codedString()
	{
		for(int j=0; j < thisImage.getHeight(); j++)
		{
			for(int i= 0; i < thisImage.getWidth(); i++)
			{
				String temp= thisImage.getRGB(i,j)+"";
				
					if(printmap.containsKey(temp))
					{
						coded+=map.get(temp);
					}
			}
		}
	}
	public BufferedImage compress(BufferedImage image, File f, HashMap<String, String> readMap)
	{	  
			long start= System.currentTimeMillis();
			HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
			for (Entry<String, String> entry : readMap.entrySet()) {
	            comp.put(Integer.parseInt(entry.getKey()), Integer.parseInt(entry.getValue()));
	        }
		 
		    buildTree(comp);
		    StringBuffer s= new StringBuffer("0");
		    if(treeRoot.left==null&& treeRoot.right== null)
		    	printCodes(treeRoot, s);
		    else
		    	printCodes(treeRoot, new StringBuffer());
		    
		    try
			{
				FileWriter w = new FileWriter(f);
				pix2D= new int[thisImage.getWidth()][ thisImage.getHeight()];
				for(int j=0; j < thisImage.getWidth(); j++)
				{
					for(int i= 0; i < thisImage.getHeight(); i++)
					{
						String temp= thisImage.getRGB(j,i)+"";
						
							if(printmap.containsKey(temp))
							{
									w.write(printmap.get(temp));
							}
						
					}
				}
				w.flush();
				w.close();
				myString= new String[pixels.length];
				 decode(readHuff(f), myRoot);
				 
				 for(int i=0; i< pix2D.length; i++)
		         {
		             for(int j=0; j<pix2D[i].length; j++)
		             {
		            	 if(myString[(i*(pix2D[i].length)) + j]!=null)
		            	 {
		            		 pix2D[i][j] = Integer.parseInt(myString[(i*(pix2D[i].length)) + j]);
		            	 }
		             }
		         }
			}
		    catch(IOException excp)
		    {}
		    GUI.upButtons[33].setIcon(GUI.upButtonIcon[34]);
		    GUI.upButtons[33].repaint();
		    long end= System.currentTimeMillis();
		    System.out.println("Time: "+ (end-start));
		    return image;
	}
	public void decode(char[] c ,Node root)
	{
		int y =0;
		if(root.left!=null&& root.right!=null)
		{
		    int length=c.length,i=0;
		    Node temp= root;
		   
		    while(length>i)
		    {
		    	if(c[i]=='1')
		    	{
		    		temp=temp.right;
		    		++i;
		    	}
		    	else if (c[i]=='0')
		    	{
		    		temp=temp.left;
		    		++i;
		    	}
		    	 if (temp.left == null && temp.right == null){
		    		 if(y < myString.length)
		    		 {
		    			 myString[y]=temp.key;
		 	    		++y;
		    		 }
		    	  	 temp = root;
		    	  	}
		    }
	    }
		else
		{
			for(int u=0; u < myString.length; u++)
				myString[u]=root.key;
			
		}
	}
	public char[] readHuff(File f) throws IOException
	{    
		FileReader fr = new FileReader(f);
	    Scanner scan = new Scanner(fr);
	    BufferedReader br = new BufferedReader(fr);
	    char[] cbuf = new char[(int) f.length()];
	    br.read(cbuf);  
	    
	    String mine= new String(cbuf);
	    int y= mine.length();
	    int add= 0;
	    while(y%7!=0)
	    {
	    	++add;
	    	mine+=" ";
	    	++y;
	    }
	   try
	   {
		   FileWriter ww = new FileWriter(f);
		   
		   ww.write(""+add);
		   
		   for(int b=0; b < mine.length(); b+=7)
		    {
		    	ww.write((char)Integer.parseInt(mine.substring(b, b+7).trim(), 2));
		    }
		   ww.write("/W"+thisImage.getWidth()+" L"+ thisImage.getHeight());
		   ww.close();
	   }
	   catch(IOException e){}
	     fr.close();
	     scan.close();
	     return cbuf;
	}
	public char[] read(File f) throws IOException
	{    
		FileReader fr = new FileReader(f);
	    Scanner scan = new Scanner(fr);
	    BufferedReader br = new BufferedReader(fr);
	         char[] cbuf = new char[(int) f.length()];
	         br.read(cbuf);  
	   
	    String mine= new String(cbuf);
	    int y= mine.length();
	    int add= 0;
	    while(y%7!=0)
	    {
	    	++add;
	    	mine+=" ";
	    	++y; 	
	    }
	   
	   try
	   {
		   FileWriter ww = new FileWriter(f);
		   
		   ww.write(""+add);
		   for(int b=0; b < mine.length(); b+=7)
		    {
		    	ww.write((char)Integer.parseInt(mine.substring(b, b+7).trim(), 2));
		    }
		   ww.close();
	   }
	   catch(IOException e){}

	    fr.close();
	    scan.close();
	    return cbuf;  
	}
	public void writeCodes(File f, int a, int c, File ff, HashMap<String, String> readMap)
	{
		HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
		for (Entry<String, String> entry : readMap.entrySet()) {
            comp.put(Integer.parseInt(entry.getKey()), Integer.parseInt(entry.getValue()));
        }
		 
		    pix2D= new int[a][c];
		    buildTree(comp);
			printCodes(treeRoot, new StringBuffer());
		    try
			{
				myString= new String[a*c];
				 decode(read(ff), myRoot);
				 
				 for(int i=0; i< pix2D.length; i++)
		         {
		             for(int j=0; j<pix2D[i].length; j++)
		             {
		            	 if(myString[(i*(pix2D[i].length)) + j]!=null)
		            		 pix2D[i][j] = Integer.parseInt(myString[(i*(pix2D[i].length)) + j]);
		             }
		
		         }
			}
		    catch(IOException excp)
		    {}
	}
	public void buildTree(HashMap<Integer, Integer> comp)
	{
		long start= System.currentTimeMillis();
		PriorityQueue<Node> nodeQueues = new PriorityQueue<Node>();
		
		for (Entry<Integer, Integer> entry : comp.entrySet()) {
            Integer pixel= entry.getKey();
            Integer freq = entry.getValue();
            nodeQueues.add(new Node(pixel+"", freq));
        }
		
		while(nodeQueues.size()>1)
		{
			Node a = nodeQueues.remove();
			Node b= nodeQueues.remove();
			
			Node c= new Node("", a.frequency+b.frequency);
			c.left = a; c.right = b;
			nodeQueues.add(c);
	
		}
		treeRoot=nodeQueues.peek();
		myRoot=nodeQueues.peek();
		size = comp.size();
		long end= System.currentTimeMillis();
	    System.out.println("Time build tree: "+ (end-start));
	}
	public void printCodes(Node root, StringBuffer code)
	{ 
		if(root!=null)
		{
			if(root.left==null&&root.right==null)
			{
				if(counter< size)
				{
					printmap.put(root.key, code.toString());
					++counter;
				}
			}
			else	
			{
				treeRoot=root;
				code.append('0');
				printCodes(treeRoot.left, code);
				code.deleteCharAt(code.length()-1);
		
				treeRoot=root;
				code.append('1');
				printCodes(treeRoot.right, code);
				code.deleteCharAt(code.length()-1);
			}
		}
	}
	public void writeHuff(BufferedWriter w) throws IOException{
		for (Entry<Integer, Integer> entry : map.entrySet()) {
            Integer pixel= entry.getKey();
            Integer freq = entry.getValue();
            w.write(pixel+" - "+freq);
			w.write(System.getProperty( "line.separator" ));
        }
	    w.flush();
	    w.close();
	}
	public HashMap<String,String> readHuffFile(File f) throws IOException{
		FileReader fr = new FileReader(f);
	    Scanner scan = new Scanner(fr);
	    HashMap<String,String> readMap = new HashMap<String,String>();
    	Scanner scanner= new Scanner(f);
	    while(scanner.hasNext())
	    {
	    	String pix = scanner.next();
	    	scanner.next();
	    	String freq = scanner.next();
	    	scanner.nextLine();
	    	readMap.put(pix, freq);
	     }
	    
	     fr.close();
	     scan.close();
	     scanner.close();
	     return readMap;
	}
	public void updateHuffFile(BufferedImage image, File f) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		thisImage= image;
	    pixels = image.getRGB(0,0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
	    width = image.getWidth();
	    height = image.getHeight();
	    int last= pixels.length;
	    map = new HashMap<Integer, Integer>();
        for (int i = 0; i <last; i++) 
	    {   
	         if(map.containsKey(pixels[i])){
	              int freq = map.get(pixels[i]);
	               map.put(pixels[i], freq+1);
	          }else{
                  map.put(pixels[i], 1);
              }
	     
	    }
	    HashMap<String, String> readMap = readHuffFile(f);
	    boolean isExist = false;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
            Integer pixel= entry.getKey();
            Integer freq = entry.getValue();
            for (Entry<String, String> entry2 : readMap.entrySet()) {
            	 String pixelString= entry2.getKey();
                 if((pixel+"").equals(pixelString)){
                	 isExist = true;
                 }
            }
            if(!isExist){
    			bw.write(pixel+" - "+freq);
    			bw.write(System.getProperty( "line.separator" ));
            }
            isExist = false;
        }
		 bw.flush();
		 bw.close();
	   
	}
	
}