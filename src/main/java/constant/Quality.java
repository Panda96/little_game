package constant;

/**
 * Created by PandaLin on 2019/3/18.
 */
public enum Quality {
    NONE(0, 0), LOW(1, 100), MEDIUM(2, 200), HIGH(3, 300);

    private int id;
    private int power;

    Quality(int id, int power) {
        this.id = id;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getId() {
        return id;
    }

    public static Quality getQualityById(int id){
        Quality[] qualities = Quality.values();
        for (Quality quality:qualities){
            if(quality.getId()==id){
                return quality;
            }
        }
        return null;
    }
}
