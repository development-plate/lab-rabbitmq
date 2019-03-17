# Section 2: Testing RabbitMQ installation
## foreword
In this section we will perform a simple transfer from producer to consumer. We'll go into the details later.

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
