FROM eclipse-temurin:17.0.7_7-jdk as builder

WORKDIR application

ADD ./target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17.0.7_7-jdk
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./


EXPOSE 8089

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]


