package Tinder;
/**
 * Class to store the attributes of the Choosy girl
 * @author MANISH THAKUR
 *
 */
public class Choosy extends Girl {
	/**
	 * Constructor for the Choosy
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 */
	public Choosy(String s,int a,int i,int b)
	{
		super(s,a,i,b);
	}
	@Override
	/**
	 * Method to Calculate the Happiness
	 */
	public double Happiness(Couple c) {
		
		// TODO Auto-generated method stub
		int ltotal = 0;
		int l;
		int size = c.getAl().size();
		int total = 0;
		double ghappy;
		for(l=0;l<size;l++)
		{
			total = total + c.getAl().get(l).getPrice();
		}
		for(l=0;l< size;l++)
		{
			if(c.getAl().get(l) instanceof Luxury)
			{
				ltotal = ltotal + c.getAl().get(l).getValue();
			}
		}
		ghappy = Math.log(Math.abs(total-c.getBndi().getMbudget() + 2*ltotal))%100;
		return ghappy;
		
	}

}
