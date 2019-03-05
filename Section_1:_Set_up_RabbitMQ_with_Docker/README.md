# Section 1: Set up RabbitMQ with Docker
## foreword
This section describes how to install RabbitMQ with Docker.

## prerequisites
* a Computer :computer: 
* :penguin: Linux distribution like Ubuntu
* Installed Docker in last version :whale:

## installation
For the installation we get an official image of RabbitMQ from the Dockerhub. Further information and instructions can be found under [1]. This form of installation is sufficient for this workshop.

This command is used to install the Docker Images and start the container:
```plain
sudo docker run -d --hostname vm-client01 --name rabbit-dev \
  -p 5672:5672 -p 15672:15672 -p 25672:25672 \ 
  -e RABBITMQ_DEFAULT_USER=admin \ 
  -e RABBITMQ_DEFAULT_PASS=admintest \ 
  rabbitmq:3.7.12-management
```
Note: We give the container a port mapping to 5672, 15672 and 25672, the default user "admin" and the password "admintest".

## execution of the container 
With the following command we can see if the container has been started. It only shows the status and we remember the container ID.
```plain
sudo docker ps -a
```

We see the log output with this command.
```plain
sudo docker logs d9bbd05aa0c4
```
log output:
```plain
...
2019-03-04 21:26:21.713 [info] <0.221.0> Setting up a table for per-vhost connection counting on this node: 'tracked_connection_per_vhost_on_node_rabbit@vm-client01'
2019-03-04 21:26:21.759 [info] <0.549.0> Management plugin: HTTP (non-TLS) listener started on port 15672
2019-03-04 21:26:21.759 [info] <0.655.0> Statistics database started.
 completed with 3 plugins.
2019-03-04 21:26:21.904 [info] <0.8.0> Server startup complete; 3 plugins started.
 * rabbitmq_management
 * rabbitmq_web_dispatch
 * rabbitmq_management_agent
```

Startup is completed and you can visit your local [RabbitMQ Management](http://localhost:15672) installation. Your login is admin with passwort admintest.

## list of references
1. [RabbitMQ Docker Official Images](https://hub.docker.com/_/rabbitmq)
