public class Position { // A Position of a point/object
	private int x; // x coordinate 
	private int y; // y coordinate

	public Position(int x, int y) { // constructor with arguments
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x; // returns the x coordinate
	}

	public int getY() {
		return y; // returns the y coordinate
	}

	public void setX(int x) {
		this.x = x; // sets the x coordinate
	}

	public void setY(int y) {
		this.y = y; // sets the y coordinate
	}

	public boolean equals(Position o) { 
		if (getX() == o.getX() && getY() == o.getY()) // Check if two Positions are the same
			return true;
		
		return false;
	}
}