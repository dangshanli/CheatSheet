package typeinfo.proxy;

/**
 * @author luzj
 * @description:
 * @date 2019/4/11
 */
public class Sword implements Weapon {
    private final int damage = 3;

    @Override
    public void makeDamage(Alived alived) {
        alived.damagedBySomething(this.damage);
    }
}
