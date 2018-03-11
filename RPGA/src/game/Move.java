package game;

import eq.Eq;
import monsters.Szczur;
import Misc.Random;
import java.util.Scanner;
public class Move {


    public static void Sewers() {

        Scanner odczyt = new Scanner(System.in);
        String x = odczyt.nextLine();

        switch (x) {
            case "1":
                if (Eq.torch == 0) {
                    System.out.println("Jest za ciemno, żeby iść dalej");
                    Sewers();
                } else if (Eq.torch == 1) {
                    System.out.println("W głębi kanału jest bardzo ciemno, czy chcesz użyć pochodni?(t/n)");
                    String a = odczyt.nextLine();
                    if (a.equals("t")) {
                        System.out.println("Idziesz w głąb kanału, trafiasz na wgłębienie, widzisz kilka szkieletów i worków");
                        System.out.println("Co robisz?((1)idz na poludnie/(2)idz na polnoc/(3)przeszukaj zwłoki/(b)spij(regeneracja hp i many)(s)statystyki/(e)ekwipunek");
                        Move.Corpse();
                        Eq.torch--;
                    } else {
                        Sewers();
                    }
                }

            case "2":
                Szczur szczur = new Szczur(20, 20, 1, 2, "Szczur", 1, 1, 1);
                Fight.startBattle();
                Sewers();

            case "b":
                System.out.println("Jest zbyt niebezpiecznie, żeby pójść spać. TIP: poszukaj schronienia");

            case "s":
                Player.Stats();
                Sewers();

            case "e":
                Player.Eq();
                Sewers();
        }
    }

    public static void Corpse() {
        Scanner odczyt = new Scanner(System.in);
        String x = odczyt.nextLine();

        switch (x) {
            case "1":
                System.out.println("Wracasz tam gdzie się obudziłeś");
                Sewers();

            case "2":
                System.out.println("W głębi kanału dostrzegasz drabinę i właz, prowadzące na zewnątrz");
                System.out.println("(1)idz na poludnie/(2)idz na polnoc/(3)/idz na wschod/(4)idz na zachod/(b)spij(regeneracja hp i  many)/(s)statystyki/(e)/ekwipunek/(p)''na sobie''");
                Outside();

            case "3":
              //  Eq.unequipWeapon(Eq.currentWeapon);
               // Eq.setCurrentWeapon(Random.Random(1, 3));
                double coins = Random.random(20, 50);
                Player.setMoney(coins);
                Eq.addWeaponToEq(Random.Random(1,3));
                System.out.println("Przeszukując zwłoki znajdujesz:" + coins + " monet");
                Corpse();

            case "b":
                System.out.println("Spanie pomiędzy szkieletami nie należy do najprzyjemniejszych ale wygląda na to, że nie masz wyboru");
                Player.Sleep();
                Corpse();

            case "s":
                Player.Stats();
                Corpse();

            case "e":
                Player.Eq();
                Corpse();
            case "p":
                Eq.gearOn();
                Sewers();
        }
    }

    public static void Outside() {
        Scanner odczyt = new Scanner(System.in);
        String x = odczyt.nextLine();

        switch (x) {

                /*case "1":
                    System.out.println("Dochodzisz na polane, wygląda na to, że nic tu nie ma.(1)idz na poludnie/(2)idz na polnoc/(3)idz na wschod/(4)idz na zachod");
                    Field();*/
            case "2":
                if (Player.getLvl() <=5){
                System.out.println("Dochodzisz do lasu, nie wygląda on na zbyt przyjazny czy jesteś pewien, że chcesz iśc dalej?(t/n)");
                String a = odczyt.nextLine();
                if (a.equals("t")) {
                    Forest();
                } else Outside();
            } else{
                System.out.println("Dochodzisz do mrocznego lasu ale jesteś napakowanym, hiper koksem z Cubano i wbijasz jak do siebie");
                Forest();
            }
            case "3":
                System.out.println("");
        }
    }
        public static void Forest(){}




}
