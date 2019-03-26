# Simple s2i spring boot demonstration

create new app with: 
```
oc new-app --name=backend registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~https://github.com/snd1/demo.git
```

then trigger build with:
```
oc start-build bc/demo-backend -F --from-file build/libs/demo-0.0.1-SNAPSHOT.jar
``` 

To be continued..
