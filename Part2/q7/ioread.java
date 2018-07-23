package q7;
import java.util.*;


import Tinder.Boy;

import java.sql.*;
import java.io.*;
import java.math.*;
import java.sql.Timestamp;
import Tinder.*;

/**
 * Class for all i/o operation in the program
 * @author MANISH THAKUR
 *
 */
public class ioread {

		
		InputStreamReader cin = null;
		int n;
		Scanner sc = new Scanner(System.in);
		int i;
		int m;
		Random rand = new Random();
		int t;
		Boy b[] = new Boy[1000];
		Girl g[] = new Girl[1000];
		//Gift gft[] = new Gift[105];
		ArrayList<Gift>gft = new ArrayList<>();
		//Couple cd[] = new Couple[m];
		Couple c[]=new Couple[1000];
		BufferedReader br = null;
		FileReader fr = null;
		int k;
		int j;
		int id =0;
		
		/**
		 *  for Genrating the Boys data
		 * @throws IOException
		 */
		public void Boydata() throws IOException
		{
			String name;
			int atv;
			int iq;
			int money;
			String type;
		    n = rand.nextInt(50)+10;
		    File out = new File("Input_boy.txt");
			FileOutputStream fos = new FileOutputStream(out);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for(i=1;i<=n;i++)
			{
				name = "boy"+i;
				atv = rand.nextInt(100);
				iq = rand.nextInt(200);
				money =  rand.nextInt(10000);
				t = rand.nextInt(3);
				if(t==0)
				{
					type = "Miser";
				}
				else if(t==1)
				{
					type = "Generous";
				}
				else
					type = "Geek";
				bw.write(name+" "+atv+" "+iq+" "+money+" "+type);
				bw.newLine();
		    }
			 
			bw.close();
		}
		
		/**
		 * For genrating the girl data
		 * @throws IOException
		 */
		public void Girdata() throws IOException
		{
			String name;
			int atv;
			int iq;
			int money;
			String type;
			m = rand.nextInt(50)+1;
			File gout = new File("Input_Girl.txt");
			FileOutputStream gfos = new FileOutputStream(gout);
			BufferedWriter gbw = new BufferedWriter(new OutputStreamWriter(gfos));
			for(i=1;i<=m;i++)
			{
				name = "girl"+i;
				atv = rand.nextInt(100);
				iq = rand.nextInt(200);
				money =  rand.nextInt(10000);
				t = rand.nextInt(3);
				if(t==0)
				{
					type = "Choosy";
				}
				else if(t==1)
				{
					type = "Normal";
				}
				else
					type = "Desprate";
			    gbw.write(name+" "+atv+" "+iq+" "+money+" "+type);
				gbw.newLine();
		    }
			 
			gbw.close();
		}
		
		
		/**
		 * Method for scanning the boy data
		 * @throws FileNotFoundException
		 */
		public void Boyscan() throws FileNotFoundException
		{
			fr = new FileReader("Input_boy.txt");
			br = new BufferedReader(fr);
			String s;
			int it;
			int a;
			int bd;
			String type;
			try {
				for(i=0;i<n;i++)
				{
					String sCurrentLine=br.readLine();
					StringTokenizer st = new StringTokenizer(sCurrentLine," ");
				    s=st.nextToken();
				    a=Integer.parseInt(st.nextToken());
				    it = Integer.parseInt(st.nextToken());
				    bd = Integer.parseInt(st.nextToken());
				    type  = st.nextToken();
				    if(type.equals("Miser"))
				    {
				    	b[i] = new Miser(s,a,i,bd,false);
				    }
				    if(type.equals("Geek"))
				    {
				    	b[i] = new Geek(s,a,i,bd,false);
				    }
				    if(type.equals("Generous"))
				    {
				    	b[i] = new Generous(s,a,i,bd,false);

				    }
				}
			}catch(IOException e)
			{
				System.out.println(e);
			}
		}
			
		/**
		 * Method for scanning the girl data
		 * @throws FileNotFoundException
		 */
			public void Girlscan() throws FileNotFoundException
			{
				fr = new FileReader("Input_Girl.txt");
				br = new BufferedReader(fr);
				String s;
				int it;
				int a;
				int bd;
				String type;
				try
				{
					for(i=0;i<m;i++)
					{
						String sCurrentLine=br.readLine();
						StringTokenizer st = new StringTokenizer(sCurrentLine," ");
					    s=st.nextToken();
					    a=Integer.parseInt(st.nextToken());
					    it = Integer.parseInt(st.nextToken());
					    bd = Integer.parseInt(st.nextToken());
					    type  = st.nextToken();
					    if(type.equals("Choosy"))
					    {
					    	g[i] = new Choosy(s,a,it,bd);
					    }
					    if(type.equals("Normal"))
					    {
					    	g[i] = new Normal(s,a,it,bd);
					    }
					    if(type.equals("Desprate"))
					    {
					    	g[i] = new Desprate(s,a,it,bd);

					    }
					}
			}catch(IOException e)
				{
					System.out.print(e);
				}
			}
			
			
		/**
		 * Method for generating the Gifts data
		 * @throws IOException
		 */
		public void Giftdata() throws IOException
		{
			File g_out = new File("Input_gift.txt");
			FileOutputStream g_fos = new FileOutputStream(g_out);
			BufferedWriter g_bw = new BufferedWriter(new OutputStreamWriter(g_fos));
		    int value;
		    String name;
		    int money;
		    String type;
			for(i=0;i<100;i++)
			{
				name = "Gift"+i;
				value = rand.nextInt(100);
				money =  rand.nextInt(1000)+500;
				t = rand.nextInt(3);
				if(t==0)
				{
					type = "Essential";
				}
				else if(t==1)
				{
					type = "Luxury";
				}
				else
					type = "Utility";
				g_bw.write(name+" "+value+" "+money+" "+type);
				g_bw.newLine();
			}
			g_bw.close();
			
		}
			
		/**
		 * Method for scanning the gift data	
		 * @throws FileNotFoundException
		 */
		public void Giftscan() throws FileNotFoundException
		{
			fr = new FileReader("Input_gift.txt");
			br = new BufferedReader(fr);
			String s;
			int a;
			int it;
			String type;
			try{
				
				for(i=0;i<100;i++)
				{
					Gift g;
					String sCurrentLine=br.readLine();
					StringTokenizer st = new StringTokenizer(sCurrentLine," ");
				    s=st.nextToken();
				    a=Integer.parseInt(st.nextToken());
				    it = Integer.parseInt(st.nextToken());
				    type  = st.nextToken();
				  //  System.out.println(type);
				    if(type.compareTo("Luxury")==0)
				    {
				    	g = new Luxury(s,a,it);
				    	gft.add(g);
				    }
				    if(type.compareTo("Essential")==0)
				    {
				    	g= new Essential(s,a,it);
				    	gft.add(g);
				    }
				    if(type.compareTo("Utility")==0)
				    {
				    	g = new Utility(s,a,it);
				    	gft.add(g);
				    }
				    //System.out.print(gft.size());
				    
				}
				
			}catch(IOException e)
			{
				System.out.print(e);
			}
			//Arrays.sort(gft,new Comparison());
			
		}
		
		/**
		 * Method for forming the couples
		 * @throws IOException
		 */
		public void FormCouple() throws IOException
		{
			File output = new File("Output_log.txt");
			
			FileOutputStream fos = new FileOutputStream(output);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			int j;
			bw.write("Type of Event      "+  "      Status       "+ "                Date &  Time   ");
			bw.newLine();
			bw.newLine();
			for(i=0;i<m;i++)
			{
				for(j=0;j<n;j++)
				{	
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					bw.write("Coupling              "+  g[i].getName()+" checking on "+ b[j].getName()+ "        "+timestamp);
					bw.newLine();
					if(b[j] != null && g[i] != null)
					{
						if((b[j].getBudget() >= g[i].getMbudget() )&& (b[j].isCoupled() == false))
						{
							b[j].setCoupled(true);
							c[id] = new Couple(id,b[j],g[i]);
							timestamp = new Timestamp(System.currentTimeMillis());
							
							bw.write("Coupling              "+  g[i].getName()+" Got Committed to "+ b[j].getName()+ "        "+timestamp);
							bw.newLine();
							id++;
							break;
						}
					}
					else
						break;
						
				}
			}
			bw.close();
		}
		//Collections.sort(gft);
		/**
		 * Method for allocating the gifts to the couples
		 * @throws IOException
		 */
		public void GiftAllocation() throws IOException
		{
			Allocation_1 al1 = new Allocation_1();
			al1.allocation(c, id, gft);
		}
		
		/**
		 * Function to find the girlfriend of the given boy
		 * @throws IOException
		 */
		public void findGirlfriend() throws IOException
		{
			File out = new File("Find_girl.txt");
			FileOutputStream fos = new FileOutputStream(out);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			bw.newLine();
			bw.newLine();
			bw.write("				Finding Girl   	Using 	sorted Array				");
			bw.newLine();
			bw.newLine();
			bw.write("Boy Name     "+ "   	Girl name       ") ;
			bw.newLine();
			bw.newLine();
			int i;
			String s;
			SortedArray ans = new SortedArray();
			ans.pair(c, id);
			for(i=1;i<=n;i++)
			{
				
				if(b[i] != null)
				{
					
					s = ans.findGirl(c, b[i].getName(), id);
					if(s.equals(" "))
					{
						bw.write(b[i].getName()+"      has     no      GirlFriend   ");
						bw.newLine();
					}
					else
					{
						bw.write(b[i].getName()+"      has  "+s+"    as his Girlfriend");
						bw.newLine();
					}
					
					
				}
			}
			
			
			bw.newLine();
			bw.newLine();
			bw.write("         Finding girlfriend using Linked list            ");
			bw.newLine();
			bw.newLine();
			Linkedlist ans1 = new Linkedlist();
			ans1.pair(c, id);
			/*for(i=1;i<=n;i++)
			{
				
				if(b[i] != null)
				{
					
					s = ans1.findGirl(b[i].Name);
					if(s.equals(" "))
					{
						bw.write(b[i].Name+"      has     no      GirlFriend   ");
						bw.newLine();
					}
					else
					{
						bw.write(b[i].Name+"      has  "+s+"    as his Girlfriend");
						bw.newLine();
					}
					
					
				}
			}*/
			
			bw.newLine();
			bw.newLine();
			bw.write("         Finding girlfriend using Hash Table            ");
			bw.newLine();
			bw.newLine();
			HashTable ans3 = new HashTable();
			ans3.pair(c, id);
			for(i=1;i<=n;i++)
			{
				
				if(b[i] != null)
				{
					s = ans3.findGirl(b[i].getName());
					if(s.equals(" "))
					{
						bw.write(b[i].getName()+"      has     no      GirlFriend   ");
						bw.newLine();
					}
					else
					{
						bw.write(b[i].getName()+"      has  "+s+"    as his Girlfriend");
						bw.newLine();
					}
					
					
				}
			}
			
			bw.close();
		}
		
		
		/**
		 * Method for Calculating the happiness of the couples
		 */
		public void CalculateHappiness()
		{
			int i;
			for(i=0;i<id;i++)
			{
				c[i].setGhappy(c[i].getBndi().Happiness(c[i]));
				c[i].setBhappy(c[i].getBnda().Happiness(c[i]));
				c[i].setSum(c[i].getBhappy() + c[i].getGhappy());
					
			}
		}
			
		
		
		
		
		
		/**
		 * Method for Calculating the compatibility of the couples 
		 */
		public void CalculateCompatibility()
		{
			for(i=0;i<id;i++)
			{
				c[i].setCompatibility(Math.abs(c[i].getBnda().getAtv() - c[i].getBndi().getAtv())+Math.abs(c[i].getBnda().getBudget() - c[i].getBndi().getMbudget())+Math.abs(c[i].getBnda().getIntelligence() - c[i].getBndi().getIq()));

			}
		}
		
		
		/**
		 * Method for storing the happiness of the couples into the file
		 * @throws IOException
		 */
		public void DisplayHappy() throws IOException
		{
			
			Arrays.sort(c,new cmp());
			k = rand.nextInt(200);
			if(k > id)
			{
				k = id;
			}
			File out = new File("Anwser_Happines_and_compatibility.txt");
			
			FileOutputStream fos = new FileOutputStream(out);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("Top "+k+" Happiest Couples are as follow  :");
			bw.newLine();
			for(i=0;i<k;i++)
			{
				bw.write("Couple :"+i+" "+ c[i].getBnda().getName() + " "+c[i].getBndi().getName()+" "+"Boy Happiness :"+(int)c[i].getBhappy()+" "+"Girl Happiness :"+(int)c[i].getGhappy()+" "+"Couple Happiness :"+(int)c[i].getSum());
				bw.newLine();
				//System.out.println("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name+" "+"Boy Happiness :"+(int)c[i].bhappy+" "+"Girl Happiness :"+(int)c[i].ghappy+" "+"Couple Happiness :"+(int)c[i].sum);
			
			}
			bw.close();
			
		}
		
		
		/**
		 * Method for storing compatibilities of the couples into the file
		 * @throws IOException
		 */
		public void DisplayCompatibility() throws IOException
		{
			
			File oout = new File("Anwser_Happines_and_compatibility.txt");
			FileOutputStream foss = new FileOutputStream(oout,true);
			BufferedWriter obw = new BufferedWriter(new OutputStreamWriter(foss));
			Arrays.sort(c,new Comptcmp());
			obw.newLine();
			
			if(k > id)
			{
				k = id;
			}
			obw.write("Top "+k+" most compatible Couples are as follow  :");
			obw.newLine();
			System.out.println();
			for(i=0;i<k;i++)
			{
				obw.write("Couple :"+i+" "+ c[i].getBnda().getName() + " "+c[i].getBndi().getName()+" "+"Comptibility :"+c[i].getCompatibility());
				obw.newLine();
				//System.out.println("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name+" "+"Comptibility :"+c[i].compatibility);
	
			}
			obw.close();
			
		
		}
		
		/**
		 * Method for writing the gift details into the file
		 * @throws IOException
		 */
		public void giftDisplay() throws IOException
		{
			int s;
			int j;
			File oout = new File("Anwser_Gift.txt");
			FileOutputStream foss = new FileOutputStream(oout);
			BufferedWriter obw = new BufferedWriter(new OutputStreamWriter(foss));
			obw.write("            List of Gifts Given");
			obw.newLine();
			obw.newLine();String type;
			
			for(i=0;i<id;i++)
			{
				s = c[i].getAl().size();
				obw.newLine();
				obw.write(c[i].getBnda().getName() +" gave following gifts to "+ c[i].getBndi().getName());
				obw.newLine();
				obw.newLine();
				obw.write("Gift Name "+ "  Gift Price  " + "  Gift Value  " + "  	Gift Type  ");
				obw.newLine();
				obw.newLine();
				//System.out.println(c[i].bnda.Name +" gave following gifts to "+ c[i].bndi.Name);
				for(j=0;j<s;j++)
				{	
					if(c[i].getAl().get(j) instanceof Luxury)
					{
						type = "Luxury Gift";
						obw.write(c[i].getAl().get(j).getGname() +"   	 "+ c[i].getAl().get(j).getPrice() +"   	 	"+ c[i].getAl().get(j).getValue() +  "  		" + type);
						obw.newLine();
					}
					if(c[i].getAl().get(j) instanceof Essential)
					{
						type = "Essemtial Gift";
						obw.write(c[i].getAl().get(j).getGname() +"   	 "+ c[i].getAl().get(j).getPrice() +"   	 	"+ c[i].getAl().get(j).getValue() +  "  		" + type);
						obw.newLine();
					}
					if(c[i].getAl().get(j) instanceof Utility)
					{
						type = "Utility Gift";
						obw.write(c[i].getAl().get(j).getGname() +"   	 "+ c[i].getAl().get(j).getPrice() +"   	 	"+ c[i].getAl().get(j).getValue() +  "  		" + type);
						obw.newLine();
					}
					
				}
				
			}
			obw.close();
		}
}

	
	

			
			
			

	      
	      
	   
	
		

