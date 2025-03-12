
This is a working sample application with logback in jakarta ee 

```
./mvnw clean package 
```
Once the runtime starts, you can access the project at [http://localhost:8080/jakartaee-hello-world](http://localhost:8080/jakartaee-hello-world).
```
./mvnw clean package
docker build -t jakartaee-hello-world:v1 .
```

You can then run the Docker image by executing:

```
docker run -it --rm -p 8080:8080 jakartaee-hello-world:v1
```

Once the runtime starts, you can access the project at [http://localhost:8080/jakartaee-hello-world](http://localhost:8080/jakartaee-hello-world).
