package enumerated;

import net.mindview.util.*;

import java.util.EnumMap;

import static net.mindview.util.Print.print;
import static enumerated.Input.*;

/**
 * @author luzj
 * @description:
 * @date 2019/4/25
 */
public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {
        TRANSIENT
    }

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {

            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next() {

            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next() {

            }
        },
        TERMINAL {
            @Override
            void output() {
                print("Halted");
            }
        },;

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        /**
         * 非瞬态State使用此方法
         * 因此，两个next方法都默认不可调用，State枚举会根据自己需要哪个方法，就重写那个方法
         *
         * @param input
         */
        void next(Input input) {
            throw new RuntimeException("对于非瞬态的State仅调用next(Input input)");
        }

        /**
         * 瞬态State使用此方法
         */
        void next() {
            throw new RuntimeException("瞬态State仅可以调用next()");
        }

        void output() {
            print(amount);
        }
    }

    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {

    }


}

class RandomInputGenerator implements Generator<Input>{

    @Override
    public Input next() {
        return Input.randomSelection();
    }
}

/**
 * 将Input进行分类
 */
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP),;

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> categorys = new EnumMap<>(Input.class);

    //初始化EnumMap
    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input in : c.values) {
                categorys.put(in, c);
            }
        }
    }

    //获取Input所属种类
    public static Category categorize(Input in) {
        return categorys.get(in);
    }
}
