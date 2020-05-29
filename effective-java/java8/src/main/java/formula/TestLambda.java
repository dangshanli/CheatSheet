package formula;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: luzj
 * @date: 2019-01-14
 * @description:
 */
public class TestLambda {
    static List<String> collections = new ArrayList<>();

    static {
        collections.add("ddd2");
        collections.add("aaa2");
        collections.add("bbb1");
        collections.add("aaa1");
        collections.add("bbb3");
        collections.add("ccc");
        collections.add("bbb2");
        collections.add("ddd1");
    }

    public static void main(String[] args) {
//        testFormula();
//        testLambda();
//        testConverter();
//        testStaticReference();
//        testConstrctorRef();
//        testLocalVar();

//        testGlobalVar();
//        System.out.println(outerStaticNum);

//        testPredicate();
//        testFunction();
//        testSuppliers();
//        testConsumer();
//        testComparator();
//        testOptional();
//        testStream();
//        testParallelStream();
        testMap();
    }

    static void testMap() {
        Map<Integer, String> map = new HashMap<>();
        //插入新值
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id,val)-> System.out.println(id+"->"+val));

        System.out.println("==================分隔符=================");
        map.computeIfAbsent(3,num->"pac");//如果不存在该元素，则加进来，否则不变
        System.out.println("3: "+map.get(3));

        map.computeIfAbsent(23,num->"val"+num);
        System.out.println("23: "+map.get(23));

        map.computeIfPresent(3,(num,val)->val+num);//如果存在该元素，则修改，否则失败
        System.out.println("new 3: "+map.get(3));

        map.computeIfPresent(9,(num,val)->null);
        System.out.println("new 9: "+map.get(9));

        System.out.println("==================分隔符=================");

        map.remove(3,"val3");//value必须和原来的value一样才能执行移除
        System.out.println("3->"+map.get(3));

        map.remove(3,"val33");
        System.out.println("3->"+map.get(3));

        System.out.println("==================分隔符=================");
        System.out.println(map.getOrDefault(42,"not found"));

        System.out.println("==================分隔符=================");
        //如果原value==null,则直接添加新值进入
        map.merge(9,"val9",(val,newVal)-> val.concat(newVal));
        System.out.println("9->"+map.get(9));

        //如果原value不为null,则进行推导运算
        map.merge(9,"pac",(val,newVal)->val.concat("-"+newVal));
        System.out.println("9->"+map.get(9));
    }

    //parallelStream()，生成并行Stream
    //通过排序实验对比，性能大约为顺序Stream的2.5倍
    static void testParallelStream() {
        int max = 1000 * 1000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println("count:" + count);
        long t1 = System.nanoTime();
        long mills = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("顺序排序时间为: %d ms", mills));

        long t2 = System.nanoTime();
        long count1 = values.parallelStream().sorted().count();
        System.out.println("count1:" + count1);
        long t3 = System.nanoTime();
        long mills1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("并行排序时间为: %d ms", mills1));
    }


    static void testStream() {
        //filter(Predicate)的用法
        collections.stream().
                filter(s -> s.startsWith("a")).
                forEach(System.out::println);

        System.out.println("===============分隔符===============");

        //collections.stream().forEach(System.out::println);
        //sort()的用法,sort返回的是一个新的Stream，对原序列不影响
        collections.stream()
                .sorted()
                .filter(s -> s.startsWith("b"))
                .forEach(System.out::println);

        System.out.println("===============分隔符===============");

        //map(Function)的用法,将T类型转化成R类型
        //sort(Comparator)，自定义对比方法
        collections.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        System.out.println("===============分隔符===============");

        //match(Predicate),用于匹配Predicate条件，只返回布尔值
        //终结操作，返回最终运算结果，而不是Stream对象
        boolean anyA = collections.stream()
                .anyMatch(s -> s.startsWith("a"));

        boolean allA = collections.stream()
                .allMatch(s -> s.startsWith("a"));

        boolean noneZ = collections.stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println("anyA: " + anyA);
        System.out.println("allA: " + allA);
        System.out.println("noneZ: " + noneZ);

        System.out.println("===============分隔符===============");
        //count(),返回Stream中的元素个数，终结操作
        long size = collections.stream()
                .filter(s -> s.startsWith("b"))
                .count();
        System.out.println("size: " + size);

        System.out.println("===============分隔符===============");
        //reduce(BinaryOperator)，对集合元素逐个迭代，不断聚合，最终得到一个Optional值
        //reduce为终结操作
        Optional<String> reduced = collections.stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "$" + s2);
        reduced.ifPresent(System.out::println);
    }

    static void testOptional() {

        Optional<String> optionalS = Optional.of("pam");
        System.out.println("isPresent: " + optionalS.isPresent());
        System.out.println("get: " + optionalS.get());
        System.out.println("orElse: " + optionalS.orElse("fallback"));

        optionalS.ifPresent(s -> System.out.println(s + " one piece"));
    }

    // 重写compare()接口, 实现比较两个对象的方法
    static void testComparator() {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("aJohna", "Snow");
        Person p2 = new Person("bLierb", "Wong");
        int a = comparator.compare(p1, p2);
        int b = comparator.reversed().compare(p1, p2);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    //重写 accept()方法,对给定参数执行运算
    static void testConsumer() {
        Consumer<Person> consumer = person -> System.out.println(person.firstName);
        Consumer<Person> consumer1 = person -> System.out.println(person.lastName);
        Person person = new Person("Jhon", "Snow");
        consumer.andThen(consumer1).accept(person);
    }

    //重写get() 提供T类型对象,不同于Function的是,不需要提供入参
    static void testSuppliers() {
        Supplier<Person> supplier = Person::new;
        Person p = supplier.get();
        System.out.println("p是Person类型: " + (p instanceof Person));
    }

    //重写apply,将T类型转换成R类型
    //使用andThen() compose() 连接起多个运算
    static void testFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> sToS = toInteger.andThen(s -> s + " 朝阳!!!");
        String s = sToS.apply("123");
        System.out.println(s);
    }

    //给定测试条件(重写test()),返回入参的测试结果 true/false
    //可以使用and() or() negate()对多个测试结果进行逻辑运算
    static void testPredicate() {
        Predicate<String> predicate = s -> s.length() > 5;
        boolean b = predicate.test("foo");
        System.out.println("foo>5:" + b);
        System.out.println("c#sharp! > 5:" + predicate.test("c#sharp!"));

        Predicate<String> predicate1 = s -> s.length() < 8;

        System.out.println("5<\'make love\'<8: " + predicate.and(predicate1).test("make love"));
        System.out.println("5<\'make\'<8: " + predicate.and(predicate1).test("make"));
        System.out.println("5<\'locale\'<8: " + predicate.and(predicate1).test("locale"));

        Predicate<Object> notNull = Objects::nonNull;
        Predicate<Object> isNull = Objects::isNull;
        System.out.println("null not null: " + notNull.test(null));
        System.out.println("sss not null: " + notNull.test("sss"));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> notEmpty = isEmpty.negate();

        System.out.println("\'\' is empty: " + isEmpty.test(""));
        System.out.println("\'\' is not empty: " + notEmpty.test(""));
    }

    static int outerStaticNum = 3;//lambda可以直接读取外部静态变量和成员变量
    int outerNum = 4;

    static void testGlobalVar() {
        Converter<Integer, String> converter = from -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        converter.convert(13);
    }

    static void testLocalVar() {
        final int fnum = 1;//可以访问在表达式之外的final和普通变量
        int num = 2;

        Converter<Integer, String> converter = from -> String.valueOf(from + num);
        String conv = converter.convert(2);

        Converter<Integer, String> converter1 = from -> String.valueOf(from + fnum);
        String conv1 = converter1.convert(2);

        System.out.println("conv:" + conv);
        System.out.println("conv1:" + conv1);
    }

    static void testConstrctorRef() {
        PersonFactory<Person> factory = Person::new;
        Person p = factory.create("Jhon", "lenard");
        System.out.println(p.firstName + " " + p.lastName);
    }

    static void testMemberReference() {
        Converter<String, String> converter = new Something()::startWith;//引用成员方法必须对象实例
        String conv = converter.convert("Java");
        System.out.println(conv);
    }

    //通过　:: 直接引用方法的代码，用来实现lambda的方法重写
    static void testStaticReference() {
        Converter<String, Integer> converter = Integer::valueOf;//引用静态方法直接使用类名即可
        Integer conv = converter.convert("134");
        System.out.println(conv);
    }

    static void testConverter() {
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer conv = converter.convert("123");
        System.out.println(conv);
    }

    static void testLambda() {
        List<String> names = Arrays.asList("peter", "ana", "mill", "xenia");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        for (String s : names) {
            System.out.println(s);
        }
    }

    static void testFormula() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.sqrt(16));
        System.out.println(formula.calculate(100));
    }


}
