package solar;

public class Planet {
	protected Coordinate coordinate;
	protected Coordinate orbitCenterCoordinate;
	protected int orbitRadius;

	public Planet() {
		this.coordinate = new Coordinate(1, 0);
		this.orbitCenterCoordinate = new Coordinate(0, 0);
		this.orbitRadius = 1;
	}

	public Planet(int orbitRadius) {
		if (orbitRadius < 1) {
			this.orbitRadius = 1;
		} else {
			this.orbitRadius = orbitRadius;
		}
		this.coordinate = new Coordinate(this.orbitRadius, 0);
		this.orbitCenterCoordinate = new Coordinate(0, 0);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Coordinate getOrbitCenterCoordinate() {
		return orbitCenterCoordinate;
	}

	public int getOrbitRadius() {
		return orbitRadius;
	}

	public boolean orbit() {
		if (orbitCenterCoordinate.getX() - orbitRadius == coordinate.getX()
				&& orbitCenterCoordinate.getY() == coordinate.getY()) {
			coordinate.setX(orbitCenterCoordinate.getX());
			coordinate.setY(orbitCenterCoordinate.getY() + orbitRadius);
			return true;
		} else if (orbitCenterCoordinate.getX() + orbitRadius == coordinate.getX()
				&& orbitCenterCoordinate.getY() == coordinate.getY()) {
			coordinate.setX(orbitCenterCoordinate.getX());
			coordinate.setY(orbitCenterCoordinate.getY() - orbitRadius);
			return true;
		} else if (orbitCenterCoordinate.getY() - orbitRadius == coordinate.getY()
				&& orbitCenterCoordinate.getX() == coordinate.getX()) {
			coordinate.setY(orbitCenterCoordinate.getY());
			coordinate.setX(orbitCenterCoordinate.getX() - orbitRadius);
			return true;
		} else if (orbitCenterCoordinate.getY() + orbitRadius == coordinate.getY()
				&& orbitCenterCoordinate.getX() == coordinate.getX()) {
			coordinate.setY(orbitCenterCoordinate.getY());
			coordinate.setX(orbitCenterCoordinate.getX() + orbitRadius);
			return true;
		} else {
			return false;
		}
	}
}
