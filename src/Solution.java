import command_executor.CommandExecutor;
import command_executor.CommandExecutorFactory;
import command_executor.EXECUTOR_TYPES;
import sql_injection.SQLExecutor;
import sql_injection.SQLExecutorFactory;
import sql_injection.SQL_EXECUTOR_TYPES;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Solution {

    public static void printMenu(){
        System.out.println("Welcome to Imadeddin's Vulnarability program");
        System.out.println("Enter the number you need to check");
        System.out.println("1- Command Injection with vulnerability code");
        System.out.println("2- Command Injection with prevention of vulnerability");
        System.out.println("3- SQL Injection with vulnerability ");
        System.out.println("4- SQL Injection with prevention of vulnerability");
        System.out.println("5- Exit");
    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            printMenu();
            int value = sc.nextInt();
            if(value == 1){
                CommandExecutor commandExecutor = CommandExecutorFactory.createCommandExecutor(
                        EXECUTOR_TYPES.VULNERABILITY
                );
                commandExecutor.execute();
            }
            else if(value == 2){
                CommandExecutor commandExecutor = CommandExecutorFactory.createCommandExecutor(
                        EXECUTOR_TYPES.PREVENTION
                );
                commandExecutor.execute();
            }
            else if(value == 3){
                SQLExecutor sqlExecutor = SQLExecutorFactory.createCommandExecutor(
                        SQL_EXECUTOR_TYPES.VULNERABILITY
                );
                sqlExecutor.execute();
            }
            else if(value == 4){
                SQLExecutor sqlExecutor = SQLExecutorFactory.createCommandExecutor(
                        SQL_EXECUTOR_TYPES.PREVENTION
                );
                sqlExecutor.execute();
            }
            else if(value == 5){
                System.out.println("Terminating the program");
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
    }

}
