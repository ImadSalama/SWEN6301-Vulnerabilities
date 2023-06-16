package command_executor;

import java.io.IOException;

public class CommandExecutorWithPrevention extends CommandExecutor{

    public CommandExecutorWithPrevention() {
        this.commandReader = new CommandReader();
    }

    @Override
    public void execute() {
        String folderName = this.readFolder();
        String preventedFolderName = StringHelper.escape(folderName);
        try {
            Process process = this.executeCommand(Constants.BASE_COMMAND +preventedFolderName);
            String processOutput = this.readProcessOutput(process);
            System.out.println(processOutput);
        }
        catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }

}
