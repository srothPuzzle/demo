FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

USER root

CMD ./gradlew build; \
    cp build/libs/*.jar /home/jboss; 

USER 1001

CMD java -jar /home/jboss/app.jar
