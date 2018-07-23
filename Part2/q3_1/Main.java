package q3_1;
import Tinder.*;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Main class for running the file
 * @author MANISH THAKUR
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		ioread a = new ioread();
		a.Boydata();
		a.Girdata();
		a.Giftdata();
		a.Boyscan();
		a.Girlscan();
		a.Giftscan();
		a.FormCouple();
		a.GiftAllocation();
		a.CalculateCompatibility();
		a.CalculateHappiness();
		a.DisplayHappy();
		a.DisplayCompatibility();
		a.giftDisplay();

	}

}
