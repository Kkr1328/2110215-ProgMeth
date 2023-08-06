package solar;

import java.util.ArrayList;

public class Application {
	private ArrayList<Planet> planets;

	public static String printPlanet(Planet planet) {
		if (planet instanceof Earth) {
			Earth earth = (Earth) planet;
			return "Earth's Waste Level is " + earth.getWasteLevel();
		} else if (planet instanceof Saturn) {
			Saturn saturn = (Saturn) planet;
			return "Saturn's Speed is " + saturn.getSpeed();
		} else {
			return "";
		}
	}

	public void main() {
		Earth earth = new Earth(1, 4);
		Saturn saturn = new Saturn(2, 2);
		planets.add(earth);
		planets.add(saturn);
		for (Planet planet : planets) {
			printPlanet(planet);
		}
	}

}
