package com.draexlmaier.ia25.serverlesswizard;

import com.draexlmaier.ia25.serverlesswizard.wizard.AWSCommandLineWizard;
import com.draexlmaier.ia25.serverlesswizard.wizard.AzureCommandLineWizard;
import com.draexlmaier.ia25.serverlesswizard.wizard.CommandLineWizard;

import java.util.function.Supplier;

public enum CloudPlattform {
    AWS(AWSCommandLineWizard::new),
    AZURE(AzureCommandLineWizard::new);

    private CloudPlattform(Supplier<CommandLineWizard> cmdLineWizard){
        this.instantiator = cmdLineWizard;
    }

    private Supplier<CommandLineWizard> instantiator;

    public CommandLineWizard getInstance() {
        return instantiator.get();
    }
}
