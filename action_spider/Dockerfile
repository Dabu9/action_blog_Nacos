# 基础镜像
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/action_spider-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","/app.jar","--spring.profiles.active=prod"]
