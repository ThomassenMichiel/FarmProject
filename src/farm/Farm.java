package farm;

import java.util.Random;

import static farm.Constants.MILK_PRICE_100_LITER;
import static farm.Constants.MILK_PRICE_1_LITER;

public class Farm {
    private Cow[] stable;
    private Storage[] storage;
    private int currentStorage;
    private float funds;
    private Cost costs;

    public Farm() {
        this(null, null);
    }

    public Farm(Cow[] stable, Storage[] storage) {
        this.stable = stable;
        this.storage = storage;
        this.currentStorage = 0;
    }

    public Cow[] getStable() {
        return stable;
    }

    public void setStable(Cow[] stable) {
        this.stable = stable;
    }

    public Storage[] getStorage() {
        return storage;
    }

    public void setStorage(Storage[] storage) {
        this.storage = storage;
    }

    public int getCurrentStorage() {
        return currentStorage;
    }

    public void setCurrentStorage(int currentStorage) {
        this.currentStorage = currentStorage;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public Cost getCosts() {
        return costs;
    }

    public void setCosts(Cost costs) {
        this.costs = costs;
    }

    public void milkCows() {
        for (int i = 0; i < stable.length; i++) {
            /*
            niet zo een schone code
            if(storage[currentStorage].canAddToStorage(Cow.PRODUCTION)) {
                storage[currentStorage].addToStorage(Cow.PRODUCTION);
            } else {
                addNewStorage();
                storage[currentStorage++].addToStorage(Cow.PRODUCTION);
            }*/

            if (!storage[currentStorage].canAddToStorage(Cow.PRODUCTION)) {
                addNewStorage();
                sellMilkWholeSale();
                currentStorage++;
            }
            storage[currentStorage].addToStorage(Cow.PRODUCTION);

        }
    }

    public void addNewStorage() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count++;
            }
        }
        storage[count] = new Storage();
    }

    public void sellMilkWholeSale() {
        Storage storage = getStorage()[getCurrentStorage()];
        funds += storage.getCurrentCapacity() / 100 * MILK_PRICE_100_LITER;
        storage.emptyStorage();
    }

    public void randomSale() {
        Random random = new Random();
        float toBuy = random.nextFloat() * 12;
        if (getStorage()[getCurrentStorage()].getCurrentCapacity() >= toBuy) {
            getStorage()[getCurrentStorage()].decreaseStorage(toBuy);
            this.setFunds(getFunds() + toBuy * MILK_PRICE_1_LITER);
        }
    }

    public void generateCows() {
        for (int i = 0; i < stable.length; i++) {
            if (stable[i].getGender().equals("female")) {
                if (Cow.canGetKalf()) {
                    int oldestPosition = 0;
                    int oldestAge = 0;
                    for (int j = 0; j < stable.length; j++) {
                        if (stable[j].getAge() > oldestAge) {
                            oldestAge = stable[j].getAge();
                            oldestPosition = j;
                        }
                    }
                    Cow betsy = new Cow();
                    betsy.setAge(0);
                    betsy.setGender(new Random().nextInt(10) > 8 ? "male" : "female");
                    stable[oldestPosition] = betsy;
                }
            }
        }
    }


}
