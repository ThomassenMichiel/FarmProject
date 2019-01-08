package farm;

public class Cost {

    public static final int COSTCOWLESSTHAN10 = 5;
    public static final int COSTSENIORCOW = 10;
    public static final int COSTNEWCOW = 3000;
    public static final int STORAGE = 1500;
    public static final int COSTBIRTHCOW = 300;

    public int dailyCowCost(Cow[] stable) {
        int dailyCost = 0;

        for (int i = 0; i < stable.length; i++) {
            if (stable[i].getAge() < 10) {
                dailyCost += COSTCOWLESSTHAN10;
            } else if (stable[i].getAge() >= 10) {
                dailyCost += COSTSENIORCOW;
            }

        }
        return dailyCost;
    }
}