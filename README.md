## Criando o arquivo `Dockerfile`
```
FROM tomcat
COPY target/app.war ${CATALINA_HOME}/webapps
```

## Criar uma imagem

`docker build -t ricardojob/pos-aula .`:  
*`-t`: qual a tag que vamos atribuir a essa imagem*  
*`.`: caminho relativo (ou absoluto) para o arquivo Dockerfile*  


## Listar as imagens

`docker image ls`

## Executar o container

`docker run -p 8081:8080 -d --name app ricardojob/pos-aula`:   
*`-p`: o bind entre a porta do host local com a porta do container*  
*`-d`: o container seja executar em background*  
*`--name`: o nome do container*  


## Listar os containers

`docker container ls`

## Parar o container

`docker stop <container_id | container_name>`