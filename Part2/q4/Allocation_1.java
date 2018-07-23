package q4;
import Tinder.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 * Class for allocation of gifts
 * @author MANISH THAKUR
 *
 */
public class Allocation_1  {
	/**
	 * Method for allocation of gifts to the couples
	 * @param c couple array
	 * @param id int(couple array Size)
	 *
	 * @param gft Arraylist of gifts
	 * @throws IOException
	 */
	public void allocation(Couple c[],int id,ArrayList<Gift>gft) throws IOException
	{
		int total;
		
		
		int k;
		int i,j;
		int cpt;
		File out = new File("Output_log.txt");
		String type;
		
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
		int sz = gft.size();
		//System.out.println(sz);
		for(i=0;i<id;i++)
		{
			
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
		}
			bw.close();
	}
}


