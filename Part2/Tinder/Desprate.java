package Tinder;
/**
 * Class to store the attributes  of the Desperate Girl
 * @author MANISH THAKUR
 *
 */
public class Desprate extends Girl{
	String tpye;
	/**
	 * Constructor for the Desperate Girl
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 */
	public Desprate(String s,int a,int i,int b)
	{
		super(s,a,i,b);
	}
	@Override
	/**
	 * Method to calculate the Happiness
	 */
	public double Happiness(Couple c) {
		int l;
		int size = c.getAl().size();
		int total = 0;
		double ghappy;
		for(l=0;l<size;l++)
		{
			total = total + c.getAl().get(l).getPrice();
		}
		ghappy = Math.exp(Math.abs(total - c.getBndi().getMbudget()))%100;
		return ghappy;
		
	}


}
