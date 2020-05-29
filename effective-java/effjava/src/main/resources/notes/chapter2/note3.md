### 通过私有构造器或者枚举强化Singleton的属性

#### 公共静态类的Singleton
大致就是下面这样
```java
public static final Elvis INSTANCE = new ELvis();
```

#### 使用静态工厂
如`chapter2.Elvis`类

#### Singleton序列化问题
单例在序列化的时候不仅仅需要加一个`implements Serialization`。为了防止反序列化
的时候创建一个新的实例，需要加入一个`readResolve()`方法
  
如`chapter2.Elvis2`所示

#### 使用枚举实现单例

如`chapter2.Elvis3`所示,....搞不太懂什么情况

