FROM openjdk:17
EXPOSE 8080
COPY target/springboot-demo.jar springboot-demo.jar
CMD [ "java","-jar","springboot-demo.jar" ]