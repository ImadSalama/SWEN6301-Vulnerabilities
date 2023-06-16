package command_executor;

import java.util.Scanner;

public class CommandReader {
    private Scanner scanner;

    public CommandReader(){
        scanner = new Scanner(System.in);
    }

    public String readCommand(){
        return scanner.nextLine();
    }

}
