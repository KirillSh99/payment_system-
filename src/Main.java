import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

class Blockchain {
    private List<Block> chain = new ArrayList<>();
    private List<Transaction> pendingPool = new ArrayList<>();

    public Blockchain(String name, int balance) {
        List<Transaction> genesisTx = new ArrayList<>();
        genesisTx.add(new Transaction("System", name, balance));
        Block genesis = new Block(0, genesisTx, "0");
        chain.add(genesis);
    }
}

class Transaction{
    private String Sender;
    private String Geter;
    private double balance;

    Transaction(String sender, String geter, double balance){
        setSender(sender);
        setGeter(geter);
        setBalance(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setGeter(String geter) {
        Geter = geter;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public double getBalance() {
        return balance;
    }

    public String getSender() {
        return Sender;
    }

    public String getGeter() {
        return Geter;
    }

    @Override
    public String toString() {
        return Sender + "->" + Geter + ":" + balance ;
    }
}
class Genesis_Block{
    private int Index = 0;
    String Hash_past = "0";
    Scanner scanner = new Scanner(System.in);
    Transaction first_transaction = new Transaction("System", "Вася", 100);
}

class Block{
    private int Index;
    private ArrayList<Transaction> transaction_list;
    String Hash_past;
    String Hash_now;

    Block(int Index, List<Transaction> transaction_list, String Hash_past){
        this.Index=Index;
        this.transaction_list=new ArrayList<Transaction>(transaction_list);
        this.Hash_past=Hash_past;
        Hash_now=calculateHash();
    }
    public String calculateHash(){
        String data = Index + transaction_list.toString() + Hash_past;
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Имя получателя:");
        String first_Geter = sc.nextLine().trim();
        System.out.print("Сумма:");
        String first_balance = sc.nextLine().trim();
        int first_bal = Integer.parseInt(first_balance);

        Blockchain blockchain = new Blockchain(first_Geter, first_bal);

        boolean start = true;
        System.out.println("Введите:\n1) Чтобы произвести транзакцию\n2) Вывести цепочку транзакций\n3) Вывести цепочку блоков \n4) Чтобы завершить имитацию\n");
        while (start){
            String number = sc.nextLine().trim();
            try {
                int num = Integer.parseInt(number);
                switch (num){
                    case 1:
                        System.out.print("Введите отправителя, получателя и сумму: \n Имя отправителя:");
                        String name_Sender = sc.nextLine().trim();
                        System.out.print("Имя получателя:");
                        String name_Geter = sc.nextLine().trim();
                        System.out.print("Сумма:");
                        String Balance = sc.nextLine().trim();
                        int ba = Integer.parseInt(Balance);
                        continue;
                    case 4:
                        System.out.print("Завершено");
                        start=false;
                        break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Введите число");
                continue;
            }

        }
    }
}