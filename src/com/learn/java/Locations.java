package com.learn.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
	/**
	 * Create a Location class with locationID and description as fields Every
	 * location should have at least 1 exit + "QUIT" exit
	 * 
	 * The main locations are: 
	 * - You are sitting in front of a computer learning Java 
	 * - You are standing at the end of a road before a small brick building 
	 * - You are at the top of a hill 
	 * - You are inside a building, a well house for a small spring 
	 * - You are in a valley beside a stream 
	 * - You are in the forest
	 * 
	 * You start the game at the location 1 => "You are standing at the end of a
	 * road before a small brick building" The player can exit the game if he reach
	 * the location 0 => "You are sitting in front of a computer learning Java"
	 *
	 * Try to output the locations and the exits of each location in .txt files (Exits.txt, Locations.txt)
	 * - Exits.txt ccontains the exits of each location
	 * - Locations.txt contains the locations of the game
	 * Open the Locations.txt and Exits.txt to check that the data has been written successfully
	 */
	
	// Fields
	private static Map<Integer, Location> locations = new HashMap<>();

	public static void main(String[] args) throws IOException {
		try (BufferedWriter locationsFile = new BufferedWriter(new FileWriter("Locations.txt"));
		     BufferedWriter exitsFile = new BufferedWriter(new FileWriter("Exits.txt"))) {
			for (Location location : locations.values()) {
				locationsFile.write(location.getLocationID() + ": " + location.getDescription() + "\n");
				for (String exit : location.getExits().keySet()) {
					exitsFile.write(location.getLocationID() + ":"
							+ " (Exit: " + exit + location.getExits().get(exit) + ")\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static {	
		// Locations
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));

		/**
		 * Exists N => NORTH S => SOUTH W => WEST E => EAST Q => QUIT
		 */
		// Location 1 exits
		locations.get(1).addExist("N", 5);
		locations.get(1).addExist("S", 4);
		locations.get(1).addExist("W", 2);
		locations.get(1).addExist("E", 3);

		// Location 2 exits
		locations.get(2).addExist("N", 5);

		// Location 3 exits
		locations.get(3).addExist("W", 1);

		// Location 4 exits
		locations.get(4).addExist("N", 1);
		locations.get(4).addExist("W", 2);

		// Location 5 exits
		locations.get(5).addExist("S", 1);
		locations.get(5).addExist("W", 2);
	}

	// Methods
	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clear() {
		locations.clear();
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}

}
