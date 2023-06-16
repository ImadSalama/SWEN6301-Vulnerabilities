package sql_injection;

import command_executor.EXECUTOR_TYPES;

public class SQLExecutorFactory {

    public static SQLExecutor createCommandExecutor(SQL_EXECUTOR_TYPES executorType){
        SQLExecutor sqlExecutor;
        if(executorType == SQL_EXECUTOR_TYPES.VULNERABILITY){
            sqlExecutor = new SQLExecutorWithVulnerability();
        }
        else if( executorType == SQL_EXECUTOR_TYPES.PREVENTION){
            sqlExecutor = new SQLExecutorWithPrevention();
        }
        else{
            throw new RuntimeException("No Valid Execution type of " + executorType.toString());
        }
        return sqlExecutor;
    }

}
