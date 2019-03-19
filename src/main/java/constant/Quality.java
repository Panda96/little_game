package constant;

/**
 * Created by PandaLin on 2019/3/18.
 */
public enum Quality {
    LOW(100), MEDIUM(200), HIGH(300);

    private int power;

    private Quality(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

}
