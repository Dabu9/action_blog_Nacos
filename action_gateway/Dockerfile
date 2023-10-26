FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8607
ADD target/action_gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","/app.jar","--spring.profiles.active=prod"]
