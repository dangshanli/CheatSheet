package intro.ds;

/**
 * @author: luzj
 * @date: 2019-01-17
 * @description: 测试用对象,卡片
 */
public class Card {
    private int id;
    private int num;//数量
    private String describe;//描述

    public Card(int id, int num, String describe) {
        this.id = id;
        this.num = num;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", num=" + num +
                ", describe='" + describe + '\'' +
                '}';
    }


}
