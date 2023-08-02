/**
 * The Item class represents an item with its attributes.
 */
public class Item {
    private String name;          // The name of the item
    private float calories;       // The number of calories in the item
    private boolean isIndependent;// Indicates if the item is independent or not
    private String process;       // The process description of the item

    /**
     * Creates a new Item object with the given parameters.
     *
     * @param name The name of the item.
     * @param calories The number of calories in the item.
     * @param isIndependent A flag indicating if the item is independent or not.
     * @param process The process description of the item.
     */
    public Item(String name, float calories, boolean isIndependent, String process) {
        this.name = name;
        this.calories = calories;
        this.isIndependent = isIndependent;
        this.process = process;
    }

    /**
     * Get the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the number of calories in the item.
     *
     * @return The number of calories in the item.
     */
    public float getCalories() {
        return calories;
    }

    /**
     * Check if the item is independent.
     *
     * @return True if the item is independent, False otherwise.
     */
    public boolean getIsIndependent() {
        return isIndependent;
    }

    /**
     * Get the process description of the item.
     *
     * @return The process description of the item.
     */
    public String getProcess() {
        return process;
    }
}
