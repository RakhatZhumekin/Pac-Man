import javafx.scene.layout.*;
import java.io.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class Map extends Pane { // The map where the game takes place
	
	private int unit = 30; // size of each cell
	private int size; // size of the map (size x size)
	private int[][] map; // the map, where the numbers are stored
	private Position start; // the starting position of the player

	public Map(String filename) { // Constructor
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename)); // Read from the file
			size = Integer.parseInt(br.readLine()); // The first line is the size

			map = new int[size][size];

			for (int row = 0; row < size; row++) {
				String line = br.readLine();
				String[] tokens = line.split(" "); // Put elements(which are separated by a space) separately into a new array
				for (int column = 0; column < size; column++) {
					map[row][column] = Integer.parseInt(tokens[column]); // parse 
				}
			}
		}
		catch(Exception e) { // Potential Exceptions need to be caught in catch block

		}

		for (int row = 0; row < size; row++) { // Traverse through the map to find which position contains 2
			for (int col = 0; col < size; col++) {
				if (getValue(row, col) == 2) // The player starting position is where 2 is
					start = new Position(col, row);
			}
		}

		draw(); // Draw the Map
	}	

	public int getUnit() { // Returns the unit
		return unit;
	}

	public int getSize() { // Returns the size
		return size;
	}

	public int getValue(int row, int column) { // Returns the value(either 0,1 or 2) in a specified coordinate
		return map[row][column];
	}

	public Position getStartPosition() { // Returns the starting position of the player
		return start;
	}

	private void draw() { // Helper method, to draw the map
		Rectangle cell; // new cell
		for (int row = 0; row < size; row++) { // Traverses through each coordinate and draws a cell there
			for (int col = 0; col < size; col++) {
				if (getValue(row, col) == 1) { // If it's a wall, we fill it with Black color
					cell = new Rectangle(col * unit, row * unit, unit, unit); // Initialize a new cell every time
					cell.setFill(Color.BLACK); 
					cell.setStroke(Color.BLACK);
					getChildren().add(cell); // add it to the map
				}
				else if (getValue(row, col) == 0 || getValue(row, col) == 2) { // If it's not a wall, we fill it with whie
					cell = new Rectangle(col * unit, row * unit, unit, unit);
					cell.setFill(Color.WHITE);
					cell.setStroke(Color.BLACK);
					getChildren().add(cell);
				}
			}
		}
	}
}