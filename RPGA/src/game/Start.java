package game;

import game.controller.AnchorPaneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

public class Start extends Application {
    public static final String CYAN = "\u001B[36m"; //zdobywanie itemku
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";//otrzymanie obrażeń
    public static final String YELLOW = "\033[0;93m"; // poziom
    public static final String PURPLE = "\033[0;95m"; // systemowe

    public static void main(String[] args) {
        launch(args);


       /* Scanner odczyt = new Scanner(System.in);
        System.out.println("Witaj w grze DUPA, czy chcesz rozpocząć?" + PURPLE + "(t/n)" + RESET);
        String start = odczyt.next();
        if (start.equals("t")) {
            System.out.println("Wybierz imię swojego bohatera:");
            Player.PlayerName = odczyt.next();

            Player player = new Player(100, 100, 50, 50, 5, 5, 1, 1, Player.PlayerName);
            Eq.setCurrentWeapon(0);
            //Player.Stats();
            Eq.InitItemEq();
            Eq.InitWeaponEq();

            System.out.println("--------------------");
            System.out.println("Budzą Cię krople wody spadające na Twoją twarz, czujesz smród ścieków i słyszysz w oddali pisk szczurów");
            System.out.println("Jesteś w cuchnącym kanale, jedyne co pamiętasz to płomienie i tajemnicza postać w czerni");

            Move.Sewers();
        } else {
            System.out.println("Wychodzisz z gry");
            System.exit(1);
        }*/
    }

        @Override
        public void start (Stage primaryStage) throws Exception {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/game/fxml/Start.fxml"));
            AnchorPane anchorPane = loader.load();
            AnchorPaneController controller = loader.getController();
            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.show();


        }

}