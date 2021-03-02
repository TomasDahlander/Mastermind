package sample;

import java.util.Random;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-01-06 <br>
 * Time: 09:51 <br>
 * Project: Mastermind <br>
 */
public class NPC {

    private String[]code = new String[4];

    public void makeCode(){
        Random nr = new Random();
        for (int i = 0; i < 4; i++) {
            code[i] = String.valueOf(nr.nextInt(6)+1);
        }
    }

    public int[] getResult(String[] move){
        CheckTracker[] check = new CheckTracker[4];
        for(int i = 0; i < 4; i++) check[i] = new CheckTracker();

        int correctLoc = 0;
        int correctDig = 0;

        for (int i = 0; i < 4; i++){
            if(move[i].equals(code[i])){
                check[i].correctlyPlaced = true;
                correctLoc++;
            }
        }

        for (int i = 0; i < 4; i++){
            if(check[i].correctlyPlaced) continue;
            for (int j = 0; j < 4; j++){
                if(!check[j].correctlyPlaced){
                    if(move[i].equals(code[j]) && !check[j].correctDigitCode && !check[i].correctDigitMove){
                        check[j].correctDigitCode = true;
                        check[i].correctDigitMove = true;
                        correctDig++;
                        break;
                    }
                }
            }
        }

        return new int[]{correctLoc, correctDig};
    }

    public String getCode(){
        String s = "";
        for (String c : code){
            s += c;
        }
        return s;
    }
}
