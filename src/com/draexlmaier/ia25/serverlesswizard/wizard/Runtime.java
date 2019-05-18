package com.draexlmaier.ia25.serverlesswizard.wizard;

public enum Runtime {
    PYTHON3("python3.7"),
    PYTHON2("python2.7"),
    NODE("nodejs10.x"),
    JAVA("java8");

    private Runtime(final String runtimeName) {
        this.runtimeName = runtimeName;
    }

    private final String runtimeName;

    public String getRuntimeName() {
        return runtimeName;
    }
}
