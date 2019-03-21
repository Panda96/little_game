package equipment;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Capability implements Cloneable {
    int base;
    int[] elements;

    public Capability(int base) {
        this.base = base;
        this.elements = new int[5];
    }

    public void add(Capability capability) {
        this.base += capability.getBase();
        int[] elements1 = capability.getElements();
        for (int i = 0; i < elements1.length; i++) {
            this.elements[i] += elements1[i];
        }
    }

    public void minus(Capability capability){
        int temp = this.base - capability.getBase();
        setBase(Math.max(0, temp));
        int[] elements1 = capability.getElements();
        for (int i = 0; i < elements1.length; i++) {
            this.elements[i] = Math.max(0, this.elements[i] - elements1[i]);
        }
    }

    public Capability multiple(int m){
        Capability total = new Capability(0);
        for(int i = 0;i < m;i++){
            total.add(this);
        }
        return total;
    }

    public int getElementPower(){
        int sum = 0;
        for (int i = 0; i < this.elements.length; i++) {
            sum += elements[i];
        }
        return sum;
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

    @Override
    public Capability clone() {
        Capability copy = null;
        try {
            int[] elementsCopy = this.elements.clone();
            copy = (Capability) super.clone();
            copy.setElements(elementsCopy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    public void show() {
        System.out.println("base: " + this.base);
        System.out.print("elements:");
        for(int i : this.elements){
            System.out.print("\t"+i);
        }
        System.out.println();
    }
}
