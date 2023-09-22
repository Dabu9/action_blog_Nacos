FROM registry.cn-chengdu.aliyuncs.com/actionblog/jdk:8-alpine
MAINTAINER jsl damaha666@163.com
VOLUME /tmp
ADD action_admin-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","/app.jar"]
