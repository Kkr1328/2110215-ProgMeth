package solar;

public class Saturn extends Planet {
	private int speed;

	public Saturn() {
		this.speed = 0;
	}

	public Saturn(int orbitRadius, int speed) {
		super(orbitRadius);
		if (speed < 0) {
			this.speed = 0;
		} else {
			this.speed = speed;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public boolean orbit() {
		for (int i = 0; i < speed; i++) {
			super.orbit();
		}
		return speed > 0;
	}
}
