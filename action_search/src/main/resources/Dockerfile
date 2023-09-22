FROM registry.cn-chengdu.aliyuncs.com/actionblog/jdk:8-alpine
VOLUME /tmp
ADD action_search-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","/app.jar"]
