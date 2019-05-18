package com.draexlmaier.ia25.serverlesswizard.wizard;

import java.util.Scanner;

public class AWSCommandLineWizard implements CommandLineWizard{

    public  AWSCommandLineWizard(){
        System.out.println("AWSCommandLineWizard constructor called");
    }
private Scanner scanner = new Scanner(System.in);

    @Override
    public void startWizard() {

    }

    private boolean askExistingFile(){
        System.out.println("Do you want to use an existing file?");
        return scanner.nextBoolean();
    }
}
