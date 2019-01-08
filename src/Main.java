import farm.Cost;
import farm.Cow;
import farm.Farm;
import farm.Storage;

import java.text.DecimalFormat;
import java.util.Random;

import static farm.Constants.*;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.setStable(new Cow[INIT_COWS]);
        farm.setStorage(new Storage[INIT_TANKS]);
        farm.setCosts(new Cost());

        Random random = new Random();

        for (int i = 0; i < farm.getStable().length; i++) {
            Cow betsy = new Cow();
            betsy.setAge(random.nextInt(19) + 1);
            betsy.setGender(new Random().nextInt(10) > 8 ? "male" : "female");
            farm.getStable()[i] = betsy;
        }

        farm.getStorage()[0] = new Storage();

        for (int i = 0; i < DURATION_IN_DAYS; i++) {
            farm.milkCows();
            for (int j = 0; j < MAX_AMOUNT_OF_PEOPLE; j++) {
                if (random.nextFloat() >= RANDOM_SALE_PROBABILITY) {
                    farm.randomSale();
                }
            }
            if (i % 2 == 0) {
                farm.sellMilkWholeSale();
            }
            farm.generateCows();
            farm.setFunds(farm.getFunds() - farm.getCosts().dailyCowCost(farm.getStable()));
            prettyPrintValues(farm, i);
        }
    }

    public static void prettyPrintValues(Farm farm, int i) {
        int day = i + 1;
        if (day % 365 != 0) {
            return;
        }
        System.out.printf(
                "%5d || " +
                        "%8.2f || " +
                        "%3d || " +
                        "%8.2f" +
                        "%n",
                day,
                farm.getStorage()[farm.getCurrentStorage()].getCurrentCapacity(),
                (farm.getCurrentStorage() + 1),
                farm.getFunds()
        );
    }
}
