package com.draexlmaier.ia25.serverlesswizard;

import com.draexlmaier.ia25.serverlesswizard.wizard.AWSCommandLineWizard;
import com.draexlmaier.ia25.serverlesswizard.wizard.AzureCommandLineWizard;
import com.draexlmaier.ia25.serverlesswizard.wizard.CommandLineWizard;

import java.util.function.Supplier;

public enum CloudPlattform {
    AWS(AWSCommandLineWizard::new, "aws"),
    AZURE(AzureCommandLineWizard::new, "azure");

    private CloudPlattform(final Supplier<CommandLineWizard> cmdLineWizard, final String providerName) {
        this.instantiator = cmdLineWizard;
        this.providerName = providerName;
    }

    private final Supplier<CommandLineWizard> instantiator;
    private final String providerName;

    public CommandLineWizard getInstance() {
        return instantiator.get();
    }

    public String getProviderName() {
        return providerName;
    }
}
