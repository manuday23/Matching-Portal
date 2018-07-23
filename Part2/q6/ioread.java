package q6;
import Tinder.*;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.*;
import java.sql.Timestamp;
/**
 * Class for performing all i/o operations
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
		int test;
		/**
		 * Function for generating boys data
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
		    test =50 +  rand.nextInt(100);
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
		 * function for generating girls data;
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
		 * Function for scanning boys data
		 * @throws IOException
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
		 * Function for scanning girls data
		 * @throws IOException
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
			 * Function for generating gifts data
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
		 * Function for scanning gifts data
		 * @throws IOException
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
		 * Method for forming couple
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
							g[i].setCoupled(true);
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
		 * Method for allocation of gifts
		 * @throws IOException
		 */
		public void GiftAllocation() throws IOException
		{
			Allocation_1 al1 = new Allocation_1();
			al1.allocation(c, id, gft);
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
				c[i].setSum( c[i].getBhappy() + c[i].getGhappy());
					
			}
		}
		
		/**
		 * Method for breakup of couples
		 * @throws IOException
		 */
		public void BreakUp() throws IOException
		{
			int i;
			int sz = id;
			int j = 0;
			File out = new File("Output_log.txt");
			String type;
			
			FileOutputStream fos = new FileOutputStream(out,true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.newLine();
			bw.newLine();
			
			for(j=50;j<=test;j++)
			{
				for(i=0;i<id;i++)
				{
					if(c[i].getSum() < j)
					{
					
						c[i].getBndi().setCoupled(false);
						c[i].getBnda().setCoupled(false);
						int it;
						for(it=1;it<=m;it++)
						{
							if(g[it] != null)
							{
								if(g[it].getName().equals(c[i].getBndi().getName()))
								{
									g[it].setCoupled(false);
								}
							}
						}
						for(it=1;it<=n;it++)
						{
							
							if(b[it] != null)
							{
								if(b[it].getName().equals(c[i].getBndi().getName()))
								
									b[it].setCoupled(false);
								}
							}
						}
						
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						bw.write(c[i].getBndi().getName() +" Broke up with  "+ c[i].getBnda().getName() + "  at  " +timestamp);
						bw.newLine();
					}
				}
				
				bw.newLine();
				bw.newLine();
				bw.close();
				PatchUP();
			}
			
		
		/**
		 * Method for replacing boyfriend
		 * @param by boy object
		 * @param i int 
		 * @throws IOException
		 */
		public void ReplaceBoyfriend(Boy by,int i) throws IOException
		{
			c[i].setBnda(by);
			c[i].getAl().clear();
			int total;
			File out = new File("Output_log.txt");
			String type;
			
			FileOutputStream fos = new FileOutputStream(out,true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			bw.newLine();
			bw.newLine();
			bw.write("				Gifting    					");
			bw.newLine();
			bw.write("GiftName     "+ "   Gift Type     "  + "		From   "+ "	 	To   "+ "  	   On Dated           ");
			bw.newLine();
			bw.newLine();
			int sz = gft.size();
			//System.out.println(sz);
			
				
				if(c[i].getBnda() instanceof Miser == true)
				{	
					total=0;
					for(j=0;j<sz;j++)
					{
						
						
							total = total + gft.get(j).getPrice();
							if(total < c[i].getBndi().getMbudget())
							{	
								if(gft.get(j) instanceof Luxury == true)
								{
									type = "Luxury Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Essential == true)
								{
									type = "Essential Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Utility == true)
								{
									type = "Utility Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								c[i].getAl().add(gft.get(j));
							}
						
		
								
					}
						
				
			   // System.out.println(c[i].al.size());
					
					//System.out.println(total);
	
				}
			    if(c[i].getBnda() instanceof Generous == true)
				{	
					total =0;
					for(j=0;j<sz;j++)
					{
						
							
							total = total + gft.get(j).getPrice();
							if(total <= c[i].getBnda().getBudget())
							{
								c[i].getAl().add(gft.get(j));
								if(gft.get(j) instanceof Luxury)
								{
									type = "Luxury Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Essential == true)
								{
									type = "Essential Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Utility == true)
								{
									type = "Utility Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
							}
							if(total > c[i].getBnda().getBudget())
		  					{
									
								break;
										
							}
						}
					
				}
					
				
				if(c[i].getBnda() instanceof Geek == true)
				{	
					total = 0;
					int f =0;
					for(j=0;j<sz;j++)
					{
						
							
							total = total +gft.get(j).getPrice();
							if(total < c[i].getBndi().getMbudget())
							{
								c[i].getAl().add(gft.get(j));
								if(gft.get(j) instanceof Luxury == true)
								{
									type = "Luxury Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Essential == true)
								{
									type = "Essential Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Utility == true)
								{
									type = "Utility Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
							}
						    if(total >= c[i].getBndi().getMbudget())
							{
								c[i].getAl().add(gft.get(j));
								if(gft.get(j) instanceof Luxury == true)
								{
									type = "Luxury Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Essential == true)
								{
									type = "Essential Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								if(gft.get(j) instanceof Utility == true)
								{
									type = "Utility Gift";
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
									bw.newLine();
								}
								total = total +gft.get(j).getPrice();
								break;	
										
							}
						
					}
				   
				}
			
				bw.close();
				c[i].setGhappy(c[i].getBndi().Happiness(c[i]));
				c[i].setBhappy(c[i].getBnda().Happiness(c[i]));
				c[i].setSum( c[i].getBhappy() + c[i].getGhappy());
			
		}
		
		
		/**
		 * function for finding new boyfriend
		 * @throws IOException
		 */
		public void PatchUP() throws IOException
		{
			int i;
			
			File output = new File("Output_log.txt");
			
			FileOutputStream fos = new FileOutputStream(output,true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			int j;
			bw.newLine();
			bw.newLine();
			bw.write("Type of Event      "+  "      Status       "+ "                Date &  Time   ");
			bw.newLine();
			bw.newLine();
			int f = 0;
			for(i=0;i<id;i++)
			{
				if(c[i] != null && c[i].getBndi().isCoupled() == false)
				{
					for(j=0;j<n;j++)
					{	
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
							bw.write("ReCoupling              "+  c[i].getBndi().getName()+" checking on "+ b[j].getName()+ "        "+timestamp);
							bw.newLine();
							if(c[i].getBndi() != null && b[j] != null)
							{
								if((b[j].getBudget() >= c[i].getBndi().getMbudget() )&& (b[j].isCoupled() == false))
								{
									b[j].setCoupled(true);
									c[i].getBndi().setCoupled(true);
									//c[id] = new Couple(id,b[j],g[i]);
									timestamp = new Timestamp(System.currentTimeMillis());
									bw.newLine();
									bw.write("Coupling              "+  g[i].getName()+" Got Committed to "+ b[j].getName()+ "        "+timestamp);
									bw.newLine();
									bw.newLine();
									ReplaceBoyfriend(b[j],i);
									break;
								}
							}
							else
								break;
							
					}
				}
			}
			bw.close();
		}
		
		
		
		
		
		/**
		 * Method for calculating Compatibility
		 */
		public void CalculateCompatibility()
		{
			for(i=0;i<id;i++)
			{
				c[i].setCompatibility(Math.abs(c[i].getBnda().getAtv() - c[i].getBndi().getAtv())+Math.abs(c[i].getBnda().getBudget() - c[i].getBndi().getMbudget())+Math.abs(c[i].getBnda().getIntelligence() - c[i].getBndi().getIq()));

			}
		}
		
		
		 /**
		  * Method for writing happiness into the file
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
		 * Method for writing the compatibility into the file
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
		 * Method for storing the details of gifts
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

	
	

			
			
			

	      
	      
	   
	
		

