# Section 1: Set up RabbitMQ with Docker
## foreword
This section describes how to install RabbitMQ with Docker.

## prerequisites
* a Computer :computer: 
* :penguin: Linux distribution like Ubuntu
* Installed Docker in last version :whale:

## installation

```plain
sudo docker run -d --hostname vm-client01 --name rabbit-dev \
  -p 5672:5672 -p 15672:15672 -p 25672:25672 \ 
  -e RABBITMQ_DEFAULT_USER=admin \ 
  -e RABBITMQ_DEFAULT_PASS=admintest \ 
  rabbitmq:3.7.12-management
```


## list of references
1. [RabbitMQ Docker Official Images](https://hub.docker.com/_/rabbitmq)
