package sample;

import javafx.scene.control.Label;

public class CheckObject {

    private final Label correctLoc;
    private final Label correctDig;

    public CheckObject(Label correctLoc, Label correctDig){
        this.correctLoc = correctLoc;
        this.correctDig = correctDig;
    }

    public void setCorrectLocAmountNumber(int amount){
        correctLoc.setText("Rätt plats: " + amount);
    }

    public void setCorrectDigAmountNumber(int amount){
        correctDig.setText("Rätt valör: " + amount);
    }

    public void reset(){
        correctLoc.setText("Rätt plats:");
        correctDig.setText("Rätt valör:");
    }
}
