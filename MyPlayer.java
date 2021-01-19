import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class MyPlayer implements Player { // The player which we control
	
	private Circle ball; // the player 
	private Map map; // the map where the player is located
	private Position position; // position of the player

	public MyPlayer(Map map) { // Constructor
		this.map = map;
		position = map.getStartPosition();
		double x = (position.getX() * map.getUnit()) + (map.getUnit() / 2); // set the center x coordinate of the player
		double y = (position.getY() * map.getUnit()) + (map.getUnit() / 2); // set the center y coordinate of the player
		ball = new Circle(x , y, 13, Color.RED); // create the player
		map.getChildren().add(ball); // add the player to the map
	}

	@Override
	public void moveRight() {
		if (position.getX() + 1 < map.getSize() && // checks if moving the player to the right won't push it out of the border
				map.getValue(position.getY(), position.getX() + 1) != 1){ // and if it won't push it to a wall
			ball.setCenterX(ball.getCenterX() + map.getUnit()); // moves the ball to the right
			position.setX(position.getX() + 1);		// increment the x coordinate
		}
		else
			System.out.println("Invalid position!"); // if moving the player to the right will either push it out of the border or to a wall
	}

	@Override
	public void moveLeft() {
		if (position.getX() - 1 >= 0 && // checks if moving the player to the left won't push it out of the border
				map.getValue(position.getY(), position.getX() - 1) != 1) { // and if it won't push it to a wall
			ball.setCenterX(ball.getCenterX() - map.getUnit()); // moves the ball to the left
			position.setX(position.getX() - 1); // decrement the x coordinate
		}	
		else
			System.out.println("Invalid position!"); // if moving the player to the left will either push it out of the border or to a wall
	}

	@Override	
	public void moveUp() { 
		if (position.getY() - 1 >= 0 && // checks if moving the player up won't push it out of the border
				map.getValue(position.getY() - 1, position.getX()) != 1) { // and if it won't push it to a wall
			ball.setCenterY(ball.getCenterY() - map.getUnit()); // moves the ball up
			position.setY(position.getY() - 1); // decrement the y coordinate
		}
		else
			System.out.println("Invalid position!"); // if moving the player to the up will either push it out of the border or to a wall
	}

	@Override
	public void moveDown() {
		if (position.getY() + 1 < map.getSize() &&  // checks if moving the player down won't push it out of the border
				map.getValue(position.getY() + 1, position.getX()) != 1) { // and if it won't push it to a wall
			ball.setCenterY(ball.getCenterY() + map.getUnit()); // moves the ball down
			position.setY(position.getY() + 1); // increment the y coordinate
		}
		else
			System.out.println("Invalid position!"); // if moving the player down will either push it out of the border or to a wall
	}

	@Override
	public Position getPosition() { // returns the position of the player
		return position;
	}
}