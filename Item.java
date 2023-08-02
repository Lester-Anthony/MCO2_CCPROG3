public class Item {
    private String name;
    private float calories;
    private boolean isIndependent;
    private String process;

    public Item(String name, float calories, boolean isIndependent, String process) {
        this.name = name;
        this.calories = calories;
        this.isIndependent = isIndependent;
        this.process = process;
    }

    public String getName() {
        return name;
    }
    public float getCalories() {
        return calories;
    }
    public boolean getIsIndependent() {
        return isIndependent;
    }
    public String getProcess() {
        return process;
    }
}