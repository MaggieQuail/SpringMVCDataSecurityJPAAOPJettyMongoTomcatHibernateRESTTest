FROM java:8
COPY target/ololo-1.0-SNAPSHOT.jar /ololo/
COPY target/lib/* /ololo/
CMD ["java", "-jar", "/ololo/ololo-1.0-SNAPSHOT.jar"]