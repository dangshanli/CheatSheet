package containers;

/**
 * @author luzj
 * @description: 测试参数：规定容器大小 和 迭代次数
 * @date 2019/5/28
 */
public class TestParam {
    public final int size;//容器大小
    public final int loops;//测试迭代次数

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    /**
     * 将可变长数值包装成TestParam数组
     * @param values
     * @return
     */
    public static TestParam[] array(int... values) {
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];

        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    /**
     * 将字符串数组包装成TestParam数组
     * @param values
     * @return
     */
    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
