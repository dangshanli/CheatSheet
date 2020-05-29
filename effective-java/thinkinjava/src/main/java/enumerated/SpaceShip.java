package enumerated;

/**
 * @author luzj
 * @description: 0 太空船：侦察舰 运货舰 运输舰 巡航舰 战斗舰 母舰
 * 1 覆盖toString方法
 * @date 2019/4/23
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    /**
     * 将name()转变为首字母大写，后面小写的形式
     *
     * @return
     */
    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip ship : values()) {
            System.out.println(ship);
        }
    }
}
