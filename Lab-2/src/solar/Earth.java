package solar;

public class Earth extends Planet {
	private int wasteLevel;

	public Earth() {
		this.wasteLevel = 0;
	}

	public Earth(int orbitRadius, int wasteLevel) {
		super(orbitRadius);
		if (wasteLevel < 0) {
			this.wasteLevel = 0;
		} else {
			this.wasteLevel = wasteLevel;
		}
	}

	public int getWasteLevel() {
		return wasteLevel;
	}

	public boolean orbit() {
		super.orbit();
		return wasteLevel <= 5;
	}
}
