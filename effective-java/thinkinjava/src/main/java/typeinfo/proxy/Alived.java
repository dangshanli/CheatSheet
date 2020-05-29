package typeinfo.proxy;

/**
 * @author luzj
 * @description:
 * @date 2019/4/11
 */
public abstract class Alived {
    protected int hp;
    protected boolean isDead;


    public Alived(int hp) {
        this.hp = hp;
        isDead = false;
    }

    public int getHp() {
        return hp;
    }

    public boolean isDead() {
        return isDead;
    }

    abstract int damagedBySomething(int damage);

}
