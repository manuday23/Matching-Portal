package q7;
import Tinder.*;
/**
 * Class to sort the couples according to boyname
 * @author MANISH THAKUR
 *
 */
public class SortedArray extends Pairing{
	/**
	 * Method for adding the couples into the array and sorting them
	 */
	public void pair(Couple c[],int id)
	{
		int i,j;
		int res;
		Couple tmp; 
		for(i=0;i<id-1;i++)
		{
			for(j=i+1;j<id;j++)
			{
				if(c[i] != null && c[j] != null)
				{
					res = c[i].getBnda().getName().compareTo(c[j].getBnda().getName());
					if(res > 1)
					{
						tmp = c[i];
						c[i] = c[j];
						c[j] = tmp;
					}
				}
			}
			
		}
		
	}
	
	/**
	 * Method for binary search
	 * @param c Couple Array
	 * @param l lower index
	 * @param u uper index
	 * @param s String (boyname)
	 * @param id int (size of the couple array)
	 * @return int
	 */
	public int binary(Couple c[],int l,int u, String s,int id)
	{
		int mid;
		int ct=-1;

	     if(l<u){
	          mid=(l+u)/2;
	          if(s.compareTo(c[mid].getBnda().getName())== 0){
	              return mid;
	          }
	          else if(s.compareTo(c[mid].getBnda().getName()) < 0){
	              return binary(c,l,mid-1,s,id);
	          }
	          else
	              return binary(c,mid+1,u,s,id);
	     }
	     else
	       return ct;
	}
	
	/**
	 * function will return the girlfriend name
	 * @param c couple array
	 * @param s string (boyName)
	 * @param id int(size of the couple array)
	 * @return String (girlName)
	 */
	public String findGirl(Couple c[],String s,int id)
	{
		int ans;
		ans = binary(c,0,id,s,id);
		if(ans == -1)
		{
			return  " ";
		}
		else 
		{
			return c[ans].getBndi().getName();
		}
	}
}


