package LLD_Khauf_coder.Builder.Example;



    class HumanBody {

        private String name;
        private String gender;
        private boolean biceps;
        private boolean triceps;
        private boolean chest;

        private HumanBody(Builder builder) {
            this.name = builder.name;
            this.gender = builder.gender;
            this.biceps = builder.biceps;
            this.triceps = builder.triceps;
            this.chest = builder.chest;
        }


        public static class Builder
        {
            // Required parameters
            private String name;
            private String gender;

            // Optional parameters
            private boolean biceps;
            private boolean triceps;
            private boolean chest;

            public Builder(String name, String gender) {
                this.name = name;
                this.gender = gender;
            }

            public  Builder biceps() {
                this.biceps = true;
                return this;
            }

            public Builder triceps() {
                this.triceps = true;
                return this;
            }

            public Builder chest() {
                this.chest = true;
                return this;
            }

            public HumanBody build() {
                return new HumanBody(this);
            }

        }

        public static void main(String[] args) {
            HumanBody body = new HumanBody.Builder("Rahul", "Male")
                    .biceps()
                    .chest()
                    .build();
        }

    }

