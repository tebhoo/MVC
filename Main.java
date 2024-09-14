import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cow[] cows = new Cow[100];
        Random random = new Random();
        int preferredNumber;

        for (int i = 0; i < cows.length; i++) {
            if (random.nextDouble() < 0.95) {
                // 95% chance of being female with 4 udders
                preferredNumber = random.nextInt(10);
                cows[i] = new Cow('f', 4, preferredNumber);
            } else {
                // 5% chance of random gender and random udder count (not equal to 4)
                char gender = random.nextBoolean() ? 'f' : 'm';
                int udders;
                do {
                    udders = random.nextInt(3, 5); // Random udders between 3 and 4
                } while (udders == 4); // Ensure udders != 4
                preferredNumber = random.nextInt(10);
                cows[i] = new Cow(gender, udders, preferredNumber);
            }
        }

        new Controller(cows);
        
    }
    
}