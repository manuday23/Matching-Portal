package Tinder;
import java.sql.Timestamp;
/**
 * Class to store the attributes of Miser boy
 * @author MANISH THAKUR
 *
 */
public class Miser extends Boy  {
	String type;
	/**
	 * constructor for Miser Boy
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 * @param cp
	 */
	public Miser(String s,int a,int i,int b,boolean cp)
	{
		super(s, a, i, b, cp);
		
		
	}
	@Override
	/**
	 * Function to calculate the HAppiness
	 */
	public double Happiness(Couple c) {	
		// TODO Auto-generated method stub
		int l;
		int size = c.getAl().size();
		int total = 0;
		double bhappy;
		for(l=0;l<size;l++)
		{
			total = total + c.getAl().get(l).getPrice();
		}
		bhappy = Math.abs(c.getBnda().getBudget() - total)%100;
		return bhappy;

		
	}
	
	
	

}
