package typeinfo.contructorinfo;

/**
 * @author luzj
 * @description: 奥德赛
 * @date 2019/4/18
 */
public class Oddesay {
    private Actor[] actors;

    public Oddesay() {
    }

    public Oddesay(Actor[] actors) {
        this.actors = actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public void actorPlay() {
        if (actors != null)
            for (Actor a : actors) {
                a.mainDisplay("Oddesay");
            }
    }
}
