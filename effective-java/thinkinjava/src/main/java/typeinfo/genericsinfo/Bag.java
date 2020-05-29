package typeinfo.genericsinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzj
 * @description: 包，里面装球
 * @date 2019/4/19
 */
public class Bag {
    protected List<Ball> balls = new ArrayList<>();

    public List<Ball> getBalls(){
        return this.balls;
    }

    public void setBalls(List<Ball> balls){
        this.balls = balls;
    }



}
