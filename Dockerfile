FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

USER 1001

CMD ./gradlew build; 

COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080:8080

ENTRYPOINT ["java","-jar","app.jar"]

