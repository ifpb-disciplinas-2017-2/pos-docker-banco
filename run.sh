mvn clean package
docker build -t ricardojob/pos-aula:3 .
docker run -p 8082:8080 -d --name app ricardojob/pos-aula:3