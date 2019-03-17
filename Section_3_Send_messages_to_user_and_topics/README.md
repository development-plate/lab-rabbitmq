# Section 3: Send messages to users and topics
## foreword
Here I took an example from chapter 2 of the book 'RabbitMQ Essentials' and extended or adapted it accordingly. I like the example in this way, because several users are created as Java threads and get a queue for their messages. So every user gets a message sent directly. Via topics the users are created according to their interests. If an area of interest receives a message, the registered users also receive a message. Another advantage of this example is that as soon as the RabbitMQ is no longer available, the consumer establishes a new connection.

## prerequisites
* Installation of section 1 completed.
* User "userdev" is required here.
* Java skills
* IDE like Intellij 

## Start producer app
In the first step we start the ProducerApp and send a "Hello World! Message to the queue.

## View message in queue
Log in as admin in RabbitMQ Management Console and open the "Queues" tab. Here you can see a message based on the diagram.

## Start consumer app
In the last step we start the ConsumerApp and look at the output. "Hello World" should be shown here. The RabbitMQ management console should also show no message.

## list of references
1. [source code from book 'RabbitMQ Essentials - Chapter 2'](https://github.com/tolyo/rabbitmq-essentials/tree/master/ch02)
