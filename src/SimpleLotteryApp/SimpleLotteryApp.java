package SimpleLotteryApp;

import java.util.ArrayList;
import java.util.Observer;


public class SimpleLotteryApp {

    public static void main(String[] args) {

        LotteryGame lottery = new LotteryGame();

        //Create and register players as observers
        Player players[] = {
                new Player("Tama", new int[]{3,33,17,46,47,27},-1),
                new Player("Bob", new int[]{7, 19, 22, 23},8),
                new Player("Caesar",new int[]{33, 13},-1 )
        };
      
        for (int i = 0; i < players.length ; i++) {
            lottery.registerObserver(players[i]);
        }


        while(lottery.getWinners()<1){

            lottery.drawNumber();

            for (Player each: players) {
                if(each.getHasWon()){
                    lottery.setWinners();
                }
            }


        }

        //wrap up and congratulate winner/s

        for(Player each: players){
            if(lottery.getWinners()==1 && each.getHasWon()) {
                System.out.println("****** WINNER ******\nCongratulations " + each.getName() + ".\nYou have won");
            } else if (lottery.getWinners()>=2 && each.getHasWon()){
                System.out.println("****** WINNER ******\nCongratulations " + each.getName() + " you share your win!");
            }
        }




    }
}
