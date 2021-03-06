package com.example.gamblesimulator;

import java.util.Scanner;

public class GambleSimulator {
    public static  double everyDayStake = 0;
    public static  int eachGameBet = 1;
    public static  double totalStake = 0;
    public static final int WON_GAME = 1;
    public static final int LOST_GAME = 0;
    public static int winCount = 0;
    public static int loseCount = 0;
    public static final int YES = 1;

    public static void main(String[] args) {
        gamble();
    }
    static void gamble(){
        int days = 1;
        Scanner scanner = new Scanner(System.in);
        while (days <= 30) {
            System.out.println("How many times you want to play the game for day " + days + ":" );

            int gamePlayed = scanner.nextInt();
            days++;
            everyDayStake = everyDayStake + 100;
            int totalBet = 0;
            for (int i = 0; i < gamePlayed; i++) {
                int bet = (int) Math.floor(Math.random() * 2);
                switch(bet){
                    case WON_GAME:
                        winCount++;
                        totalBet = totalBet + eachGameBet;
                        System.out.println("Player won :" + (eachGameBet) + "$");
                        break;
                    case LOST_GAME:
                        loseCount++;
                        totalBet = totalBet - eachGameBet;
                        System.out.println("Player lost :" + (eachGameBet) + "$");
                        break;
                }
                everyDayStake = (everyDayStake * 50) / 100;
                System.out.println("Stake would become: " + everyDayStake  + "$");
            }
            if(loseCount > winCount){
                loseCount = loseCount - winCount;
                System.out.println("For the day player has lost by : " + loseCount + " times");
                System.out.println("This day is player unluckiest day");
            }else if(winCount >loseCount){
                winCount = winCount - loseCount;
                System.out.println("For the day Player has won by: " + winCount + " times");
                System.out.println("This day is player luckiest day");
            }else{
                System.out.println("Chances of winning or losing game is equal after playing for day");
            }
        }
        totalStake = totalStake + everyDayStake;
        System.out.println("Total stake after playing for 30 days is: " + totalStake  + "$");
        if(loseCount > winCount){
            loseCount = loseCount - winCount;
            System.out.println("In one month Player has lost by : " + loseCount + " times");
        }else if(winCount >loseCount){
            winCount = winCount - loseCount;
            System.out.println("In one month Player has won by: " + winCount + " times");
            System.out.println("Do you want to play again: choose 1 " + "for YES:");
            int value = scanner.nextInt();
            if( value == YES){
                gamble();
            }
        }else{
            System.out.println("Chances of winning or losing game is equal after playing for a month are same");
        }
    }

}
