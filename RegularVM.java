import java.util.*;

public class RegularVM {
    private String name;
    private ArrayList<ItemSlot> itemSlots;
    private ArrayList<Denomination> balance;
    private Transaction transactionHistory;

    protected float totalPayment = 0;
    protected float totalCost = 0;

    public RegularVM(String name) {
        itemSlots = new ArrayList<ItemSlot>();
        balance = new ArrayList<Denomination>();
        transactionHistory = new Transaction();
    }

    public String getName() {
        return name;
    }
    public ArrayList<ItemSlot> getItemSlots() {
        return itemSlots;
    }
    public ArrayList<Denomination> getBalance() {
        return balance;
    }
    public Transaction getTransactionHistory() {
        return transactionHistory;
    }
    public float getTotalPayment() {
        return totalPayment;
    }
    public float getTotalCost() {
        return totalCost;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(ArrayList<Denomination> balance) {
        this.balance = balance;
    }
    public void setTotalPayment(float totalPayment) {
        this.totalPayment = totalPayment;
    }
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void addItemSlot(Item item, float cost, int initQuantity) {
        itemSlots.add(new ItemSlot(item.getName(), item, cost, initQuantity));
    }
    public void addDenomination(Denomination denomination) {
        balance.add(denomination);
    }
    public void addPayment(Denomination denomination) {
        // add to totalPayment
        totalPayment += denomination.getValue();
    }
    public void buyItem(ItemSlot itemSlot, float payment) {
        // decrement itemSlot quantity by 1
        itemSlot.getItems().remove(itemSlot.getItems().size() - 1);

        // add to transactionHistory
        transactionHistory.addTransaction(itemSlot, payment);

        // add to totalPayment
        totalPayment += payment;

        // add to totalCost
        totalCost += itemSlot.getItemCost();
    }
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


}
