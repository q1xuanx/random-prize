package org.example;

import java.util.*;

public class Main {
    private enum prize{
        FirstPrize, SecondPrize, ThirdPrize, FourthPrize, FifthPrize, SixthPrize, SeventhPrize, EighthPrize
    };
    public static void main(String[] args) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 1; i <= 10000; i++){
            String key = prizeGet(randomPercent());
            if (!count.containsKey(key)) {
                count.put(key, 1);
            }else {
                count.put(key, count.get(key) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static String prizeGet(int percent) {
        //System.out.println(percent + "%");
        if (percent < 25) {
            return prize.EighthPrize.name();
        } else if (percent < 85) {
            List<String> listPrize = Arrays.asList(prize.SeventhPrize.name(), prize.SixthPrize.name(), prize.FifthPrize.name(), prize.FourthPrize.name());
            return listPrize.get(new Random().nextInt(listPrize.size()));
        } else if (percent < 95) {
            return prize.ThirdPrize.name();
        } else if (percent < 98) {
            return prize.SecondPrize.name();
        } else if (percent == 99) {
            return prize.FirstPrize.name();
        }
        return prize.EighthPrize.name();
    }
    public static int randomPercent(){
        Random rand = new Random();
        return rand.nextInt(100);
    }
}