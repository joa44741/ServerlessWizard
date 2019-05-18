package com.draexlmaier.ia25.serverlesswizard.wizard;

import com.draexlmaier.ia25.serverlesswizard.CloudPlattform;

public class AWSServerlessYamlDTO {


    public static class Service {
        String name;

        public Service(final String name) {
            this.name = name;
        }
    }

    public static class Provider {
        private final String name;
        private final String runtime;
        private final String stage;
        private final String region;
        private final String stackName;
        private final String profile;

        private Provider(final ProviderBuilder builder) {
            this.name = builder.name;
            this.runtime = builder.runtime;
            this.profile = builder.profile;
            this.stage = builder.stage;
            this.region = builder.region;
            this.stackName = builder.stackName;
        }

        public static class ProviderBuilder {
            private final String name;
            private String runtime = null;
            private final String stage;
            private final String region;
            private String stackName;
            private final String profile;

            public ProviderBuilder(final CloudPlattform cloudPlattform, final String defaultStage, final String region, final String profile) {
                this.name = cloudPlattform.getProviderName();
                this.stage = defaultStage;
                this.region = region;
                this.profile = profile;
            }

            public ProviderBuilder runtime(final Runtime runtime) {
                this.runtime = runtime.getRuntimeName();
                return this;
            }

            public Provider build() {
                return new Provider(this);
            }
        }
    }
}


