由于使用的不同profile来加载不同的bean，所以需要在执行jar包的时候，指定加载不同的profile

示例：
```jshelllanguage
java -jar rabbit-tutorials.jar --spring.profiles.active=topics,receiver --tutorial.client.duration=70000
java -jar rabbit-tutorials.jar --spring.profiles.active=topics,sender --tutorial.client.duration=60000
```
