FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

USER 1001

CMD ./gradlew build; 

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
