package typeinfo.proxy;

/**
 * @author luzj
 * @description:
 * @date 2019/4/11
 */
public class BigBigNinja implements Ninja {
    private String name;
    private Weapon weapon;

    public BigBigNinja(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    @Override
    public void killPerson(Person person) {
         weapon.makeDamage(person);
         if (person.isDead)
             System.out.println(person.getName()+" is Dead");
         else
             System.out.println(person.getName()+" still alive,his hp is "
                     +person.getHp());
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return "BigBigNinja{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                '}';
    }
}
