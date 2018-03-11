package game;

import java.util.Scanner;

import eq.Eq;
import monsters.Szczur;
import game.Player;
public class Start {

    public static void main(String[] args) {

        Scanner odczyt = new Scanner(System.in);
        System.out.println("Witaj w grze DUPA, czy chcesz rozpocząć?(t/n)");
        String start = odczyt.next();
        if(start.equals("t")){
            System.out.println("Wybierz imię swojego bohatera:");
            Player.PlayerName = odczyt.next();

            Player player = new Player(100,100,50,50,5,5,Player.PlayerName);
            Eq.setCurrentWeapon(0);
            Player.Stats();
            Eq.InitItemEq();
            Eq.InitWeaponEq();

            System.out.println("--------------------");
            System.out.println("Budzą Cię krople wody spadające na Twoją twarz, czujesz smród ścieków i słyszysz w oddali pisk szczurów");
            System.out.println("Jesteś w cuchnącym kanale, jedyne co pamiętasz to płomienie i tajemnicza postać w czerni");
            System.out.println("Co chcesz zrobić?((1)idz na polnoc/(2)idz na poludnie/(3)spij(regeneracja hp i many)/(s)statystyki)/(e)ekwipunek");
            Move.Sewers();
        }
        else{
            System.out.println("Wychodzisz z gry");
            System.exit(1);
        }


    }
}