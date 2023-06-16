package command_executor;

public class CommandExecutorFactory {

    public static CommandExecutor createCommandExecutor(EXECUTOR_TYPES executorType){
        CommandExecutor commandExecutor;
        if(executorType == EXECUTOR_TYPES.VULNERABILITY){
            commandExecutor = new CommandExecutorWithVulnerability();
        }
        else if( executorType == EXECUTOR_TYPES.PREVENTION){
            commandExecutor = new CommandExecutorWithPrevention();
        }
        else{
            throw new RuntimeException("No Valid Execution type of " + executorType.toString());
        }
        return commandExecutor;
    }

}
