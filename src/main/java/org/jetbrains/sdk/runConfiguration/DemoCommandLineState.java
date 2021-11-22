package org.jetbrains.sdk.runConfiguration;

import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.testframework.TestConsoleProperties;
import com.intellij.execution.testframework.sm.SMTestRunnerConnectionUtil;
import com.intellij.execution.testframework.sm.runner.SMTRunnerConsoleProperties;
import com.intellij.execution.ui.ConsoleView;
import org.jetbrains.annotations.NotNull;

public class DemoCommandLineState extends CommandLineState {
    RunConfiguration runConfiguration;

    public DemoCommandLineState(ExecutionEnvironment environment, RunConfiguration runConfiguration) {
        super(environment);

        this.runConfiguration = runConfiguration;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        GeneralCommandLine commandLine = new GeneralCommandLine();

        OSProcessHandler processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine);
        ProcessTerminatedListener.attach(processHandler);
        return processHandler;
    }

    @Override
    public ExecutionResult execute(@NotNull Executor executor, @NotNull ProgramRunner<?> runner) throws ExecutionException {
        ProcessHandler processHandler = startProcess();

        ExecutionEnvironment environment = getEnvironment();
        TestConsoleProperties properties = new SMTRunnerConsoleProperties(runConfiguration, "yath", executor);
        ConsoleView console = SMTestRunnerConnectionUtil.createAndAttachConsole("yath", processHandler, properties);
        return new DefaultExecutionResult(console, processHandler, createActions(console, processHandler));
    }
}