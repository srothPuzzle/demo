FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

WORKDIR /tmp/src

COPY . /tmp/src

RUN if [ ! -s /tmp/src/app.jar ]; then \
	./gradlew clean build; \
	cp build/libs/*.jar /home/jboss; \
    else \
	cp /tmp/src/*.jar /home/jboss;\
    fi; \
    rm -rf /tmp/src

USER 1001

EXPOSE 8080

CMD java -jar /home/jboss/app.jar
