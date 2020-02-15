
FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mvn clean package
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/multiply-app-0.0.1-SNAPSHOT.jar multiply-app.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar multiply-app.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar multiply-app.jar
