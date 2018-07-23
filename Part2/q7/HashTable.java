package q7;
import Tinder.*;
import java.util.Hashtable;
import java.util.Map;
/**
 * Class for creating  hashtable
 * @author MANISH THAKUR
 *
 */
public class HashTable extends Pairing {
	 Hashtable<String,String> hm=new Hashtable<String,String>(); 
	 /**
	  * for Adding the couples into the hashtable
	  */
	 public void pair(Couple c[],int id)
	 {
		 int i;
		 for(i=0;i<id;i++)
		 {
			if(c[i] != null)
			{
				hm.put(c[i].getBnda().getName(),c[i].getBndi().getName());
			}
		 }
	 }
	 
	 /**
	  * function to find the Girlfriend of a boy
	  * @param s Boy name
	  * @return String thats is girlname
	  */
	 public String findGirl(String s)
	 {
		 for(Map.Entry m:hm.entrySet()){
			 if(((String) m.getKey()).compareTo(s)==0)
			 {
				 return (String)m.getValue();
			 }
		 }
		 return " ";
	 }
}
