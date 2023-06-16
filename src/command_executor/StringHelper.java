package command_executor;

public class StringHelper {

    public static String escape(String input){
        String strippedCommand = input.replaceAll("[;&amp;|`]*","");
        System.out.println("Stripped Command: " + strippedCommand);
        String escapedCommand = input.replaceAll(
                "[;&|`]+","\\u" + Integer.toHexString('/' | 0x10000).substring(1)
        );
        System.out.println("Escaped Command: " + escapedCommand);
        return escapedCommand;

    }

}
