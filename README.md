Source: http://www.dropwizard.io/1.0.2/docs/getting-started.html

Steps to configure

1: Install maven of version 3

2: Intall Java 1.8

3: clone project to your local, git clone https://gitlab.com/kgajay/crm-sync.git

4: go to crm-sync

5: download dependency => mvn clean package ( this will install all external lib's)

6: start server => java -jar target/crm-sync-1.0-SNAPSHOT.jar src/main/resources/sync-app.yml (this will start server on http://127.0.0.1:8080)

7: To check run below command

    A)  curl -X GET http://127.0.0.1:8080/v1/sample
    
    B)  curl -X GET http://127.0.0.1:8080/admin/ping
    
    C)  curl -X GET http://127.0.0.1:8080/admin/healthcheck
    
