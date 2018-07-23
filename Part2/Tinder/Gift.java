package Tinder;
/** 
 * Class to store the attributes of the gift
 * @author MANISH THAKUR
 *
 */
public abstract class Gift {
	private String gname;
    private int value;
    private int price;
    /**
     * Constructor for the Gift
     * @param s
     * @param v
     * @param p
     */
	public Gift(String s,int v,int p)
	{
		setGname(s);
		setValue(v);
		setPrice(p);

	}
	/**
	 * Method to get the price of the gift
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Method to set the price of the gift
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * Method to get the name of the gift
	 * @return
	 */
	public String getGname() {
		return gname;
	}
	/**
	 * Method to set the name of the gift
	 * @param gname
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}
	/**
	 * Method to get the value of the gift
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Method to store the value of gift
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
