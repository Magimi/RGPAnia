package game.controller;

import eq.Eq;
import game.Fight;
import game.Move;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import monsters.Szczur;

import java.util.Scanner;

public class AnchorPaneController {

    @FXML
    private Button north1;
    private Button south1;

    @FXML
    void initialize(){

    }

    @FXML
    public void southClick(){
        if(Szczur.szczurDeath>-1) {
            Szczur szczur = new Szczur(20, 20, 1, 2, "Szczur", 1, 1, 1);
            if (monsters.Szczur.getSzczurDeath() > 0) {
                Fight.startBattle();
                Szczur.szczurDeath--;
                Move.Sewers();
            } else if (monsters.Szczur.getSzczurDeath() == 0) {
                System.out.println("Twój masowy mord na szczurach obudził ich króla");
                Szczur szczur1 = new Szczur(50, 50, 3, 6, "Król Szczurów", 5, 5, 5);
                Fight.startBattle();
                Szczur.szczurDeath--;
                Move.Sewers();
            }
        }
        else{
            System.out.println("Nic już tutaj nie znajdziesz");
            Move.Sewers();
        }
    }
    @FXML
    public void onClick(){
        if (Eq.torch == 0) {
            System.out.println("Jest za ciemno, żeby iść dalej");
            Move.Sewers();
        } else if (Eq.torch == 1) {
        Scanner odczyt = new Scanner(System.in);

            System.out.println("W głębi kanału jest bardzo ciemno, czy chcesz użyć pochodni?(t/n)");
            String a = odczyt.nextLine();
            if (a.equals("t")) {
                System.out.println("Idziesz w głąb kanału, trafiasz na wgłębienie, widzisz kilka szkieletów i worków");
                Eq.torch--;
                Move.Corpse();

            } else {
                Move.Sewers();
            }
        }


    }


}

