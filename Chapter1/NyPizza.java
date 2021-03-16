package builderpatternhierarchies;

public class NyPizza extends Pizza{
    public  enum Size {SMALL, MEIDUM, LARGe}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size){
            this.size = size;
        }
        @Override public NyPizza build(){
            return NyPizza(this);
        }

        @Override protected Builder self(){
            return this;
        }

        private  NyPizza(Builder builder){
            super(builder);
            size = builder.size;
        }
    }

    public class Calzone extends Pizza {
        private final boolean sauceInside;

        public static class Builder extends Pizza.Builder<NyPizza.Builder> {
            private boolean sauceInside = false; //default

            public  Builder sauceInside(){
                sauceInside = true;
                return this;
            }

            @Override public  Calzone build(){
                return new Calzone(this);
            }
            @Override protected Builder self(){
                return this;
            }
        }
    }
}
