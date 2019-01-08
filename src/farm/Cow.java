package farm;

import java.util.Random;

public class Cow {
    public static final float PRODUCTION = 22.71f;

    private String gender;
    private int age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static boolean canGetKalf() {
        Random rand = new Random();
        int kalf = rand.nextInt ( 4 );
        /*if(kalf == 0){
            return true;

        }
        return false;*/
        return kalf == 0;
    }
}
