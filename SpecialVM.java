import java.util.ArrayList;

/**
 * The SpecialVM class represents a special vending machine, which is a subclass of RegularVM.
 * The special vending machine can handle a shopping cart, calculate cart total cost, and buy all items in the cart at once.
 */
public class SpecialVM extends RegularVM {

    protected static final ItemSlot[] getCart = null;   // A special constant for the shopping cart
    private ArrayList<ItemSlot> cart;                   // The list of items in the shopping cart
    float cartTotalCost;                                // The total cost of items in the shopping cart

    /**
     * Creates a new SpecialVM object with the given name and initializes its attributes.
     * The shopping cart is also initialized as an empty ArrayList.
     *
     * @param name The name of the special vending machine.
     */
    public SpecialVM(String name) {
        super(name);
        cart = new ArrayList<ItemSlot>();
    }

    /**
     * Get the list of items in the shopping cart.
     *
     * @return An ArrayList of ItemSlot objects representing the items in the shopping cart.
     */
    public ArrayList<ItemSlot> getCart() {
        return cart;
    }

    /**
     * Get the total cost of items in the shopping cart.
     *
     * @return The total cost of items in the shopping cart.
     */
    public float getCartTotalCost() {
        return cartTotalCost;
    }

    /**
     * Add an item to the shopping cart.
     * Use this method to add one quantity of an item to the cart and update the cart's total cost.
     *
     * @param itemSlot The item slot from which the item will be added to the cart.
     */
    public void addToCart(ItemSlot itemSlot) {
        // Adds one quantity of the item to the cart
        cart.add(new ItemSlot(itemSlot.getItemName(), itemSlot.getItems().get(0), itemSlot.getItemCost(), 1));

        // Updates the total cost of items in the cart
        super.totalCost += itemSlot.getItemCost();
    }

    /**
     * Buy all items in the shopping cart at once.
     * This method removes one quantity of each item in the cart from their respective item slots,
     * adds the transactions to the history, updates the cart total cost, payment, and the vending machine's total cost and payment.
     *
     * @param payment The payment made by the customer for the items in the cart.
     */
    public void buyCart(float payment) {
        // Iterates through all items in the cart
        for (ItemSlot itemSlot : cart) {
            // Decrement itemSlot quantity by 1
            itemSlot.getItems().remove(itemSlot.getItems().size() - 1);

            // Add the transaction to the transaction history
            transactionHistory.addTransaction(itemSlot, payment);

            // Update cart total cost, payment, and the vending machine's total cost and payment
            cartTotalCost += itemSlot.getItemCost();
            System.out.println(cartTotalCost);
            payment -= itemSlot.getItemCost();
            totalPayment += payment;
            totalCost += itemSlot.getItemCost();
        }
    }
}
