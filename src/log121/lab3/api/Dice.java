package log121.lab3.api;

public class Dice implements Comparable<Dice> {

	private static final int MAX_VALUE = 6;
	private static final int MIN_VALUE = 1;

	/**
	 * Size of the dice
	 */
	private int size;

	/**
	 * Current value of the dice
	 */
	private int value;

	/**
	 * Create a new dice with a specified dice size
	 * 
	 * @param size
	 */
	public Dice(int size) {
		this.size = size;
		roll();
	}

	/**
	 * Create a new 6 faced dice
	 */
	public Dice() {
		this(MAX_VALUE);
	}

	/**
	 * Roll the dice (generate a random value within the boundries)
	 * 
	 * @see getValue()
	 */
	public void roll() {
		this.value = MIN_VALUE
				+ (int) (Math.random() * ((size - MIN_VALUE) + 1));
	}

	/**
	 * Get the current dice value
	 * 
	 * @return dice value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Set the current dice value
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Compare two dice values
	 */
	@Override
	public int compareTo(Dice other) {
		
		if(other == null)
			throw new IllegalArgumentException();

		if(other.value > value)
			return 1;
		else if(other.value < value)
			return -1;
		return 0;
	}

}
