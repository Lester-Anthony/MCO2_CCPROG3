import java.util.*;

/**
 * The RegularVMModel class represents a regular vending machine with its attributes and functionalities.
 * It contains item slots, denominations for balance, transaction history, and methods to manage the machine's operation.
 */
public class RegularVMModel {
    private String name;                             // The name of the vending machine
    private ArrayList<ItemSlot> itemSlots;           // A list of item slots in the vending machine
    static private ArrayList<Denomination> balance;  // The balance of the vending machine in different denominations
    protected Transaction transactionHistory;        // The transaction history of the vending machine
    protected float totalPayment = 0;                // The total payment received by the vending machine
    protected float totalCost = 0;                   // The total cost of items sold by the vending machine

    /**
     * Creates a new RegularVMModel object with the given name and initializes its attributes.
     * The vending machine is set up with default denominations and quantities.
     *
     * @param name The name of the vending machine.
     */
    public RegularVMModel(String name) {
        itemSlots = new ArrayList<ItemSlot>();
        balance = new ArrayList<Denomination>();
        transactionHistory = new Transaction();

        int denominations[] = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        // Initialize the vending machine with default denominations and quantities
        for (int denomination : denominations) {
            this.addDenomination(new Denomination("PHP " + denomination, denomination, 100));
        }
    }

    /**
     * Get the name of the vending machine.
     *
     * @return The name of the vending machine.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the list of item slots in the vending machine.
     *
     * @return An ArrayList of ItemSlot objects representing the item slots in the vending machine.
     */
    public ArrayList<ItemSlot> getItemSlots() {
        return itemSlots;
    }

    /**
     * Get the balance of the vending machine in different denominations.
     *
     * @return An ArrayList of Denomination objects representing the balance of the vending machine.
     */
    public ArrayList<Denomination> getBalance() {
        return balance;
    }

    /**
     * Get the transaction history of the vending machine.
     *
     * @return The Transaction object representing the transaction history of the vending machine.
     */
    public Transaction getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Get the total payment received by the vending machine.
     *
     * @return The total payment received by the vending machine.
     */
    public float getTotalPayment() {
        return totalPayment;
    }

    /**
     * Get the total cost of items sold by the vending machine.
     *
     * @return The total cost of items sold by the vending machine.
     */
    public float getTotalCost() {
        return totalCost;
    }

    /**
     * Set the name of the vending machine.
     * Use this method to update or change the name of the vending machine.
     *
     * @param name The new name to be set for the vending machine.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the balance of the vending machine in different denominations.
     * Use this method to update the balance of the vending machine.
     *
     * @param balance An ArrayList of Denomination objects representing the new balance to be set for the vending machine.
     */
    public void setBalance(ArrayList<Denomination> balance) {
        this.balance = balance;
    }

    /**
     * Set the total payment received by the vending machine.
     * Use this method to update the total payment received by the vending machine.
     *
     * @param totalPayment The new total payment to be set for the vending machine.
     */
    public void setTotalPayment(float totalPayment) {
        this.totalPayment = totalPayment;
    }

    /**
     * Set the total cost of items sold by the vending machine.
     * Use this method to update the total cost of items sold by the vending machine.
     *
     * @param totalCost The new total cost to be set for the vending machine.
     */
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Adds a new item slot to the vending machine with the given item, cost, and initial quantity.
     *
     * @param item The item object to be added to the item slot.
     * @param cost The cost of the item in the slot.
     * @param initQuantity The initial quantity of items to be added to the item slot.
     */
    public void addItemSlot(Item item, float cost, int initQuantity) {
        itemSlots.add(new ItemSlot(item.getName(), item, cost, initQuantity));
    }

    /**
     * Adds a new denomination to the vending machine's balance.
     *
     * @param denomination The denomination object to be added to the balance.
     */
    public void addDenomination(Denomination denomination) {
        balance.add(denomination);
    }

    /**
     * Adds a payment to the total payment received by the vending machine.
     * Used when a customer adds money to the vending machine.
     *
     * @param denomination The denomination object representing the payment to be added.
     */
    public void addPayment(Denomination denomination) {
        totalPayment += denomination.getValue();
    }

    /**
     * Processes a purchase of an item from the vending machine.
     * Decreases the item slot quantity, adds the transaction to the history, and updates total payment and cost.
     *
     * @param itemSlot The item slot from which the item is purchased.
     * @param payment The payment made by the customer for the item.
     */
    public void buyItem(ItemSlot itemSlot, float payment) {
        // Decrement itemSlot quantity by 1
        itemSlot.getItems().remove(itemSlot.getItems().size() - 1);

        // Add the transaction to the transaction history
        transactionHistory.addTransaction(itemSlot, payment);

        // Update total payment and total cost
        totalPayment += payment;
        totalCost += itemSlot.getItemCost();
    }

    /**
     * Produces change for a given payment and cost by using the available denominations in the vending machine.
     *
     * @param payment The payment made by the customer.
     * @param cost The cost of the item being purchased.
     * @return An ArrayList of denominations representing the change to be given to the customer.
     */
    public ArrayList<Denomination> produceChange(float payment, float cost) {

        ArrayList<Denomination> changeList = new ArrayList<Denomination>();
        float totalChange = payment - cost;
        int i = 0;

        // adds each type of denomination in balance to changeList with quantity 0
        for(Denomination denomination : balance) {
            changeList.add(new Denomination(denomination.getName(), denomination.getValue(), 0));
        }


        for(Denomination denomination : balance) {
            if(denomination.getQuantity() > 0) {
                while(denomination.getValue() <= totalChange) {
                    // Decrements balance denomination quantity by 1
                    denomination.setQuantity(denomination.getQuantity() - 1);

                    // Increments changeList denomination quantity by 1
                    changeList.get(i).setQuantity(changeList.get(i).getQuantity() + 1);

                    // Reduces totalChange by denomination value
                    totalChange -= denomination.getValue();
                }
            }
            i++;
        }

        return changeList;
    }

    /**
     * Adds more quantity of an item to its respective item slot in the vending machine's stock.
     *
     * @param itemSlot The item slot to which more quantity will be added.
     * @param quantity The quantity of items to be added to the stock.
     */
    public void stockItem(ItemSlot itemSlot, int quantity) {
        for(int i = 0; i < quantity; i++)
            itemSlot.getItems().add(itemSlot.getItem());
    }

    /**
     * Sets the price of an item slot in the vending machine.
     *
     * @param itemSlot The item slot for which the price will be updated.
     * @param price The new price to be set for the item slot.
     */
    public void setItemSlotPrice(ItemSlot itemSlot, float price) {
        itemSlot.setItemPrice(price);
    }
}
