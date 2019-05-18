package com.draexlmaier.ia25.serverlesswizard;

import com.draexlmaier.ia25.serverlesswizard.wizard.CommandLineWizard;

import java.util.Arrays;

public class Main {



    private static void printBanner() {
        String bannerString = "    ____  ____ _  __    _____                           __\n" +
                "   / __ \\/ __ \\ |/ /   / ___/___  ______   _____  _____/ /__  __________\n" +
                "  / / / / /_/ /   /    \\__ \\/ _ \\/ ___/ | / / _ \\/ ___/ / _ \\/ ___/ ___/\n" +
                " / /_/ / _, _/   |    ___/ /  __/ /   | |/ /  __/ /  / /  __(__  |__  ) \n" +
                "/_____/_/ |_/_/|_|   /____/\\___/_/    |___/\\___/_/  /_/\\___/____/____/  \n" +
                "                                                                        \n" +
                " _       ___                      __\n" +
                "| |     / (_)___  ____ __________/ /\n" +
                "| | /| / / /_  / / __ `/ ___/ __  / \n" +
                "| |/ |/ / / / /_/ /_/ / /  / /_/ /  \n" +
                "|__/|__/_/ /___/\\__,_/_/   \\__,_/   \n" +
                "                                  ";

        System.out.println("\n" + bannerString);
    }

    private static CommandLineWizard chooseCloudPlattform(){
        System.out.println("\nChoose one of the following Cloud Platforms: ");
        Arrays.asList(CloudPlattform.values()).forEach(cloudPlattform -> System.out.println("- " + cloudPlattform));

        System.out.println();
        return CloudPlattform.AWS.getInstance();
    }

    public static void main(String[] args) {
	// write your code here

        printBanner();
        final CommandLineWizard commandLineWizard = chooseCloudPlattform();
        commandLineWizard.startWizard();
    }
}
