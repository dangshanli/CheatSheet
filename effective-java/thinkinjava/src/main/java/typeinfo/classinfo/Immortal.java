package typeinfo.classinfo;

import java.util.Map;

/**
 * 神仙 住在奥林匹斯山上的那种
 */
@MyClass("immortal")
public class Immortal extends Base implements Action{
    public static final boolean UNDEAD = true;
    static String age = "infinity";
    static {
        System.out.println("no one can slay a immortal!!!");
    }
    private String name;
    private Map<String,Immortal> relatives;

    public Immortal() {
    }

    public Immortal(String name) {
        this.name = name;
    }

    public Immortal(String name, Map<String, Immortal> relatives) {
        this.name = name;
        this.relatives = relatives;
    }

    @Override
    public void action() {

    }

    private void battle(){

    }

    protected void blessHuman(){}

    public Immortal createImmortal(String name){
        return null;
    }

}
