#question review
when I start Eureka Client instances and Java processes closing soon.

#Resolution
the app is not a webapp because it doesn't have an embedded container (e.g. Tomcat) on the classpath. Adding one fixed it. 
If you are using Maven, then add this in pom.xml:
```
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
 </dependency>
```

