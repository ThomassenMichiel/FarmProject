import farm.Cow;
import farm.Farm;
import farm.Storage;

import java.util.Random;

import static farm.Constants.*;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.setStable(new Cow[INIT_COWS]);
        farm.setStorage(new Storage[INIT_TANKS]);

        for (int i = 0; i < farm.getStable().length; i++) {
            farm.getStable()[i] = new Cow();
        }

        farm.getStorage()[0] = new Storage();

        Random random = new Random();
        for (int i = 0; i < DURATION_IN_DAYS; i++) {
            for (int j = 0; j < MAX_AMOUNT_OF_PEOPLE; j++) {
                if(random.nextFloat() >= RANDOM_SALE_PROBABILITY) {
                    farm.randomSale();
                }
            }
            farm.milkCows();
            prettyPrintValues(farm,i);
        }
    }

    public static void prettyPrintValues(Farm farm, int i) {
        System.out.printf(
                "%5d || " +
                        "%8.2f || " +
                        "%3d || " +
                        "%8.2f" +
                        "%n",
                (i + 1),
                farm.getStorage()[farm.getCurrentStorage()].getCurrentCapacity(),
                (farm.getCurrentStorage() + 1),
                farm.getFunds()
        );
    }
}
