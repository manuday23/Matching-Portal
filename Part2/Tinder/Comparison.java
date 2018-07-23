package Tinder;
import Tinder.*;
/**
 * Class for sorting Gifts according to their Price
 */
import java.util.Comparator;
public class Comparison implements Comparator  {
	public int compare(Object o1,Object o2){  
		Gift s1=(Gift)o1;  
		Gift s2=(Gift)o2;  
		if(s1 != null && s2 !=null)
		{
			if(s1.getPrice()==s2.getPrice())
			{
				if(s1.getValue() > s2.getValue())
					return 1;
				else return 0;
			} 
			else if(s1.getPrice() > s2.getPrice())  
				return 1;  
			else  
			 return -1;  
			}  
		
		else
			return 0;
	}

}
