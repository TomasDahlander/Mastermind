package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Label label1;
    public Label label2;
    public Label label3;
    public Label label4;

    public Button plus1;
    public Button minus1;
    public Button plus2;
    public Button minus2;
    public Button plus3;
    public Button minus3;
    public Button plus4;
    public Button minus4;

    public Label try0_0;
    public Label try0_1;
    public Label try0_2;
    public Label try0_3;
    public Label try1_0;
    public Label try1_1;
    public Label try1_2;
    public Label try1_3;
    public Label try2_0;
    public Label try2_1;
    public Label try2_2;
    public Label try2_3;
    public Label try3_0;
    public Label try3_1;
    public Label try3_2;
    public Label try3_3;
    public Label try4_0;
    public Label try4_1;
    public Label try4_2;
    public Label try4_3;
    public Label try5_0;
    public Label try5_1;
    public Label try5_2;
    public Label try5_3;
    public Label try6_0;
    public Label try6_1;
    public Label try6_2;
    public Label try6_3;
    public Label try7_0;
    public Label try7_1;
    public Label try7_2;
    public Label try7_3;
    public Label try8_0;
    public Label try8_1;
    public Label try8_2;
    public Label try8_3;
    public Label try9_0;
    public Label try9_1;
    public Label try9_2;
    public Label try9_3;

    public Label correctLoc0;
    public Label correctLoc1;
    public Label correctLoc2;
    public Label correctLoc3;
    public Label correctLoc4;
    public Label correctLoc5;
    public Label correctLoc6;
    public Label correctLoc7;
    public Label correctLoc8;
    public Label correctLoc9;

    public Label correctDig0;
    public Label correctDig1;
    public Label correctDig2;
    public Label correctDig3;
    public Label correctDig4;
    public Label correctDig5;
    public Label correctDig6;
    public Label correctDig7;
    public Label correctDig8;
    public Label correctDig9;

    public Label codeLabel;

    NPC npc = new NPC();

    List<Tries> tryList = new ArrayList<>();

    List<CheckObject> checkList = new ArrayList<>();

    List<Label> codeAttempt = new ArrayList<>();

    public Button checkButton;

    int turn;

    public void plus(ActionEvent e) {
        if (e.getSource() == plus1) add(label1);
        else if (e.getSource() == plus2) add(label2);
        else if (e.getSource() == plus3) add(label3);
        else add(label4);
    }

    public void minus(ActionEvent e) {
        if (e.getSource() == minus1) sub(label1);
        else if (e.getSource() == minus2) sub(label2);
        else if (e.getSource() == minus3) sub(label3);
        else sub(label4);
    }

    public void add(Label label){
        if (Integer.parseInt(label.getText()) < 6) {
            int x = Integer.parseInt(label.getText());
            x++;
            label.setText(String.valueOf(x));
        }
    }

    public void sub(Label label){
        if (Integer.parseInt(label.getText()) > 1) {
            int x = Integer.parseInt(label.getText());
            x--;
            label.setText(String.valueOf(x));
        }
    }

    public void check(ActionEvent e) {
        if (checkButton.getText().equals("Start Game")){
            if(tryList.isEmpty()){
                makeCheckList();
            }
            else setUpNewGame();
            codeLabel.setText("NPC code");
            npc.makeCode();
            turn = 0;
            checkButton.setText("Check: 1");
            tryList.get(turn).colorChange(true);
        }
        else{
            String [] move = printAndGetMove();
            checkMove(move);
        }
    }

    public String[] printAndGetMove(){
        String[]s = new String[4];
        for(int i = 0; i < 4; i++){
            s[i] = codeAttempt.get(i).getText();
            tryList.get(turn).getLabels()[i].setText(s[i]);
        }
        return s;
    }

    public void checkMove(String [] move){
        int [] results = npc.getResult(move);
        checkList.get(turn).setCorrectLocAmountNumber(results[0]);
        checkList.get(turn).setCorrectDigAmountNumber(results[1]);
        if (results[0] == 4){
            codeLabel.setText("Winner! " + npc.getCode());
            checkButton.setText("Start Game");
        }
        else if (turn == 9){
            codeLabel.setText("Loser! " + npc.getCode());
            checkButton.setText("Start Game");
        }
        else{
            tryList.get(turn).colorChange(false);
            turn++;
            tryList.get(turn).colorChange(true);
            checkButton.setText("Check: " + (turn+1));
        }
    }

    public void setUpNewGame(){
        for (Tries t : tryList){
            t.reset();
        }

        for (CheckObject o : checkList){
            o.reset();
        }
    }

    public void makeCheckList(){
        checkList.add(new CheckObject(correctLoc0,correctDig0));
        checkList.add(new CheckObject(correctLoc1,correctDig1));
        checkList.add(new CheckObject(correctLoc2,correctDig2));
        checkList.add(new CheckObject(correctLoc3,correctDig3));
        checkList.add(new CheckObject(correctLoc4,correctDig4));
        checkList.add(new CheckObject(correctLoc5,correctDig5));
        checkList.add(new CheckObject(correctLoc6,correctDig6));
        checkList.add(new CheckObject(correctLoc7,correctDig7));
        checkList.add(new CheckObject(correctLoc8,correctDig8));
        checkList.add(new CheckObject(correctLoc9,correctDig9));

        tryList.add(new Tries(try0_0,try0_1,try0_2,try0_3));
        tryList.add(new Tries(try1_0,try1_1,try1_2,try1_3));
        tryList.add(new Tries(try2_0,try2_1,try2_2,try2_3));
        tryList.add(new Tries(try3_0,try3_1,try3_2,try3_3));
        tryList.add(new Tries(try4_0,try4_1,try4_2,try4_3));
        tryList.add(new Tries(try5_0,try5_1,try5_2,try5_3));
        tryList.add(new Tries(try6_0,try6_1,try6_2,try6_3));
        tryList.add(new Tries(try7_0,try7_1,try7_2,try7_3));
        tryList.add(new Tries(try8_0,try8_1,try8_2,try8_3));
        tryList.add(new Tries(try9_0,try9_1,try9_2,try9_3));

        codeAttempt.add(label1);
        codeAttempt.add(label2);
        codeAttempt.add(label3);
        codeAttempt.add(label4);
    }

}
