package enumerated;

import java.util.EnumMap;
import java.util.Iterator;

import static net.mindview.util.Print.print;

/**
 * @author luzj
 * @description: 邮局处理邮件
 * 0 Mail类定义了邮件，其内置enum枚举了邮件5种特性，且定义了generator生成器，随机生成Mail
 * <p>
 * 1 PostOffice负责处理邮件，使用MailHandler枚举定义了4种处理策略，当调用handler(Mail)的时候
 * 枚举策略会依次调用，直到处理完成或者全部策略都无法处理为止
 * <p>
 * 2 这种将策略放在一整条链中，供被处理对象依次调用的方式，叫做责任链模式。
 * 处理策略就像生产线上的工具，总有一款适合你
 * @date 2019/4/24
 */
public class PostOffice {

    interface Handler{
        boolean handle(Mail mail);
    }

    /**
     * 使用enumMap 命令模式来替代抽象方法的方式
     */
    static EnumMap<MailHandler,Handler> handlerEnumMap = new EnumMap<>(MailHandler.class);
    static {
        //该处直接调用的内置在Enum内部的handle实现，是为了在本源码中避免重复
        //如果已经决定采用enumMap的方式，应该删除抽象方法实现，而直接在interface Handler的实现类中实现
        handlerEnumMap.put(MailHandler.GENERAL_DELIVERY,mail -> {
            boolean flag =  MailHandler.GENERAL_DELIVERY.handle(mail);
            return flag;
        });
        handlerEnumMap.put(MailHandler.MACHINE_SCAN,mail ->
                MailHandler.MACHINE_SCAN.handle(mail));
        handlerEnumMap.put(MailHandler.VISUAL_INSPECTION,mail ->
                MailHandler.VISUAL_INSPECTION.handle(mail));
        handlerEnumMap.put(MailHandler.FORWARD_MAIL,mail ->
                MailHandler.FORWARD_MAIL.handle(mail));
        handlerEnumMap.put(MailHandler.RETURN_TO_SENDER,mail ->
                MailHandler.RETURN_TO_SENDER.handle(mail));
    }

    /**
     * 为enum实现的handle方法
     * @param mail
     */
    static void enumHandle(Mail mail){
        //遍历的顺序和put顺序无关，与MailHandler内的enum顺序一致
        for (EnumMap.Entry<MailHandler,Handler> en:handlerEnumMap.entrySet()) {
            Handler handler = en.getValue();
            if (handler.handle(mail))
                return;
        }
    }

    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        print("using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("delivery " + mail + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        },
        FORWARD_MAIL {//新增转发邮件

            @Override
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.forwardAddress) {
                            case NONE:
                                return false;
                            default:
                                print("forward " + mail + " to another address");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("returning " + mail + " to sender");
                        return true;
                }
            }
        },;

        abstract boolean handle(Mail mail);
    }

    static void handle(Mail mail) {
        for (MailHandler h : MailHandler.values()) {
            if (h.handle(mail))
                return;
        }
        print(mail + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail m : Mail.generator(10)) {
            print(m.details());
//            handle(m);
            enumHandle(m);//测试调用
            print("************");
        }
    }
}

/**
 * 0 定义邮件
 * 1 使用enum枚举邮件的不同特性，其中邮件的特性是有限的、离散的
 * 2 定义generator自动生成邮件的Iterable对象
 */
class Mail {
    //通用发送
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    //可机器扫描
    enum Scannability {
        UNSCANNABLE, YES1, YES2, YES3, YES4
    }

    //可人工阅读
    enum Readability {
        ILLEGIBLE, YES1, YES2, YES3, YES4
    }

    //目标地址
    enum Address {
        INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
    }

    enum ForwardAddress {
        NONE, OK1, OK2, OK3, OK4
    }

    //打回地址
    enum ReturnAddress {
        MISSING, OK1, OK2, OK3, OK4, OK5
    }

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ForwardAddress forwardAddress;
    ReturnAddress returnAddress;

    static long count = 0;
    long id = count++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scannability: " + scannability +
                ", Readability: " + readability +
                ", Address: " + address +
                ", Forward Address: " + forwardAddress +
                ", Return address: " + returnAddress;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
