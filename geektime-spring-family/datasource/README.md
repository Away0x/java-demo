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