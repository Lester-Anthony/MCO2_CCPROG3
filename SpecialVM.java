import java.util.ArrayList;

public class SpecialVM extends RegularVM{

    private ArrayList<ItemSlot> cart;
    
    public SpecialVM(String name) {
        super(name);
        cart = new ArrayList<ItemSlot>();
    }

    public ArrayList<ItemSlot> getCart() {
        return cart;
    }

    public void addToCart(ItemSlot itemSlot) {
        // adds one quantity of item to cart
        cart.add(new ItemSlot(itemSlot.getItemName(), itemSlot.getItems().get(0), itemSlot.getItemCost(), 1));

        // adds to total cost
        super.totalCost += itemSlot.getItemCost();
    }
}
