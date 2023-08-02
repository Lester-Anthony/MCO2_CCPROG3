import java.util.*;

/**
 * The Transaction class represents a transaction in a vending machine.
 * It keeps track of the items sold, total cost, total calories, total payment, and total change of the transaction.
 */
public class Transaction {
    private ArrayList<ItemSlot> itemsSold; // The list of item slots representing the items sold in the transaction
    private float totalCost;              // The total cost of all items sold in the transaction
    private float totalCalories;          // The total calories of all items sold in the transaction
    private float totalPayment;           // The total payment received for the items in the transaction
    private float totalChange;            // The total change given to the customer in the transaction

    /**
     * Creates a new Transaction object and initializes its attributes.
     */
    public Transaction() {
        itemsSold = new ArrayList<>();
    }

    /**
     * Add a new item slot to the transaction and update the transaction's attributes based on the added item.
     * This method is used to record the sale of an item in the transaction.
     *
     * @param itemSlot The item slot representing the item sold in the transaction.
     * @param payment The payment made by the customer for the item.
     */
    public void addTransaction(ItemSlot itemSlot, float payment) {
        itemsSold.add(itemSlot);

        // Update the total cost, total calories, total payment, and total change of the transaction
        totalCost += itemSlot.getItemCost();
        totalCalories += itemSlot.getItemCalories();
        totalPayment += payment;
        totalChange += payment - itemSlot.getItemCost();
    }

    /**
     * Get the list of item slots representing the items sold in the transaction.
     *
     * @return An ArrayList of ItemSlot objects representing the items sold in the transaction.
     */
    public ArrayList<ItemSlot> getItemsSold() {
        return itemsSold;
    }

    /**
     * Get the total cost of all items sold in the transaction.
     *
     * @return The total cost of all items sold in the transaction.
     */
    public float getTotalCost() {
        return totalCost;
    }

    /**
     * Get the total calories of all items sold in the transaction.
     *
     * @return The total calories of all items sold in the transaction.
     */
    public float getTotalCalories() {
        return totalCalories;
    }

    /**
     * Get the total payment received for the items in the transaction.
     *
     * @return The total payment received for the items in the transaction.
     */
    public float getTotalPayment() {
        return totalPayment;
    }

    /**
     * Get the total change given to the customer in the transaction.
     *
     * @return The total change given to the customer in the transaction.
     */
    public float getTotalChange() {
        return totalChange;
    }
}
