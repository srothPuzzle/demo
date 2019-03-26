FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

USER 1001

CMD ./gradlew build; \
    cp build/libs/*.jar /home/jboss; 

CMD java -jar /home/jboss/app.jar
