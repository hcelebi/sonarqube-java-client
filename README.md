Add Dependency and configure create instance

```xml
<dependency>
    <groupId>io.github.hcelebi</groupId>
    <artifactId>sonarqube-java-client</artifactId>
    <version>1</version>
</dependency>
```

```java
SonarqubeRestClient client = new SonarqubeRestClient("baseUri", "token", HttpClient.newHttpClient());
```
