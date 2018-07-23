package Tinder;
import Tinder.*;
/**
 * Class for sorting Couples according to their Compatibility
 */
import java.util.Comparator;
public class Comptcmp implements Comparator  {
	public int compare(Object o1,Object o2)
	{  
		Couple s1=(Couple)o1;  
		Couple s2=(Couple)o2;
		if(s1 != null && s2 != null)
		{

			if(s1.getCompatibility()==s2.getCompatibility())
			{
				return 0;
			} 
			else if(s1.getCompatibility()> s2.getCompatibility())  
				return -1;  
			else  
			 return 1; 
		}
		else
			return 0;
	}
}
