# Section 3: Send messages to users and topics
## foreword
Here I took an example from chapter 2 of the book 'RabbitMQ Essentials' and extended or adapted it accordingly. I like the example in this way, because several users are created as Java threads and get a queue for their messages. So every user gets a message sent directly. Via topics the users are created according to their interests. If an area of interest receives a message, the registered users also receive a message. A further advantage of this example is that as soon as the RabbitMQ is available again after a failure, the consumers establish a new connection.
Under [2] I found a blog that explains the functionality of exchange, routing keys and bindings very well.

## prerequisites
* Installation of section 1 completed.
* User "userdev" is required here.
* Java skills
* IDE like Intellij 

## Start application
The application is started with the Main class from the package 'at.plate.lab.rabbitmq'.

## Stop application
The application ends with enter. There is a note at startup.


## list of references
1. [source code from book 'RabbitMQ Essentials - Chapter 2'](https://github.com/tolyo/rabbitmq-essentials/tree/master/ch02)
2. [Part 4: RabbitMQ Exchanges, routing keys and bindings](https://www.cloudamqp.com/blog/2015-09-03-part4-rabbitmq-for-beginners-exchanges-routing-keys-bindings.html)
