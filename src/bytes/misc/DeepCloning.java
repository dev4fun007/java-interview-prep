package bytes.misc;

public class DeepCloning {

    public void start() {
        Value v = new Value("V1");
        Name name1 = new Name("name1", v);
        Name name2 = (Name) name1.clone();
        //Value will be changed for name1 as well
        name2.value.value = "V2";
        System.out.println("New Name1 Value: " + name1.value.value);


        Value nv = new Value("NV1");
        NameDeepClone deepClone1 = new NameDeepClone("ndc1", nv);
        NameDeepClone deepClone2 = (NameDeepClone) deepClone1.clone();
        //Value will not change for deepClone1
        deepClone2.value.value = "NV2";
        System.out.println("New NDC1 Value: " + deepClone1.value.value);
    }

}

class Name implements Cloneable {

    String name;
    Value value;
    Name(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class NameDeepClone implements Cloneable {

    String name;
    Value value;
    NameDeepClone(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    @Override
    protected Object clone() {
        NameDeepClone clone = null;
        try {
            clone = (NameDeepClone) super.clone();
            clone.value = (Value) value.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

class Value implements Cloneable {

    String value;
    Value(String value) {
        this.value = value;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
