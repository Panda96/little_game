package constant;

/**
 * Created by PandaLin on 2019/3/18.
 */
public enum Element {
    METAL(0), WOOD(1), WATER(2), FIRE(3), EARTH(4);

    private int type;
    Element(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
