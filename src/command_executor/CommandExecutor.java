package command_executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

abstract public class CommandExecutor {

    protected CommandReader commandReader;

    public String readFolder(){
        System.out.println("Enter folder name: ");
        return commandReader.readCommand();
    }

    public Process executeCommand(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    public String readProcessOutput(Process process) throws IOException {
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        StringBuilder builder = new StringBuilder();
        String s = "";
        while ((s = stdInput.readLine()) != null) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }

    public abstract void execute();

}
