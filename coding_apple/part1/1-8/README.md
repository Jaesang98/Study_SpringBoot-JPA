## 💡 part1-8 서버에서 Database 연결 & JPA 설치

### 🔹 DB연결

```bash
# gradle
runtimeOnly 'com.mysql:mysql-connector-j'  # mysql접속을 도와줌
implementation 'org.springframework.boot:spring-boot-starter-data-jpa' # ORM라이브러리
```

```bash
# application properties
spring.datasource.url=jdbc:mysql://localhost:3306/shop
spring.datasource.username=root
spring.datasource.password=ska980630@
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.hibernate.ddl-auto=update
```
