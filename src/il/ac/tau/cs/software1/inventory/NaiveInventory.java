package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	// TODO: add the fields:
	private Collectible[] items = new Collectible[INITIAL_CAPACITY];
	private int stored = 0;

	public NaiveInventory() {
	}

	@Override
	public void collect(Collectible collectible) {
		
		if (stored >= items.length){
			Collectible[] newItems = new Collectible[2 * items.length];
			for (int i = 0; i < items.length; i ++){
				newItems[i] = items[i];
			}
			items = newItems;

		}
		items[stored] = collectible;
		stored++;
	}

	@Override
	public float getTotalWeight() {
		float total = 0;
		for (int i = 0; i < stored; i++){
			total = total + items[i].getWeight();
		}
		return total;
	}

	@Override
	public int getCurrentCount() {
		// TODO: implement
		return stored;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return items;
	}
}
