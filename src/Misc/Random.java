package Misc;
import java.util.concurrent.ThreadLocalRandom;
public class Random {
    public static double random(double min, double max){
        double random = (int)ThreadLocalRandom.current().nextDouble(min, max + 1);



        return random;
    }
    public  static int Random(int min, int max){
        int random = (int)ThreadLocalRandom.current().nextDouble(min, max + 1);

        return random;
    }
}
