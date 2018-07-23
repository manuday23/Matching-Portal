package Tinder;
/**
 * Class to store the attributes of the Normal Girl
 * @author MANISH THAKUR
 *
 */
public class Normal extends Girl {
	String type;
	/**
	 * Constructor for the Normal
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 */
	public Normal(String s,int a,int i,int b)
	{
		super(s,a,i,b);
	}
	@Override
	/**
	 * Method to calculate the happiness
	 */
	public double Happiness(Couple c) {
		// TODO Auto-generated method stub
		int l;
		int size = c.getAl().size();
		int total = 0;
		double ghappy;
		for(l=0;l<size;l++)
		{
			total = total + c.getAl().get(l).getPrice();
		}
		ghappy = Math.abs(total - c.getBndi().getMbudget())%100;
		return ghappy;
		
	}


}
