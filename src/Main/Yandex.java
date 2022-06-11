package Main;

import java.util.HashSet;
import java.util.Scanner;

public class Yandex {
    public static void main(String[] args) {
        //задачи для школы яндекс
        // https://contest.yandex.ru/contest/35182/enter/?retPage=


    }


    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        String times = scanner.nextLine();
        String[] timesArray = times.split(" ");
        int[] timesNumberArray = new int[timesArray.length];

        for (int i = 0; i < N; i++) {
            timesNumberArray[i] = Integer.parseInt(timesArray[i]);
        }

        int prevTime = 0;
        int max = 0;
        String maxS = "";
        for (int i = 0; i < N; i++) {
            if (timesNumberArray[i] - prevTime >= max) {
                max = timesNumberArray[i] - prevTime;
                maxS = String.valueOf(S.charAt(i));
            }
            prevTime = timesNumberArray[i];
        }

        System.out.println(maxS);
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        String[] emails = new String[N];
        for (int i = 0; i < N; i++) {
            emails[i] = scanner.nextLine();
        }


        HashSet<String> uniques = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String currentEmail = emails[i];

            String[] split = currentEmail.split("@");
            String login = split[0];
            String domen = split[1];


            login = login.replace(".", "");
            if (login.contains("-")) {
                login = login.substring(0, login.indexOf("-"));
            }


            domen = domen.substring(0, domen.lastIndexOf("."));

            String result = login + "@" + domen;
            uniques.add(result);
        }
        System.out.println(uniques.size());
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String stringPrices = scanner.nextLine();
        String[] stringPricesArray = stringPrices.split(" ");
        int[] prices = new int[N];

        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(stringPricesArray[i]);
        }


        int result = 0;

        for (int k = 0; k < N; k++) {
            int maxPrice = 0;
            int maxDay = 0;
            for (int i = 0; i < N; i++) {
                if (prices[i] == -1) continue;

                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                    maxDay = i;
                }
            }

            int currentMinPrice = 1000;
            for (int i = 0; i < maxDay; i++) {
                if (prices[i] == -1) continue;

                if (prices[i] < currentMinPrice) {
                    currentMinPrice = prices[i];
                }
            }

            if (maxPrice - currentMinPrice > result) {
                result = maxPrice - currentMinPrice;
            }

            prices[maxDay] = -1;
        }

        System.out.println(result);
    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String stringX = scanner.nextLine();
        String[] stringXArray = stringX.split(" ");
        int[] X = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(stringXArray[i]);
        }

        long startRes = 1L;
        long minMinus = Long.MIN_VALUE;
        long maxMinus = -1L;
        long minPlus = Long.MAX_VALUE;
        long maxPlus = 1L;

        long negCount = 0L;
        long posCount = 0L;
        long zeroCount = 0L;
        for (int i = 0; i < N; i++) {
            int cur = X[i];
            if (cur == 0) {
                zeroCount++;
                continue;
            }
            if (cur < 0) {
                negCount++;
                if (cur < maxMinus) {
                    maxMinus = cur;
                }
                if (cur > minMinus)
                    minMinus = cur;

            } else {
                posCount++;
                if (cur > maxPlus) {
                    maxPlus = cur;
                }
                if (cur < minPlus)
                    minPlus = cur;

            }
            startRes *= X[i];
        }

        long result = 0;


        if (startRes > 0 && zeroCount == 0) { //произведение положительные и нет нулей
            if (posCount == 0) { //все числа отрецательные
                result = maxMinus;
            } else { //все числа положительные или четное число минусов
                result = minPlus;
            }
        } else if (startRes < 0 && zeroCount == 0) { //произведение отрицательное и нет нулей
            if (posCount == 0 || negCount == 1) { //все числа отрицательные или только одно (если одно result = minMinus || result = maxMinus не важно;
                result = minMinus;
            } else if (negCount > 1) { //отрицательных больше 1
                result = maxMinus;
            }
        } else if (startRes < 0 && zeroCount == 1) { // произведение отрицательное и 1 ноль
            result = maxMinus; //главное не отдавать 0
        }
        //не проверяем if (startRes > 0 && zeroCount == 1), т.к. надо отдать 0, а он по умолчанию

        System.out.println(result);
    }

}
