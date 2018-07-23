package Tinder;
import java.util.ArrayList;
public class Couple {
	int c_id;
	private Boy bnda;
	private Girl bndi;
	private double bhappy;
	private double ghappy;
	private double sum;
	private int compatibility;
	private ArrayList<Gift> al=new ArrayList<Gift>();
	public Couple(int id,Boy b,Girl g)
	{
		c_id = id;
		setBnda(b);
		setBndi(g);
	}
	public double getGhappy() {
		return ghappy;
	}
	public void setGhappy(double ghappy) {
		this.ghappy = ghappy;
	}
	public Girl getBndi() {
		return bndi;
	}
	public void setBndi(Girl bndi) {
		this.bndi = bndi;
	}
	public Boy getBnda() {
		return bnda;
	}
	public void setBnda(Boy bnda) {
		this.bnda = bnda;
	}
	public double getBhappy() {
		return bhappy;
	}
	public void setBhappy(double bhappy) {
		this.bhappy = bhappy;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getCompatibility() {
		return compatibility;
	}
	public void setCompatibility(int compatibility) {
		this.compatibility = compatibility;
	}
	public ArrayList<Gift> getAl() {
		return al;
	}
	public void setAl(ArrayList<Gift> al) {
		this.al = al;
	}
	
	

}
