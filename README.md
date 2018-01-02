# springboot web app & docker deploy homework0

## 作业要求
  用spring boot开发一个Web系统（有数据库，Redis等至少2个中间件），然后打包镜像:all-in-one与独立的镜像，Docker化部署，要求程序的配置文件和数据库存车都用Volume映射，作业提交到自己的github仓库，完整的说明文件用md格式编写

## 涉及知识点
 * springboot
 * mysql
 * mybatis
 * lombok
 * redis(session)
 * docker
 * kubernetes
 * jquery + bootstrap + scss + (angularjs & typescript)

## 目录结构
 * ___ src/main
   |__ java
     |__ xqy.msa.springbootweb
       |__ App.java
       |__ admin
          |__ domain
          |__ service
          |__ web
       |__ auth
       |__ edu
       |__ portal
       |__ project
       |__ util
   |__ resources
     |__ static
        |__ assets/
        |__ admin
        |__ auth
        |__ edu
        |__ my
        |__ project
        |__ index.html
     |__ application.yml
     |__ lm.xml
 * ___ doc/**
 * ___ Dockfile

## 配置运行环境
### 配置代码生成: mybatis-generator-lombok-plugin
    下载插件代码
    ```
    git clone https://github.com/softwareloop/mybatis-generator-lombok-plugin.git
    ```
    编译
    ```
    cd mybatis-generator-lombok-plugin
    mvn clean install
    ```
    本地安装jar包到maven仓库
    ```
    mvn install:install-file -DgroupId=com.softwareloop -DartifactId=mybatis-generator-lombok-plugin -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dfile=/Users/xqy/projects/mybatis-generator-lombok-plugin/target/mybatis-generator-lombok-plugin-1.0-SNAPSHOT.jar
    ```

### 配置scss自动编译
    终端窗口 cd 进入项目文件夹，执行下面命令
    ```
    mvn com.github.warmuuh:libsass-maven-plugin:0.2.8-libsass_3.4.4:watch
    ```

### 配置mysql
参考`src/main/resources/db.sql`


#### 连接宿主机
```
    GRANT ALL ON imking.* to root@'本机IP地址' INDENTIFIED BY '123456';
```
```application.yml
spring:
  application:
    name: springbootwebapp
  datasource:
    url: jdbc:mysql://本机IP地址:3306/imking?useSSL=false&useUnicode=true&characterEncoding=UTF8
```

#### docker化mysql
```

```
```application.yml
spring:
  application:
    name: springbootwebapp
  datasource:
    url: jdbc:mysql://容器IP地址:3306/imking?useSSL=false&useUnicode=true&characterEncoding=UTF8
```


### Maven build
```
    ./mvnw package && java -Djava.security.egd=file:/dev/./urandom -jar target/springbootweb-0.0.1-SNAPSHOT.jar
```

### Docker build
#### 先创建maven wrapper
    ```
        mvn -N io.takari:maven:wrapper
    ```
    或者
    ```
        ./mvnw io.takari:maven:wrapper -Dmaven=3.3.9
    ```
#### 打镜像
    ```
        ./mvnw install dockerfile:build
    ```
### Docker方式运行
    ```
        docker run -p 8080:8080 -t xqy/springbootweb:0.0.1-SNAPSHOT
    ```
