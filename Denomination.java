/**
 * The Denomination class represents a money denomination with its attributes.
 * It contains the name, value, and quantity of the denomination.
 */
public class Denomination {
    private String name;     // The name of the denomination (e.g., PHP 10, PHP 20, etc.)
    private float value;     // The monetary value of the denomination
    private int quantity;    // The quantity of this denomination

    /**
     * Creates a new Denomination object with the given parameters.
     *
     * @param name The name of the denomination (e.g., $10, $20, etc.).
     * @param value The monetary value of the denomination.
     * @param initQuantity The initial quantity of this denomination.
     */
    public Denomination(String name, float value, int initQuantity) {
        this.name = name;
        this.value = value;
        this.quantity = initQuantity;
    }

    /**
     * Get the name of the denomination.
     *
     * @return The name of the denomination.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the monetary value of the denomination.
     *
     * @return The monetary value of the denomination.
     */
    public float getValue() {
        return value;
    }

    /**
     * Get the quantity of this denomination.
     *
     * @return The quantity of this denomination.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of this denomination.
     * Use this method to update the quantity of the denomination.
     *
     * @param quantity The new quantity to be set for this denomination.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}