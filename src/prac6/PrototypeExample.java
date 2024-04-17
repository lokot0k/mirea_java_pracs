package prac6;

public class PrototypeExample {
    interface Prototype {
        Prototype clone();
    }

    class ConcretePrototype implements Prototype {
        private String field;

        public ConcretePrototype(String field) {
            this.field = field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }

        @Override
        public Prototype clone() {
            return new ConcretePrototype(this.field);
        }
    }

    public class Example {
        public void Run(String[] args) {
            ConcretePrototype original = new ConcretePrototype("original object");
            ConcretePrototype clone = (ConcretePrototype) original.clone();

            System.out.println("Original field: " + original.getField());
            System.out.println("Cloned field: " + clone.getField());

            clone.setField("cloned object");
            System.out.println("Original field after clone modification: " + original.getField());
            System.out.println("Cloned field after modification: " + clone.getField());
        }
    }

}
