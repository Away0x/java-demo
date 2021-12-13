# Spring boot 配置数据源
- 因为引入了 actuator 依赖
  - http://localhost:8080/actuator/health 健康监控
  - http://localhost:8080/actuator/beans 查看项目的 bean
    - 需要配置 management.endpoints.web.exposure.include=*

## Spring 配置数据源
- 数据源相关 (可选)
  - DataSource (根据选择的连接池实现决定)
- 事务相关 (可选)
  - PlatformTransactionManager (DataSourceTransactionManager)
  - TransactionTemplate
- 操作相关 (可选)
  - JdbcTemplate

## Spring Boot 配置数据源做了哪些事情
> 只有符合条件时才进行配置

1. 通过 DataSourceAutoConfiguration 配置 DataSource
2. 通过 DataSourceTransactionManagerAutoConfiguration 配置 DataSourceTransactionManager
3. 通过 JdbcTemplateAutoConfiguration 配置 JdbcTemplate

## 数据源相关配置属性
- 通用:
  - spring.datasource.url=jdbc:mysql://localhost/test
  - spring.datasource.username=dbuser
  - spring.datasource.password=dbpass
  - spring.datasource.driver-class-name=com.mysql.jdbc.Driver（可选，SpringBoot 会根据 url 识别数据库类型, 选择数据库驱动）
- 初始化内嵌数据库
  - spring.datasource.initialization-mode=embedded|always|never
  - spring.datasource.schema与spring.datasource.data 确定初始化SQL文件
  - spring.datasource.platform=hsqldb|h2|oracle|mysql|postgresql（与前者对应）

## 连接池 HikariCP
> https://github.com/brettwooldridge/HikariCP

1. 字节码级别优化（很多方法通过 JavaAssist 生成）
2. ⼤量小优化
   - 用 FastStatementList 代替 ArrayList
   - 无锁集合 ConcurrentBag
   - 代理理类的优化（如用 invokestatic 代替了 invokevirtual）

## 连接池 Druid
> https://github.com/alibaba/druid/wiki/Druid%E8%BF%9E%E6%8E%A5%E6%B1%A0%E4%BB%8B%E7%BB%8D

- 详细的监控
- ExceptionSorter，针对主流数据库的返回码都有⽀支持
- SQL 防注⼊入
- 内置加密配置
- 众多扩展点，⽅便进⾏行定制

### 数据源配置
1. 直接配置 DruidDataSource
2. 通过 druid-spring-boot-starter 配置 spring.datasource.druid.*

```
## Filter 配置
spring.datasource.druid.filters=conn,config,stat,slf4j

## 密码加密 
spring.datasource.password=<加密密码>
spring.datasource.druid.connection-properties=config.decrypt=true;config.decrypt.key=${public-key}
spring.datasource.druid.filter.config.enabled=true

## SQL 防注⼊
spring.datasource.druid.ﬁlter.wall.enabled=true
spring.datasource.druid.ﬁlter.wall.db-type=h2
spring.datasource.druid.ﬁlter.wall.conﬁg.delete-allow=false
spring.datasource.druid.ﬁlter.wall.conﬁg.drop-table-allow=false
```

### Druid Filter
- 用于定制连接池操作的各种环节
- 可以继承 FilterEventAdapter 以便方便地实现 Filter
- 修改 META-INF/druid-filter.properties 增加 Filter 配置