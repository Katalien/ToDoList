FROM openjdk:8-jdk-alpine

ENV JAR_NAME todo_list_project-0.0.1-SNAPSHOT.jar
ENV WD /todo_list_project/
RUN mkdir -p "$WD"
WORKDIR $WD
COPY ./target $WD

ENTRYPOINT java -Xms64m -Xmx64m -jar -Dspring.profiles.active=prod $JAR_NAME
