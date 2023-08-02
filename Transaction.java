import java.util.*;

public class Transaction {
    private ArrayList<ItemSlot> itemsSold;
    private float totalCost;
    private float totalCalories;
    private float totalPayment;
    private float totalChange;

    public Transaction() {
        itemsSold = new ArrayList<>();
    }

    public void addTransaction(ItemSlot itemSlot, float payment) {
        itemsSold.add(itemSlot);

        totalCost += itemSlot.getItemCost();
        totalCalories += itemSlot.getItemCalories();
        totalPayment += payment;
        totalChange += payment - itemSlot.getItemCost();
    }

    public ArrayList<ItemSlot> getItemsSold() {
        return itemsSold;
    }
    public float getTotalCost() {
        return totalCost;
    }
    public float getTotalCalories() {
        return totalCalories;
    }
    public float getTotalPayment() {
        return totalPayment;
    }
    public float getTotalChange() {
        return totalChange;
    }
}
