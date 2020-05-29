package enumerated.menu;

import enumerated.Enums;

/**
 * @author luzj
 * @description:
 * 0 证券enum，分为Stock（股票）和Bond(债券)
 * 1 Stock和Bond是实现Security接口的enum
 * 2 enum Stock是enum SecurityCategory枚举实例，即通过枚举的枚举进行组织管理和前面的Course一样
 * 3 测试部分是每次随机生成一个证券类型
 * @date 2019/4/23
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> cl) {
        this.values = cl.getEnumConstants();
    }

    interface Security{
        enum Stock implements Security{
            SHORT,LONG,MARGIN
        }
        enum Bond implements Security{
            MUNICIPAL,JUNK
        }
    }

    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory sc = Enums.random(SecurityCategory.class);
            System.out.println(sc+": "+sc.randomSelection());
        }
    }
}
