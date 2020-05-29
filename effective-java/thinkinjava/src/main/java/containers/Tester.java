package containers;

import java.util.List;

/**
 * @author luzj
 * @description: 容器性能测试模板
 * 模板设计模式
 * 0 传入待测试容器：container 测试逻辑：List<Test<C> 测试参数：TestParam[]
 * 1 打印测试头信息：displayHead
 * 2 时间测试，针对container执行Test链表的每一个测试逻辑，测试的参数遍历TestParam[]
 * 3 测试总次数为：TestParam.length * List<Test<C>>.size()
 * @date 2019/5/28
 */
public class Tester<C> {
    public static int fieldWidth = 8;//格式化打印域值的长度
    //默认参数 size: 10 100 1000 10000 loops:5000
    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10 * 1000, 5000
    );

    protected C initialize(int size) {
        return container;
    }

    protected C container;
    private String headLine = "";
    private List<Test<C>> tests;

    //格式化输出字符串
    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    //格式化输出数值
    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null)
            headLine = container.getClass().getSimpleName();
    }

    /**
     *
     * @param container 待测试
     * @param tests
     * @param paramList
     */
    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester<C>(cntnr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr, tests, paramList).timedTest();
    }

    /**
     * 打印测试头部信息:
     * ---- headLine ----
     * size
     * test.name1
     * test.name2
     * ...
     */
    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headLine.length() - 1;
        StringBuilder head = new StringBuilder(width);

        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField, "size");
        for (Test test : tests) {
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }

    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);//可自行定义其他的初始化方法
                long start = System.nanoTime();
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
