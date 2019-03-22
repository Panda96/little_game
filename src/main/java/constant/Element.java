package constant;

/**
 * Created by PandaLin on 2019/3/18.
 */
public enum Element {
    METAL(0, "金"), WOOD(1, "木"), WATER(2, "水"), FIRE(3, "火"), EARTH(4, "土");

    private int type;
    private String name;
    Element(int type, String name){
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
