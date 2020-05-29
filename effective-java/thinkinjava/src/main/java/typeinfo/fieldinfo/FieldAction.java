package typeinfo.fieldinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author luzj
 * @description:
 * @date 2019/4/18
 */
public class FieldAction {
    public static void main(String[] args) throws ParseException, NoSuchFieldException, IllegalAccessException {
        Class cl = Monster.class;
        System.out.println("-------------获取全部Field对象及其名称和类型-----------");
        Field[] fields = cl.getDeclaredFields();
        Arrays.asList(fields).stream().forEach(t->{
            System.out.print(t.getName()+":");
            System.out.println(t.getType().getTypeName());
        });

        System.out.println("-------------获取指定Field类型-----------");
        try {
            Field f = cl.getDeclaredField("name");
            System.out.println(f.getType().getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("-------------获取指定Field的值-----------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date birth = sdf.parse("2011/3/21 12:33:50");
        Monster monster = new Monster("dada",5.22,birth,new Monster[]{
                new Monster("nini"),
                new Monster("pie")
        });
        Field nameF = cl.getDeclaredField("name");
        System.out.println("name private:"+Modifier.isPrivate(nameF.getModifiers()));
        nameF.setAccessible(true);
        System.out.println("name:"+nameF.get(monster));
        Field heightF = cl.getDeclaredField("height");
        heightF.setAccessible(true);
        System.out.println("height:"+heightF.get(monster));
        System.out.println("height2:"+heightF.getDouble(monster));
//        System.out.println("height3:"+heightF.getInt(monster));
//        System.out.println("height4:"+heightF.getChar(monster));
        Field friendsF = cl.getDeclaredField("friends");
        friendsF.setAccessible(true);
        Monster[] actors = (Monster[]) friendsF.get(monster);
        Arrays.asList(actors).stream().forEach(t->{
            System.out.print("\t"+t.getName());
        });

        System.out.println("-------------修改指定Field的值-----------");
        nameF.set(monster,"WangLin");
        System.out.println("name after modify:"+nameF.get(monster));
        System.out.println("name after modify:"+monster.getName());
        friendsF.set(monster,new Monster[]{
                new Monster("YunFei"),
                new Monster("HeXiang")
        });
        Arrays.asList(monster.getFriends()).stream().forEach(t->{
            System.out.println("\t"+t.getName());
        });





    }
}
