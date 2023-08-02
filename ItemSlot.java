import java.util.*;

/**
 * The ItemSlot class represents a slot containing items with their attributes.
 * It holds the name of the item slot, the item object, a list of items, the cost of the item, and its total calories.
 */
public class ItemSlot {
    private String itemName;        // The name of the item slot
    private Item item;              // The item object representing the item in the slot
    private ArrayList<Item> items;  // A list of items in this slot
    private float itemCost;         // The cost of the item in the slot
    private float itemCalories;     // The total calories of the item in the slot

    /**
     * Creates a new ItemSlot object with the given parameters.
     * Initializes the item slot with a specific item and quantity.
     *
     * @param itemName The name of the item slot.
     * @param item The item object representing the item in the slot.
     * @param itemCost The cost of the item in the slot.
     * @param initQuantity The initial quantity of items to be added to the slot.
     */
    public ItemSlot(String itemName, Item item, float itemCost, int initQuantity) {
        this.itemName = itemName;
        this.item = item;
        this.items = new ArrayList<Item>();
        this.itemCost = itemCost;
        this.itemCalories = item.getCalories();

        // Add the initial quantity of items to the slot
        for (int i = 0; i < initQuantity; i++) {
            this.items.add(item);
        }
    }

    /**
     * Get the name of the item slot.
     *
     * @return The name of the item slot.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Get the item object representing the item in the slot.
     *
     * @return The item object representing the item in the slot.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Get the list of items in the slot.
     *
     * @return The list of items in the slot.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Get the cost of the item in the slot.
     *
     * @return The cost of the item in the slot.
     */
    public float getItemCost() {
        return itemCost;
    }

    /**
     * Get the total calories of the item in the slot.
     *
     * @return The total calories of the item in the slot.
     */
    public float getItemCalories() {
        return itemCalories;
    }

    /**
     * Set the cost of the item in the slot.
     * Use this method to update the cost of the item in the slot.
     *
     * @param itemCost The new cost to be set for the item in the slot.
     */
    public void setItemPrice(float itemCost) {
        this.itemCost = itemCost;
    }
}
