package Tinder;
/**
 * Class for storing the attributes of the Girl
 * @author MANISH THAKUR
 *
 */
public abstract class Girl {
	private String Name;
	private int atv;
	private int iq;
	private int Mbudget;
	private boolean coupled;
	/**
	 * constructor for the Girl
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 */
	public Girl(String s,int a,int i,int b)
	{
		setName(s);
		setIq(i);
		setAtv(a);
		setMbudget(b);
		setCoupled(false);
		
		
	}
	/**
	 * Abstract Method for calculating happiness
	 * @param c
	 * @return
	 */
	public abstract double Happiness(Couple c);
	/**
	 * Method to get the name of the girl
	 * @return
	 */
	public String getName() {
		return Name;
	}
	/**
	 * Method to set the value of the Name of the Girl
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * Method to get the value of  Girl's Budget
	 * @return
	 */
	public int getMbudget() {
		return Mbudget;
	}
	/**
	 * Method to set the value of Girl's Budget
	 * @param mbudget
	 */
	public void setMbudget(int mbudget) {
		Mbudget = mbudget;
	}
	/**
	 * Method to get the value of the girl's Attractiveness
	 * @return
	 */
	public int getAtv() {
		return atv;
	}
	/**
	 * Method to set the value of the Girl's Attractiveness
	 * @param atv
	 */
	public void setAtv(int atv) {
		this.atv = atv;
	}
	/**
	 * Method to get the value of the girl's IQ
	 * @return
	 */
	public int getIq() {
		return iq;
	}
	/**
	 * Method to set the value of the girl's IQ
	 * @param iq
	 */
	public void setIq(int iq) {
		this.iq = iq;
	}
	/**
	 * Method to check wether the girl is committed or not
	 * @return
	 */
	public boolean isCoupled() {
		return coupled;
	}
/**
 * to set the commitment of the girl  
 * @param coupled
 */
	public void setCoupled(boolean coupled) {
		this.coupled = coupled;
	}


}
