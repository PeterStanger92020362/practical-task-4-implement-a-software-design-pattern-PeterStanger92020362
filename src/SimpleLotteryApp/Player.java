package SimpleLotteryApp;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class Player implements Observer {

    private int[] tickets;
    private String name;
    private boolean hasWon;
    private int money;  //note -1 will be treated as infinite money - lucky person!

    //getters
    public int[] getTickets() {
        return tickets;
    }

    public String getName() {
        return name;
    }

    public boolean getHasWon() {
        return hasWon;
    }

    //contructor

    /**
     *
     * @param name
     * @param tickets
     * @param money
     */
    public Player(String name, int[] tickets, int money){
        this.name = name;
        this.tickets = tickets;
        this.hasWon = false;
        this.money = money;

        System.out.println(name);

    }

    public void update(Observable mySubject, Object calledNumber){

        // check to see if they have money for lottery and check if winner
        if(this.money != 0){
            for (Integer each : tickets) {
                if (each.equals(calledNumber)) {
                    this.hasWon = true;
                }
            }            
        }

        // reduce money by 1 for each round participated in
        if(this.money > 0){
            this.money--;
        }
        

    }


}
