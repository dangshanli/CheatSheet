package typeinfo.toys;

/**
 * @author luzj
 * @description:
 * @date 2019/4/10
 */

public class ToyTest {


    public static void main(String[] args) {

    }
}


interface HasBattleries {
};

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBattleries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
