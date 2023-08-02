import java.util.*;

public class ItemSlot {
    private String itemName;
    private ArrayList<Item> items;
    private float itemCost;
    private float itemCalories;

    public ItemSlot(String itemName, Item item, float itemCost, int initQuantity) {
        this.itemName = itemName;
        this.items = new ArrayList<Item>();
        this.itemCost = itemCost;
        this.itemCalories = item.getCalories();

        for(int i = 0; i < initQuantity; i++) {
            this.items.add(item);
        }
    }

    public String getItemName() {
        return itemName;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public float getItemCost() {
        return itemCost;
    }
    public float getItemCalories() {
        return itemCalories;
    }

    public void setItemPrice(float itemCost) {
        this.itemCost = itemCost;
    }
}
