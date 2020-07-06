package SimpleLotteryApp;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class Player implements Observer {

    private ArrayList<Integer> tickets;
    private String name;
    private boolean hasWon;
    private int money;  //note -1 will be treated as infinite money - lucky person!

    //getters
    public ArrayList<Integer> getTickets() {
        return tickets;
    }

    public String getName() {
        return name;
    }

    public boolean getHasWon() {
        return hasWon;
    }

    //contructor
    public Player(String name, ArrayList<Integer> tickets, int money){
        this.name = name;
        this.tickets = tickets;
        this.hasWon = false;
        this.money = money;

        System.out.println(name);

    }

    public void update(Observable mySubject, Object calledNumber){

        if

    }


}
