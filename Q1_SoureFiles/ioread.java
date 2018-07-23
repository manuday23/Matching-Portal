import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.*;
public class ioread {

		
		
		int n;
		
		int m;
		String name;
		int atv;
		int iq;
		int money;
		int i;
		int id =0;
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		Boy b[] = new Boy[1000];
		Girl g[] = new Girl[1000];
		Couple c[] = new Couple[1000];
		public void Boydata() throws IOException
		{
			
			n = rand.nextInt(100);
			InputStreamReader cin = null;
			File out = new File("boy.txt");
			FileOutputStream fos = new FileOutputStream(out);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for(i=1;i<=n;i++)
			{
				name = "boy"+i;
				atv = rand.nextInt(100);
				iq = rand.nextInt(200);
				money =  rand.nextInt(10000)+100;
				//System.out.println(atv+"   "+ iq + "  "+money + " ");
				//fw.write(name);
				//System.out.print(name+" "+atv+" "+iq+" "+money);
				
					bw.write(name+" "+atv+" "+iq+" "+money);
					bw.newLine();
		   }
			 
				bw.close();
		}
		
		public void Girldata() throws IOException
		{
			m = rand.nextInt(50);
			File gout = new File("girl.txt");
			FileOutputStream gfos = new FileOutputStream(gout);
			BufferedWriter gbw = new BufferedWriter(new OutputStreamWriter(gfos));
			for(i=1;i<=m;i++)
			{
				name = "girl"+i;
				atv = rand.nextInt(100);
				iq = rand.nextInt(200);
				money =  rand.nextInt(10000)+100;
				//System.out.println(atv+"   "+ iq + "  "+money + " ");
				//fw.write(name);
				//System.out.print(name+" "+atv+" "+iq+" "+money);
				
					gbw.write(name+" "+atv+" "+iq+" "+money);
					gbw.newLine();
		   }
			 
			gbw.close();
			
		}
		
		public void Boyscan() throws FileNotFoundException
		{
			BufferedReader br = null;
			FileReader fr = null;
			fr = new FileReader("boy.txt");
			br = new BufferedReader(fr);
			String s;
			int it;
			int a;
			int bd;
		try {
			for(i=0;i<n;i++)
			{
				String sCurrentLine=br.readLine();
				StringTokenizer st = new StringTokenizer(sCurrentLine," ");
			    s=st.nextToken();
			    a=Integer.parseInt(st.nextToken());
			    it = Integer.parseInt(st.nextToken());
			    bd = Integer.parseInt(st.nextToken());
			    b[i] = new Boy(s,a,i,bd,false);
			    
				//System.out.println(sCurrentLine);
			}
		}catch(IOException e){
				System.out.println(e);
		}
		}
		
		
		
		public void Girlscan() throws FileNotFoundException
		{
			BufferedReader br = null;
			FileReader fr = null;
			fr = new FileReader("girl.txt");
			br = new BufferedReader(fr);
			String s;
			int it;
			int a;
			int bd;
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
				    g[i] = new Girl(s,a,i,bd);
				}
			
		}catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		
		public void Formcouple() throws IOException
		{	
			File out = new File("log1.txt");
			FileOutputStream fos = new FileOutputStream(out);
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
		
		public void DisplayCouple() throws IOException
		{
			File out = new File("Q1_output.txt");
			FileOutputStream fos = new FileOutputStream(out);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for(i=0;i<id;i++)
			{
				bw.write("Couple :"+i+" "+ c[i].bnda.Name + " got committed to  "+c[i].bndi.Name);
				bw.newLine();

				//System.out.println("Couple :"+i+" "+ c[i].bnda.Name + " "+c[i].bndi.Name);
			}
			bw.close();
		}
  }


	
	

			
			
			

	      
	      
	   
	
		

