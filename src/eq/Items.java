package eq;

public class Items {
    public int id;
    public String name;


    public Items(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Items i0 = new Items(0,"czaszka sczura");

    public static Items ItemsArray[] = {i0};

}
