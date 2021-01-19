import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import java.io.*;

public class Game extends Application { // The Game, where everything takes place
	private Map map; // The map of the game
	private Player player; // The player
	private Food food; // The food

	@Override
	public void start(Stage primaryStage) {
		String filename = getParameters().getUnnamed().get(0); // To read from the command line
		map = new Map(filename); // Initialize the map
		player = new MyPlayer(map); // Initialize the player
		food = new Food(map, player); // Initialize the food
		System.out.println(map.getSize()); // Prints the size
		Scene scene = new Scene(map, 500, 500); // Create a scene
		primaryStage.setTitle("Eater"); // Set the name
		primaryStage.setScene(scene); // Set the scene
		primaryStage.show(); // Display
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
				case UP: player.moveUp(); break; // If the UP key is pressed, move the player up
				case DOWN: player.moveDown(); break; // If the DOWN key is pressed, move the player down
				case RIGHT: player.moveRight(); break; // If the RIGHT key is pressed, move the player to the right
				case LEFT: player.moveLeft(); break; // If the LEFT key is pressed, move the player to the left
			}
		});
	}
}