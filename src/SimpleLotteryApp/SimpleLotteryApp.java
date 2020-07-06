package SimpleLotteryApp;

import java.util.ArrayList;
import java.util.Observer;


public class SimpleLotteryApp {

    public static void main(String[] args) {

        LotteryGame lottery = new LotteryGame();


        //Create and register players as observers
        ArrayList<Integer> tamaTickets = new ArrayList<>();
        tamaTickets.add(3);
        tamaTickets.add(5);
        tamaTickets.add(6);

        ArrayList<Integer> ameliaTickets = new ArrayList<>();
        ameliaTickets.add(9);
        ameliaTickets.add(2);
        ameliaTickets.add(6);

        ArrayList<Integer> jamalTickets = new ArrayList<>();
        jamalTickets.add(4);
        jamalTickets.add(7);
        jamalTickets.add(2);



        Player players[] = {
                new Player("Tama", tamaTickets),
                new Player("Amelia", ameliaTickets),
                new Player("Jamal", jamalTickets)
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
                -System.out.println("BINGO! " + each.getName() + " has all their numbers called! " + each.getName() + " is the WINNER!");
            } else if (lottery.getWinners()>=2 && each.getHasWon()){
                -System.out.println("BINGO! " + each.getName() + " has all their numbers called! they share their VICTORY!");
            }
        }




    }
}
