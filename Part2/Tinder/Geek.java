package Tinder;
/**
 * Class to store the attributes of geek boy
 * @author MANISH THAKUR
 *
 */
public class Geek extends Boy {
	String type;
	/**
	 * constructor for the Geek
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 * @param cp
	 */
	public Geek(String s,int a,int i,int b,boolean cp)
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
		bhappy = c.getBndi().getIq();
		return bhappy;		
	}
	

	
}
