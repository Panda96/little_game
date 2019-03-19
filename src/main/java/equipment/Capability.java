package equipment;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Capability {
    int base;
    int[] elements;

    public Capability(int base) {
        this.base = base;
        this.elements = new int[5];
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }
}
