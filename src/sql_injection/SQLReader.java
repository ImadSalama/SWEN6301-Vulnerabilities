package sql_injection;

import java.util.Scanner;

public class SQLReader {
    private Scanner scanner;

    public SQLReader(){
        scanner = new Scanner(System.in);
    }

    public String readCommand() {

        return scanner.nextLine();
    }

}
