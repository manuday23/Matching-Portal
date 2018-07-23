package Tinder;
/**
 * Class to store the attributes of Generous boy
 * @author MANISH THAKUR
 *
 */
public class Generous extends Boy {
	/**
	 * constructor for the Generous
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 * @param cp
	 */
	public Generous(String s,int a,int i,int b,boolean cp)
	{
		super(s, a, i, b, cp);
		
		
	}
	@Override
	/**
	 * Method to calculate Happiness
	 */
	public double Happiness(Couple c) {
		// TODO Auto-generated method stub
		double bhappy;
		bhappy = c.getGhappy();
		return bhappy;
		
	}
	
	

}
