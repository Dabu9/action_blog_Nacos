# 基础镜像
FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8602
ADD target/action_picture-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","/app.jar","--spring.profiles.active=prod"]
