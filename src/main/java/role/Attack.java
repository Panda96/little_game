package role;

import constant.Constant;
import util.ImageInfo;

/**
 * Created by PandaLin on 2019/3/23.
 */
public class Attack implements Runnable, Constant {
    private int x;
    private int y;
    private ImageInfo imageInfo;
    private Role role;
    private boolean toMonster = true;
    private boolean valid;

    private boolean normal;

    public Attack(int x, int y, ImageInfo imageInfo, Role role, boolean toMonster) {

        this.x = x;
        this.y = y;
        this.imageInfo = imageInfo;
        this.role = role;
        this.toMonster = toMonster;
        this.normal = true;
    }

    public boolean isValid() {
        if (normal){
            if (toMonster) {
                return this.x + this.imageInfo.getWidth() < role.getX() + role.getWidth() / 2;
            } else {
                return this.x > role.getX() + role.getWidth() / 2;
            }
        }else {
            return false;
        }

    }


    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void run() {

        if(!toMonster){
            this.normal = false;
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.normal = true;
        }
        do {
            if (toMonster) {
                this.x += Constant.speed;
//                System.out.println("attackMonster:"+this.x);
            } else {
                this.x -= Constant.speed;
//                System.out.println("attackHero:"+this.x);
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (isValid());
    }
}
