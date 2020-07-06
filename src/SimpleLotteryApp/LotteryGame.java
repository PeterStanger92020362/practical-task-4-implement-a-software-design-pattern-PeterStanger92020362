package SimpleLotteryApp;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class LotteryGame extends Observable{

    private ArrayList<Integer> numbersToCall = new ArrayList<>();
    private ArrayList<Observer> observers;
    private Random rand = new Random();
    private int winners;
    private int ticketPrice;

    //constructor
    public LotteryGame(){

        //generate the 49 numbers to call for the Lottery Game
        for (int i = 0; i < 49 ; i++) {
            numbersToCall.add(i+1);
        }

        this.numbersToCall = numbersToCall;
        this.observers = new ArrayList<Observer>(){};
        this.winners = 0;
        this.ticketPrice = 1;

        System.out.println("**** Welcome to the Simple Lotto ****\nWelcome...");
    }

    //getter
    public ArrayList<Integer> getNumbersToCall() {
        return numbersToCall;
    }

    public int getWinners(){
        return winners;
    }

    //setter
    public void setWinners(){
        this.winners++;
    }



    public void drawNumber(){
        Integer calledNumber = 0;

        // generate random number between 1 and 49
        calledNumber = getNumbersToCall().get(rand.nextInt(getNumbersToCall().size())); 
        System.out.println("Announcing this week's winning ticket.... " +
                "the number is....." + calledNumber);

        setChanged();
        notifyObservers(this,calledNumber);

    }


    // Observer/Observable methods
    public void notifyObservers(Observable observable, Integer numberCalled){
        for (Observer ob : observers) {
            ob.update(observable, numberCalled);
        }

    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }





}
