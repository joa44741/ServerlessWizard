package com.draexlmaier.ia25.serverlesswizard.templategenerator;

import java.io.File;

public interface TemplateGenerator {

    void createFromScratch();
    void createFromExisting(File file);
}
