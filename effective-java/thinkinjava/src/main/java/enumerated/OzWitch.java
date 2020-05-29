package enumerated;

import static net.mindview.util.Print.*;

/**
 * @author luzj
 * @description: 0 来自各个方向巫师
 * 1 给一个enum类添加自定义的方法
 * 2 enum本质上就是final class,他的每一个元素都是final实例
 * @date 2019/4/23
 */
public enum OzWitch {
    WEST("Miss Gulch,aka the Wicked Witch of North"),
    NORTH("Glinda,the Good Witch of North"),
    EAST("Wicked Witch of the East,wearer of the Ruby Slippers,crushed by Dorothy's house"),
    SOUTH("Good by inference,but missing");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            print(witch+": "+witch.getDescription());
        }
    }
}
