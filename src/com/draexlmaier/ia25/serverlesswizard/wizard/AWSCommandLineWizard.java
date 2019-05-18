package com.draexlmaier.ia25.serverlesswizard.wizard;

import java.util.Scanner;

public class AWSCommandLineWizard implements CommandLineWizard {

    public AWSCommandLineWizard() {
        System.out.println("AWSCommandLineWizard constructor called");
    }

    private final Scanner scanner = new Scanner(System.in);


    private static class WizardDto {

        private final String microserviceName;

        private WizardDto(final WizardDtoBuilder builder) {
            this.microserviceName = builder.microserviceName;
        }

        private class WizardDtoBuilder {
            private String microserviceName;

            private WizardDtoBuilder microserviceName(final String name) {
                this.microserviceName = name;
                return this;
            }

            private WizardDto build() {
                return new WizardDto(this);
            }
        }
    }

    @Override
    public void startWizard() {
        final boolean useExistingFile = this.askExistingFile();
        if (useExistingFile) {
            throw new UnsupportedOperationException("existing files are not yet supported");
        } else {
            this.startWithNewFile();
        }
    }

    private void startWithNewFile() {
        final AWSServerlessYamlDTO yamlDTO = new AWSServerlessYamlDTO();
        final String projectName = this.askForString("Project (used as prefix)");
        final String microserviceName = this.askForString("Microservice");
        final AWSServerlessYamlDTO.Service service = new AWSServerlessYamlDTO.Service(projectName + '-' + microserviceName);
        final AWSServerlessYamlDTO.Provider provider = new AWSServerlessYamlDTO.Provider();
    }

    private boolean askExistingFile() {
        System.out.println("Do you want to use an existing file? (Yes/No)");
        final String choice = scanner.nextLine().toLowerCase();
        if ("yes".equals(choice)) {
            return true;
        } else if ("no".equals(choice)) {
            return false;
        } else {
            throw new RuntimeException("Only yes or no is accepted");
        }
    }

    private String askForString(final String propertyName) {
        System.out.println("Name of " + propertyName + ": ");
        return scanner.nextLine();
    }
}
