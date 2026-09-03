import java.util.ArrayList;

class User {
    private int Index = 0;
    private float Balanse = 0;
}

class Transaction{
    private int Index = 0;
    private int Index_sender;
    private int Index_giver;
    private float belence;
}

class Block{
    private int Index = 0;
    public ArrayList<Transaction> trans_list;
    String hash_past;
    String Hash_now;

    // hashCode() - ункция для получения хеша
    //hash_past
    //hash_now
}

public class Main {
    public static void main(String[] args) {


    }
}