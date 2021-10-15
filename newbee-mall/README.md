> https://juejin.cn/book/6844733814074245133

# 项目搭建及启动
- start.spring.io
  - 选择 spring web 依赖

## 启动方式
### maven
```xml
<!--如项目有此依赖, 则可通过 maven 启动: `mvn spring-boot:run`-->
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

### jar (一般部署时使用)
```bash
# 项目打包
mvn clean package -Dmaven.test.skip=true
# 启动
cd target && java -jar newbee-mall-0.0.1-SNAPSHOT.jar
```

## 项目结构
```
newbee-mall
    ├── src/main/java
         └── ltd.newbee.mall
         		├── common // 存放相关的常量配置及枚举类
         		├── config // 存放 web 配置类
         		├── controller // 存放控制类，包括商城端和后台管理系统中的 controller 类
         		      	├── admin // 存放后台管理系统中的 controller 类
         				├── common // 存放通用的 controller 类
         				└── mall // 存放商城端的 controller 类
         		├── dao // 存放数据层接口
         		├── entity // 存放实体类
         		├── interceptor // 存放拦截器
         		├── service // 存放业务层方法
         		├── util // 存放工具类
         		└── NewBeeMallApplication // Spring Boot 项目主类
    ├── src/main/resources
         ├── mapper // 存放 MyBatis 的通用 Mapper文件
         ├── static // 默认的静态资源文件目录
               	├── admin // 存放后台管理系统端的静态资源文件目录
         		└── mall // 存放商城端的静态资源文件目录
         ├── templates
                ├── admin // 存放后台管理系统端页面的模板引擎目录
         		└── mall // 存放商城端页面的模板引擎目录
         ├── application.properties // 项目配置文件
         ├── newbee_mall_schema.sql // 项目所需的 SQL 文件 
         └── upload.zip // 商品图片
    └── pom.xml // Maven 配置文件
```