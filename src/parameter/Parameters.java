package parameter;

import java.util.Random;

public class Parameters {
	protected String URL = "https://magento.softwaretestingboard.com/";

	protected String[] randoomFirstName = { "mohammad", "ahmad", "yousef", "Esaa", "rama" };

	protected String[] randoomLastName = { "mahmoud", "yazan", "basell", "kallel", "omran" };

	Random rand = new Random();

	protected int randomNumber = rand.nextInt(20);

	protected int randFName = rand.nextInt(randoomFirstName.length);
	protected int randLName = rand.nextInt(randoomLastName.length);

}
