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

## Executar comandos no container  
Para executarmos comandos necessitamos de executar o comando `docker exec -it <container_id | container_name> <command>`. 
Por exemplo, para termos acesso ao container do banco que configuramos podemos fazer:

`docker exec -it banco /bin/bash`:  
*`-it`: para termos acesso iterativo ao TTY*  
*`banco`: o nome do container que desejamos seja executar determinado comando*  
*`/bin/bash`: o comando que vamos executar no container*  

Após esses passos, teremos acesso ao terminal do container. Podemos acessar o _database_ que definimos no arquivo `Dockerfile` que configura o banco de dados, neste exemplo `pos-cliente`.

`psql -U postgres pos-cliente`:  
*`-U`: usuário configurado*  
*`pos-cliente`: o _database_ que desejamos acessar* 

Alguns comando úteis no `psql`:  
*`\dt`: lista as tabelas do _database_*    
*`select * from pessoa;`: seleciona todos as pessoas*  
*`INSERT INTO pessoa(nome, cpf) VALUES ('Kiko','123.132.121-31');`: insere uma nova pessoa*    
*`\q`: sair do _database_*  