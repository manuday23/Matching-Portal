package Tinder;
import Tinder.*;
/**
 * Class for sorting Couples according to their Happiness
 */
import java.util.Comparator;
public class cmp implements Comparator  {
	public int compare(Object o1,Object o2)
	{  
		Couple s1=(Couple)o1;  
		Couple s2=(Couple)o2;
		if(s1 != null && s2 != null)
		{
			if(s1.getSum()==s2.getSum())
			{
				return 0;
			} 
			else if(s1.getSum() > s2.getSum())  
				return -1;  
			else  
			 return 1;  
		}
		else
			return 0;
	}
}
