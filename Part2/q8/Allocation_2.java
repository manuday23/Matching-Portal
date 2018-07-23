package q8;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import Tinder.*;
/**
 * Class for allocating  the gifts 2nd time
 * @author MANISH THAKUR
 *
 */
public class Allocation_2 extends GiftAllocation{
	/**
	 * Method to allocate the desired gifts to the couples
	 */
	public void allocation(Couple c[],int id,ArrayList<Gift>gft) throws IOException
	{
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
		
		int i;
		int j;
		int sz;
		int c1,c2,c3;
		for(i=0;i<id;i++)
		{
			c1= 0;
			c2 = 0;
			c3 = 0;
			sz = c[i].getAl().size();
			for(j=0;j<sz;j++)
			{
				if(c[i].getAl().get(j) instanceof Luxury== true)
				{
					c1++;
				}
				if(c[i].getAl().get(j) instanceof  Essential== true)
				{
					c2++;
				}
				if(c[i].getAl().get(j) instanceof Utility== true)
				{
					type = "Utility Gift";
					c3++;
				}
			}
			if(c1 == 0)
			{
				for(j=0;j<gft.size();j++)
				{
					if(gft.get(j) instanceof Luxury)
					{
						c[i].getAl().add(gft.get(j));
						type = "Luxury Gift";
						timestamp = new Timestamp(System.currentTimeMillis());
						bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
						bw.newLine();
						break;

					}
				}
			}
			if(c2 == 0)
			{
				for(j=0;j<gft.size();j++)
				{
					if(gft.get(j) instanceof Essential)
					{
						c[i].getAl().add(gft.get(j));
						type = "Essential Gift";
						timestamp = new Timestamp(System.currentTimeMillis());
						bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
						bw.newLine();
						break;

					}
				}
			}
			if(c3 == 0)
			{
				for(j=0;j<gft.size();j++)
				{
					if(gft.get(j) instanceof Utility)
					{
						c[i].getAl().add(gft.get(j));
						type = "Utility Gift";
						timestamp = new Timestamp(System.currentTimeMillis());
						bw.write(gft.get(j).getGname()+"         	"+  type + "       "+c[i].getBnda().getName() + "         "+ c[i].getBndi().getName()+ "        "+timestamp);
						bw.newLine();
						break;

					}
				}
			}
		}
		bw.close();
	}
	
	

}
