# Используем официальный образ Gradle для сборки
FROM gradle:7.2.0-jdk17 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
# Даем права на выполнение Gradle Wrapper
RUN chmod +x gradlew
RUN gradle build --no-daemon

# Используем официальный образ OpenJDK для выполнения
FROM openjdk:17-jdk-slim
COPY --from=build /home/gradle/project/build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
