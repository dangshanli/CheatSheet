### 通过私有化构造器强化不可实例化的能力

一些纯工具类，比如`Collections`,`Arrays`,`Maths`等这些类，他们单纯的提供一些静态方法。
因此，自然也不希望被实例化，只需要`Collections.xxx()`即可

即使我们不显示声明构造器，jvm也会给我们构造一个默认的构造函数，为了防止
他人在调用这些类的时候不小心实例化他们，应该将他们的构造私有化

具体如`chapter2.UtilityClass`所示