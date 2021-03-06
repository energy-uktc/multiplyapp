
FROM maven:3.6.3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/multiply-app-0.0.1-SNAPSHOT.jar /usr/local/lib/multiply-app.jar
EXPOSE 8080
LABEL version="1.2"
ENTRYPOINT ["java","-jar","/usr/local/lib/multiply-app.jar"]
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar multiply-app.jar
