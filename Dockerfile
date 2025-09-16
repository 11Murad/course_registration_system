FROM eclipse-temurin:23-jdk-alpine
COPY build/libs/the_system_of_student_information-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "/app/the_system_of_student_information-0.0.1-SNAPSHOT.jar"]


