package Tinder;
import java.util.*;
/**
 * Class for storing attributes of boy
 */
import java.io.*;
public abstract class Boy {
	private String Name;
	private int Atv;
	private int intelligence;
    private boolean coupled;
	
	private int budget;
	/**
	 * Boy class constructor
	 * @param s
	 * @param a
	 * @param i
	 * @param b
	 * @param cp
	 */
	public Boy(String s,int a,int i,int b,boolean cp)
	{
		setName(s);
		setIntelligence(i);
		setAtv(a);
		setBudget(b);
		setCoupled(cp);
		
		
	}
	/**
	 * Method to calculate happiness
	 * @param c
	 * @return
	 */
	public abstract double Happiness(Couple c);
	/**
	 * function to get the name of boy
	 * @return
	 */
	public String getName() {
		return Name;
	}
	/**
	 * function to set the value of boy name
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}
/**
 * function to check weather a boy is having girl friend or not
 * @return
 */
	public boolean isCoupled() {
		return coupled;
	}
/**
 * function to set the couple variable
 * @param coupled
 */
	public void setCoupled(boolean coupled) {
		this.coupled = coupled;
	}
/**
 * method to get the value of boy's budget
 * @return
 */
	public int getBudget() {
		return budget;
	}
/**
 * method to set the budget of the boy
 * @param budget
 */
	public void setBudget(int budget) {
		this.budget = budget;
	}
/**
 * Method to get the value of intelligence of the boy
 * @return
 */
	public int getIntelligence() {
		return intelligence;
	}
/**
 *  Method to set the value of intelligence of the boy

 * @param intelligence
 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
/**
 *  Method to get the value of Attractiveness of the boy

 * @return
 */
	public int getAtv() {
		return Atv;
	}
/**
 * Method to set the value of Attractiveness of the boy
 * @param atv
 */
	public void setAtv(int atv) {
		Atv = atv;
	}

	

}
