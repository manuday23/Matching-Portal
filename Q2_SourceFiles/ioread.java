import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.*;
import java.sql.Timestamp;
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
		Gift gft[] = new Gift[1000];
		//Couple cd[] = new Couple[m];
		Couple c[]=new Couple[1000];
		BufferedReader br = null;
		FileReader fr = null;
		int k;
		int j;
		int id =0;
		
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
				    b[i] = new Boy(s,a,i,bd,false,type);
				}
			}catch(IOException e)
			{
				System.out.println(e);
			}
		}
				
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
					    g[i] = new Girl(s,a,it,bd,type);
					}
			}catch(IOException e)
				{
					System.out.print(e);
				}
			}
		
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
					type = "Essential Gift";
				}
				else if(t==1)
				{
					type = "Luxury Gift";
				}
				else
					type = "Utility Gift";
				g_bw.write(name+" "+value+" "+money+" "+type);
				g_bw.newLine();
			}
			g_bw.close();
			
		}
			
			
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
					String sCurrentLine=br.readLine();
					StringTokenizer st = new StringTokenizer(sCurrentLine," ");
				    s=st.nextToken();
				    a=Integer.parseInt(st.nextToken());
				    it = Integer.parseInt(st.nextToken());
				    type  = st.nextToken();
				    gft[i] = new Gift(s,type,a,it);
				}
				
			}catch(IOException e)
			{
				System.out.print(e);
			}
			Arrays.sort(gft,new Comparison());
			
		}
		
		
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
					bw.write("Coupling              "+  g[i].Name+" checking on "+ b[j].Name+ "        "+timestamp);
					bw.newLine();
					if(b[j] != null && g[i] != null)
					{
						if((b[j].budget >= g[i].Mbudget )&& (b[j].coupled == false))
						{
							b[j].coupled = true;
							c[id] = new Couple(id,b[j],g[i]);
							timestamp = new Timestamp(System.currentTimeMillis());
							
							bw.write("Coupling              "+  g[i].Name+" Got Committed to "+ b[j].Name+ "        "+timestamp);
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
		//Arrays.sort(gft,new Comparison());
		
		public void CalculateHappiness() throws IOException
		{
			int total;
			double bhappy;
			double ghappy;
			int size;
			int ltotal;
			int k;
			int cpt;
			File out = new File("Output_log.txt");
			
			FileOutputStream fos = new FileOutputStream(out,true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			bw.newLine();
			bw.newLine();
			bw.write("				Gifting    					");
			bw.newLine();
			bw.write("GiftName     "+ "   Gift Type     "  + "From   "+ "	 To   "+ "  	   On Dated           ");
			bw.newLine();
			bw.newLine();
			//System.out.println(id);
			for(i=0;i<id;i++)
			{
				
				if(c[i].bnda.type.equals("Miser"))
				{	
					total=0;
					for(j=0;j<100;j++)
					{
						total = total +gft[j].price;
						if(total < c[i].bndi.Mbudget)
						{	
							timestamp = new Timestamp(System.currentTimeMillis());
							bw.write(gft[j].gname+"         	"+  gft[j].type + "       "+b[i].Name + "         "+ g[i].Name+ "        "+timestamp);
							bw.newLine();
							c[i].al.add(gft[j]);
						}
					    if(total >= c[i].bndi.Mbudget)
						{
							c[i].al.add(gft[j]);
							timestamp = new Timestamp(System.currentTimeMillis());
							bw.write(gft[j].gname+"         	"+  gft[j].type + "       "+b[i].Name + "         "+ g[i].Name+ "        "+timestamp);
							bw.newLine();
							bhappy = Math.abs(c[i].bnda.budget - total)%100;
							c[i].bhappy = bhappy%100;
							break;
								
						}
						
					}
					//System.out.println(total);
					if(c[i].bndi.type.equals("Choosy"))
					{	
						ltotal = 0;
						int l;
						size = c[i].al.size();
						for(l=0;l< size;l++)
						{
							if(c[i].al.get(l).type.equals("Luxury Gift"))
							{
								ltotal = ltotal + c[i].al.get(l).value;
							}
						}
						ghappy = Math.log(Math.abs(total-c[i].bndi.Mbudget + 2*ltotal))%100;
						c[i].ghappy = ghappy%100;
					}
				    if(c[i].bndi.type.equals("Desprate"))
					{
						ghappy = Math.exp(Math.abs(total - c[i].bndi.Mbudget))%100;
						c[i].ghappy = ghappy%100;
	
					}
					
				    if(c[i].bndi.type.equals("Normal"))
					{
						ghappy = Math.abs(total - c[i].bndi.Mbudget);
						c[i].ghappy = ghappy%100;
	
					}
					//System.out.println(total);
	
				}
			    if(c[i].bnda.type.equals("Generous"))
				{	
					total =0;
					for(j=0;j<100;j++)
					{
						total = total +gft[j].price;
						if(total <= c[i].bnda.budget)
						{
							c[i].al.add(gft[j]);
							timestamp = new Timestamp(System.currentTimeMillis());
							bw.write(gft[j].gname+"         	"+  gft[j].type + "       "+b[i].Name + "         "+ g[i].Name+ "        "+timestamp);
							bw.newLine();
						}
						if(total > c[i].bnda.budget)
	  					{
								
							break;
									
						}
					}
					if(c[i].bndi.type.equals("Choosy"))
					{	
						ltotal = 0;
						int l;
						size = c[i].al.size();
						for(l=0;l < size;l++)
						{
							if(c[i].al.get(l).type.equals("Luxury Gift"))
							{
								ltotal = ltotal + c[i].al.get(l).value;
							}
						}
						ghappy = Math.log(Math.abs(total-c[i].bndi.Mbudget) + 2*ltotal)%100;
						c[i].ghappy = ghappy%100;
						c[i].bhappy = ghappy%100;
					}
				    if(c[i].bndi.type.equals("Desprate"))
					{
						ghappy = Math.exp(Math.abs(total - c[i].bndi.Mbudget))%100;
						c[i].bhappy = ghappy%100;
						c[i].ghappy = ghappy%100;
	
	
					}
					
				    if(c[i].bndi.type.equals("Normal"))
					{
						ghappy = Math.abs(total - c[i].bndi.Mbudget);
						c[i].bhappy = ghappy%100;
						c[i].ghappy = ghappy%100;
	
	
					}
					//System.out.println(total);
	
				}
					
				
				if(c[i].bnda.type.equals("Geek"))
				{	
					total = 0;
					int f =0;
					c[i].bhappy = c[i].bndi.iq;
					for(j=0;j<100;j++)
					{
						total = total +gft[j].price;
						if(total < c[i].bndi.Mbudget)
						{
							c[i].al.add(gft[j]);
							timestamp = new Timestamp(System.currentTimeMillis());
							bw.write(gft[j].gname+"         	"+  gft[j].type + "       "+b[i].Name + "         "+ g[i].Name+ "        "+timestamp);
							bw.newLine();
						}
					    if(total >= c[i].bndi.Mbudget)
						{
							c[i].al.add(gft[j]);
							timestamp = new Timestamp(System.currentTimeMillis());
							bw.write(gft[j].gname+"         	"+  gft[j].type + "       "+b[i].Name + "         "+ g[i].Name+ "        "+timestamp);
							bw.newLine();
							total = total +gft[j].price;
							
							bhappy = Math.abs(c[i].bnda.budget - total);
							c[i].bhappy = bhappy%100;
							break;
							
								
									
						}
					}
					if(c[i].bndi.type.equals("Choosy"))
					{	
						ltotal = 0;
						int l;
						size = c[i].al.size();
						for(l=0;l< size;l++)
						{
							if(c[i].al.get(l).type.equals("Luxury Gift"))
							{
								ltotal = ltotal + c[i].al.get(l).value;
							}
						}
						ghappy = Math.log(Math.abs(total-c[i].bndi.Mbudget) + 2*ltotal)%100;
						//System.out.println(ghappy);
						c[i].ghappy = ghappy%100;
					}
				    if(c[i].bndi.type.equals("Desprate"))
					{
						ghappy = Math.exp(Math.abs(total - c[i].bndi.Mbudget))%100;
						//System.out.println(ghappy);
	
						c[i].ghappy = ghappy%100;
	
					}
					
					else if(c[i].bndi.type.equals("Normal"))
					{
						ghappy = Math.abs(total - c[i].bndi.Mbudget);
						//System.out.println(ghappy);
	
						c[i].ghappy = ghappy%100;
	
					}
					
				}
				c[i].sum = Math.abs(c[i].bhappy + c[i].ghappy);
	
				
					
			}
			bw.close();
		
		}
		
		
		
		
		public void CalculateCompatibility()
		{
			for(i=0;i<id;i++)
			{
				c[i].compatibility = Math.abs(c[i].bnda.Atv - c[i].bndi.atv)+Math.abs(c[i].bnda.budget - c[i].bndi.Mbudget)+Math.abs(c[i].bnda.intelligence - c[i].bndi.iq);

			}
		}
		
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
				bw.write("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name+" "+"Boy Happiness :"+(int)c[i].bhappy+" "+"Girl Happiness :"+(int)c[i].ghappy+" "+"Couple Happiness :"+(int)c[i].sum);
				bw.newLine();
				//System.out.println("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name+" "+"Boy Happiness :"+(int)c[i].bhappy+" "+"Girl Happiness :"+(int)c[i].ghappy+" "+"Couple Happiness :"+(int)c[i].sum);
			
			}
			bw.close();
			
		}
		
		
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
				obw.write("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name+" "+"Comptibility :"+c[i].compatibility);
				obw.newLine();
				//System.out.println("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name+" "+"Comptibility :"+c[i].compatibility);
	
			}
			obw.close();
			
		
		}
		
		public void giftDisplay() throws IOException
		{
			int s;
			int j;
			File oout = new File("Anwser_Gift.txt");
			FileOutputStream foss = new FileOutputStream(oout);
			BufferedWriter obw = new BufferedWriter(new OutputStreamWriter(foss));
			obw.write("            List of Gifts Given");
			obw.newLine();
			obw.newLine();
			for(i=0;i<id;i++)
			{
				s = c[i].al.size();
				obw.newLine();
				obw.write(c[i].bnda.Name +" gave following gifts to "+ c[i].bndi.Name);
				obw.newLine();
				obw.newLine();
				obw.write("Gift Name "+ "  Gift Price  " + "  Gift Value  " + "  	Gift Type  ");
				obw.newLine();
				obw.newLine();
				//System.out.println(c[i].bnda.Name +" gave following gifts to "+ c[i].bndi.Name);
				for(j=0;j<s;j++)
				{	
					obw.write(c[i].al.get(j).gname +"   	 "+ c[i].al.get(j).price +"   	 	"+ c[i].al.get(j).value +  "  		" + c[i].al.get(j).type);
					obw.newLine();
				}
				
			}
			obw.close();
		}
}

	
	

			
			
			

	      
	      
	   
	
		

