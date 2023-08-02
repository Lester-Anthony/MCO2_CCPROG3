public class Denomination {
    private String name;
    private float value;
    private int quantity;

    public Denomination(String name, float value, int initQuantity) {
        this.name = name;
        this.value = value;
        quantity = initQuantity;
    }

    public String getName() {
        return name;
    }
    public float getValue() {
        return value;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
