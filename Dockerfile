FROM amazoncorretto:11
COPY target/spring-skeleton-0.4.jar spring-skeleton-0.4.jar
ENTRYPOINT ["java", "-jar", "/spring-skeleton-0.4.jar"]