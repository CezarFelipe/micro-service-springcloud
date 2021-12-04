<img src="https://github.com/CezarFelipe/micro-service-springcloud/blob/main/banner-spring-cloud.png"/>

## Título
---
<h1 align="justify"> Microserviços utilizando ecossistema spring cloud</h1>

## Descrição
---
<p align="justify"> A aplicação foi desenvolvida utilizando a arquitetura de microserviços com o framework spring cloud </p>

<img src="https://img.shields.io/static/v1?label=spring&message=framework&color=blue&style=for-the-badge&logo=spring"/>

## Status do Projeto
---
> Status do Projeto: Concluido :heavy_check_mark:

## Tabela de Conteúdos
---
 <!--ts-->
   * [Titulo](#título)
   * [Descrição](#descrição)
   * [Status do Projeto](#status-do-projeto)
   * [Features](#features)
   * [Demonstração da Aplicação](#demonstração-da-aplicação)
   * [Pré-requisitos](#pré-requisitos)
   * [Tecnologias utilizadas](#tecnologias-utilizadas)
   * [Autor](#autor)
   * [Licença](#licença)
<!--te-->
 

## Features
---
- [X] SERVICE REGISTRY / DISCOVERY
- [X] CIRCUIT BREAK
- [X] CONFIG SERVICE
- [X] API GATEWAY
- [X] CONTAINER DOCKER


## Demonstração da Aplicação
---
<img src="https://github.com/CezarFelipe/micro-service-springcloud/blob/main/diagrama1.PNG"/>
<img src="https://github.com/CezarFelipe/micro-service-springcloud/blob/main/diagrama2.PNG"/>


## Pré-requisitos
---
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[DOCKER](https://docs.docker.com/desktop/windows/install/).


## 🎲 Rodando containers Docker

### Clone este repositório
```bash
$ git clone https://github.com/CezarFelipe/micro-service-springcloud.git
```
### Criar rede docker para sistema hr
```
docker network create hr-net
```
### Criando banco de dados: Postgresql no Docker
```
docker pull postgres:12-alpine

docker run -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres:12-alpine

docker run -p 5432:5432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres:12-alpine
```
### hr-config-server
```
docker build -t hr-config-server:v1 .

docker run -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=CezarFelipe -e GITHUB_PASS= hr-config-server:v1
```
### hr-eureka-server
```
docker build -t hr-eureka-server:v1 .

docker run -p 8761:8761 --name hr-eureka-server --network hr-net hr-eureka-server:v1
```
### hr-worker
```
docker build -t hr-worker:v1 .

docker run -P --network hr-net hr-worker:v1
```
### hr-user
```
docker build -t hr-user:v1 .

docker run -P --network hr-net hr-user:v1
```

### hr-payroll
```
docker build -t hr-payroll:v1 .

docker run -P --network hr-net hr-payroll:v1
```

### hr-oauth
```
docker build -t hr-oauth:v1 .

docker run -P --network hr-net hr-oauth:v1
```

### hr-api-gateway-zuul
```
docker build -t hr-api-gateway-zuul:v1 .

docker run -p 8765:8765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuul:v1
```
## 🎲 Testando os micro serviços

### [Documentação postman](https://documenter.getpostman.com/view/9570826/UVJhDa1D)
### Collection / Environment
Importe a collection e a variável de ambiente disposta nesse repositório para o postman ou outro software do genero, micro-service-springcloud.postman_collection, ms-springcloud-env.postman_environment.

## Tecnologias utilizadas
---
As seguintes ferramentas foram usadas na construção do projeto:

- [JDK11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [STS](https://spring.io/tools)
- [DOCKER](https://docs.docker.com/desktop/windows/install/)
- [POSTMAN](https://www.postman.com/)
- [POSTGRESQL](https://www.postgresql.org/download/)

## **Autor**
---

<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/29206101?v=4" width="100px;" alt=""/>

Feito com ❤️ por Cézar Felipe 👋🏽 Entre em contato!

 <a href="https://www.instagram.com/cezar_felpis/" target="_blank"><img src="https://img.shields.io/badge/-Instagram-%23E4405F?style=for-the-badge&logo=instagram&logoColor=white" target="_blank"></a>
  <a href = "mailto:cezarfelipe2008@outlook.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href="https://www.linkedin.com/in/cezarfelipedasilva/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
    
## Licença
<a href="https://github.com/CezarFelipe/micro-service-springcloud/blob/main/LICENSE" target="_blank"><img src="https://img.shields.io/badge/license-MIT-green" target="_blank"></a>


