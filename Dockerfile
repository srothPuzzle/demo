FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

SHELL ["/usr/bin/scl", "enable"]

WORKDIR /tmp/src

COPY . /tmp/src

RUN ./gradlew clean build; \
	cp build/libs/*.jar /home/jboss;

USER 1001

EXPOSE 8080

CMD java -jar /home/jboss/app.jar
