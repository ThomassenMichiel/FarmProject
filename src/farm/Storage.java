package farm;

public class Storage {
    public static final float CAPACITY = 50_000f;

    private float currentCapacity;

    public Storage() {
        this.currentCapacity = 0;
    }

    public float getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(float currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public boolean canAddToStorage(float amountOfMilk) {
        return currentCapacity + amountOfMilk <= CAPACITY;
    }

    public void addToStorage(float amountOfMilk) {
        currentCapacity += amountOfMilk;
    }

    public void emptyStorage() {
        setCurrentCapacity(0);
    }

    public void decreaseStorage(float toDecrease) {
        setCurrentCapacity(currentCapacity - toDecrease);
    }
}
