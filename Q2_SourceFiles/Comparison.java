import java.util.*;
public class Comparison implements Comparator  {
	public int compare(Object o1,Object o2){  
		Gift s1=(Gift)o1;  
		Gift s2=(Gift)o2;  
		if(s1 != null && s2 !=null)
		{
			if(s1.price==s2.price)
			{
				if(s1.value > s2.value)
					return 1;
				else return 0;
			} 
			else if(s1.price > s2.price)  
				return 1;  
			else  
			 return -1;  
			}  
		
		else
			return 0;
	}

}
