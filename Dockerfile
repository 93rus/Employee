# Используем официальный образ Gradle для сборки
FROM gradle:7.2.0-jdk17 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
# Даем права на выполнение Gradle Wrapper
RUN chmod +x gradlew
# Сборка проекта с отключением мониторинга VFS
RUN ./gradlew build -Dorg.gradle.vfs.watch=false

# Создаем финальный образ
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]