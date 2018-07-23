package q7;
import Tinder.*;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * Class for creating linked list
 * @author MANISH THAKUR
 *
 */
public class Linkedlist extends Pairing{
	LinkedList<Couple> arl=new LinkedList<Couple>();
	
	/**
	 * Method for adding the couples into the linked list
	 */
	public void pair(Couple c[],int id)
	{
		  int i;
		  for(i=0;i<id;i++)
		  {
			  if(c[i] != null)
			  {
				  arl.add(c[i]);
			  }
		  }
		  
	}
	
	/**
	 * Method for finding the the girl friend of the given boy
	 * @param s string
	 * @return string
	 */
	public String findGirl(String s)
	{
		Iterator<Couple> itr = arl.iterator();
		while(itr.hasNext())
		{
			if((itr.next()).getBnda().getName().equals(s))
			{
				return itr.next().getBnda().getName();
			}
		}
		return " ";
		
	}

}
