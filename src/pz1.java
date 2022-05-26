import java.math.BigInteger;
import java.util.Random;

public class pz1 {
    public static void main(String[] args) {
        int[] bits = {8,16,32,64,128,256,512,1024,2048,4096};
        for (int bit : bits) {
            KeysCount(bit);
            BigInteger a = GenerateRandom(bit);
            FindGenerated(a, bit);
        }
    }

    public static void KeysCount(int bits) {
        BigInteger res = new BigInteger("1",10);
        BigInteger count = new BigInteger(Integer.toString(bits));
        while(!count.equals(new BigInteger("0", 10))){
            res = res.multiply(new BigInteger("2",10));
            count = count.add(new BigInteger("-1", 10));
        }
        System.out.println("Кількість можливих ключей при " + bits + " бітах: " + res);
    }

    public static BigInteger GenerateRandom(int bits) {
        Random rnd = new Random();
        BigInteger generated = new BigInteger(bits/2, rnd);
//        для генерації відємних ключів
//        if(rnd.nextBoolean()) {
//            generated = generated.negate();
//        }

        System.out.println("Згенеравоне число в 10-річній системі: " + generated.toString(10));
        System.out.println("Згенероване число в 16-річній системі: " + generated.toString(16));
        return generated;
    }

    //Функція брутфорсу позитивних та неключей
    public static long FindGeneralGenerated(BigInteger generated, int bits) {
        long startTime = System.currentTimeMillis();
        BigInteger value = new BigInteger("0",16);
        while(value.bitLength() < bits){
            if(value.equals(generated)){
                long endTime = System.currentTimeMillis();
                return endTime - startTime;
            } else {
                value = value.add(new BigInteger("1", 10));
            }

        }
        value = new BigInteger("0",16);
        while(value.bitLength() < bits){
            if(value.equals(generated)){
                long endTime = System.currentTimeMillis();
                return endTime - startTime;
            } else {
                value = value.add(new BigInteger("-1", 10));
            }

        }
        System.out.println("Error");
        return 0;
    }
    //Функція брутфорсу позитивних ключей
    public static void FindGenerated(BigInteger generated, int bits) {
        long startTime = System.currentTimeMillis();
        BigInteger value = new BigInteger("0",16);
        while(value.bitLength() < bits){
            if(value.equals(generated)){
               long time = System.currentTimeMillis() - startTime;
                System.out.println("Згенерований ключ знайдено за " + time + " мілісекунд \n");
                return;
            } else {
                value = value.add(new BigInteger("1", 10));
            }

        }
        System.out.println("Error");
    }
}