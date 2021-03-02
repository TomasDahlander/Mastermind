package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Tries {

    private Label[] labels = new Label[4];

    public Tries(Label label1, Label label2, Label label3, Label label4) {
        this.labels[0] = label1;
        this.labels[1] = label2;
        this.labels[2] = label3;
        this.labels[3] = label4;
    }

    public void colorChange(boolean set) {
        if (set) {
            for(int i = 0; i < 4; i++){
                labels[i].setBackground(new Background(new BackgroundFill(Color.rgb(60,147,234),null,null)));
            }
        }
        else {
            for(int i = 0; i < 4; i++){
                labels[i].setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255),null,null)));
            }
        }
    }

    public void reset(){
        for (Label l : labels){
            l.setText("");
            l.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255),null,null)));
        }
    }

    public Label[] getLabels() {
        return labels;
    }
}