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

## How is the process to be understood on the basis of the console output?
  
Direct message  
Line 5: User 3 logs in.  
Line 6: User 3 sends a message to user 7.  
Line 19: User 7 logs in.  
Line 20: User receives message from user 3.  
  
Message about topics:  
Line 8: User 2 sends a message to the topic "science".  
Lines 9 to 11: Users 1,3 and 4 are interested in "science" and receive the message.  
  
This little game repeats itself in the further processes.  
  
```
    1. Starting the application with 12 simulated users
    2. User login: 1
    3. User 1 send to economy: {"time_sent":1552887780523,"sender_id":1,"topic":"economy","subject":"Something about economy","content":"Great content about economy"}
    4. User login: 2
    5. User login: 3
    6. User 3 send to 7: {"time_sent":1552887782540,"sender_id":3,"addressee_id":7,"subject":"Greetings!","content":"Hello from: 3"}
    7. User login: 4
    8. User 2 send to science: {"time_sent":1552887783528,"sender_id":2,"topic":"science","subject":"Something about science","content":"Great content about science"}
    9. User 4 received: {"time_sent":1552887783528,"sender_id":2,"topic":"science","subject":"Something about science","content":"Great content about science"}
    10. User 3 received: {"time_sent":1552887783528,"sender_id":2,"topic":"science","subject":"Something about science","content":"Great content about science"}
    11. User 1 received: {"time_sent":1552887783528,"sender_id":2,"topic":"science","subject":"Something about science","content":"Great content about science"}
    12. User 1 send to 8: {"time_sent":1552887783705,"sender_id":1,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 1"}
    13. User login: 5
    14. User login: 6
    15. User 6 send to 4: {"time_sent":1552887785543,"sender_id":6,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 6"}
    16. User 4 received: {"time_sent":1552887785543,"sender_id":6,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 6"}
    17. User 1 send to 11: {"time_sent":1552887785769,"sender_id":1,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 1"}
    18. User 1 send to economy: {"time_sent":1552887785795,"sender_id":1,"topic":"economy","subject":"Something about economy","content":"Great content about economy"}
    19. User login: 7
    20. User 7 received: {"time_sent":1552887782540,"sender_id":3,"addressee_id":7,"subject":"Greetings!","content":"Hello from: 3"}
    21. User 5 received: {"time_sent":1552887785795,"sender_id":1,"topic":"economy","subject":"Something about economy","content":"Great content about economy"}
    22. User 2 received: {"time_sent":1552887785795,"sender_id":1,"topic":"economy","subject":"Something about economy","content":"Great content about economy"}
    23. User 5 send to 7: {"time_sent":1552887786555,"sender_id":5,"addressee_id":7,"subject":"Greetings!","content":"Hello from: 5"}
    24. User 1 send to 8: {"time_sent":1552887786809,"sender_id":1,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 1"}
    25. User login: 8
    26. User 8 received: {"time_sent":1552887783705,"sender_id":1,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 1"}
    27. User 8 received: {"time_sent":1552887786809,"sender_id":1,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 1"}
    28. User 7 received: {"time_sent":1552887786555,"sender_id":5,"addressee_id":7,"subject":"Greetings!","content":"Hello from: 5"}
    29. User 2 send to 1: {"time_sent":1552887787573,"sender_id":2,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 2"}
    30. User 3 send to fashion: {"time_sent":1552887787589,"sender_id":3,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    31. User 1 received: {"time_sent":1552887787573,"sender_id":2,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 2"}
    32. User login: 9
    33. User 7 received: {"time_sent":1552887787589,"sender_id":3,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    34. User 6 received: {"time_sent":1552887787589,"sender_id":3,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    35. User 5 received: {"time_sent":1552887787589,"sender_id":3,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    36. User 4 send to 1: {"time_sent":1552887788582,"sender_id":4,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 4"}
    37. User 3 send to science: {"time_sent":1552887788599,"sender_id":3,"topic":"science","subject":"Something about science","content":"Great content about science"}
    38. User 1 received: {"time_sent":1552887788582,"sender_id":4,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 4"}
    39. User 1 received: {"time_sent":1552887788599,"sender_id":3,"topic":"science","subject":"Something about science","content":"Great content about science"}
    40. User login: 10
    41. User 9 received: {"time_sent":1552887788599,"sender_id":3,"topic":"science","subject":"Something about science","content":"Great content about science"}
    42. User 9 send to science: {"time_sent":1552887789539,"sender_id":9,"topic":"science","subject":"Something about science","content":"Great content about science"}
    43. User 7 send to 11: {"time_sent":1552887789549,"sender_id":7,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 7"}
    44. User 6 received: {"time_sent":1552887788599,"sender_id":3,"topic":"science","subject":"Something about science","content":"Great content about science"}
    45. User 6 received: {"time_sent":1552887789539,"sender_id":9,"topic":"science","subject":"Something about science","content":"Great content about science"}
    46. User 4 received: {"time_sent":1552887788599,"sender_id":3,"topic":"science","subject":"Something about science","content":"Great content about science"}
    47. User 4 received: {"time_sent":1552887789539,"sender_id":9,"topic":"science","subject":"Something about science","content":"Great content about science"}
    48. User 3 received: {"time_sent":1552887788599,"sender_id":3,"topic":"science","subject":"Something about science","content":"Great content about science"}
    49. User 3 received: {"time_sent":1552887789539,"sender_id":9,"topic":"science","subject":"Something about science","content":"Great content about science"}
    50. User 1 received: {"time_sent":1552887789539,"sender_id":9,"topic":"science","subject":"Something about science","content":"Great content about science"}
    51. User login: 11
    52. User 11 received: {"time_sent":1552887785769,"sender_id":1,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 1"}
    53. User 11 received: {"time_sent":1552887789549,"sender_id":7,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 7"}
    54. User 9 received: {"time_sent":1552887789539,"sender_id":9,"topic":"science","subject":"Something about science","content":"Great content about science"}
    55. User 10 send to 11: {"time_sent":1552887790556,"sender_id":10,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 10"}
    56. User login: 12
    57. User 11 received: {"time_sent":1552887790556,"sender_id":10,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 10"}
    58. User 11 send to 2: {"time_sent":1552887791569,"sender_id":11,"addressee_id":2,"subject":"Greetings!","content":"Hello from: 11"}
    59. User 9 send to 2: {"time_sent":1552887791582,"sender_id":9,"addressee_id":2,"subject":"Greetings!","content":"Hello from: 9"}
    60. User 10 send to 9: {"time_sent":1552887791585,"sender_id":10,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 10"}
    61. User 2 received: {"time_sent":1552887791569,"sender_id":11,"addressee_id":2,"subject":"Greetings!","content":"Hello from: 11"}
    62. User 2 received: {"time_sent":1552887791582,"sender_id":9,"addressee_id":2,"subject":"Greetings!","content":"Hello from: 9"}
    63. User 2 send to 3: {"time_sent":1552887791607,"sender_id":2,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 2"}
    64. User 3 received: {"time_sent":1552887791607,"sender_id":2,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 2"}
    65. Running, strike ENTER to stop!
    66. User 12 send to 9: {"time_sent":1552887792550,"sender_id":12,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 12"}
    67. User 8 send to 1: {"time_sent":1552887792576,"sender_id":8,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 8"}
    68. User 9 received: {"time_sent":1552887791585,"sender_id":10,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 10"}
    69. User 9 received: {"time_sent":1552887792550,"sender_id":12,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 12"}
    70. User 1 received: {"time_sent":1552887792576,"sender_id":8,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 8"}
    71. User 12 send to 1: {"time_sent":1552887793575,"sender_id":12,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 12"}
    72. User 8 send to 3: {"time_sent":1552887793610,"sender_id":8,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 8"}
    73. User 2 send to 3: {"time_sent":1552887793621,"sender_id":2,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 2"}
    74. User 3 received: {"time_sent":1552887793610,"sender_id":8,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 8"}
    75. User 3 received: {"time_sent":1552887793621,"sender_id":2,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 2"}
    76. User 1 received: {"time_sent":1552887793575,"sender_id":12,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 12"}
    77. User 11 send to 3: {"time_sent":1552887794636,"sender_id":11,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 11"}
    78. User 9 send to 1: {"time_sent":1552887794639,"sender_id":9,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 9"}
    79. User 5 send to 8: {"time_sent":1552887794643,"sender_id":5,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 5"}
    80. User 1 received: {"time_sent":1552887794639,"sender_id":9,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 9"}
    81. User 8 received: {"time_sent":1552887794643,"sender_id":5,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 5"}
    82. User 3 received: {"time_sent":1552887794636,"sender_id":11,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 11"}
    83. User 10 send to 4: {"time_sent":1552887795669,"sender_id":10,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 10"}
    84. User 11 send to 12: {"time_sent":1552887795673,"sender_id":11,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 11"}
    85. User 4 send to 12: {"time_sent":1552887795665,"sender_id":4,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 4"}
    86. User 12 received: {"time_sent":1552887795673,"sender_id":11,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 11"}
    87. User 12 received: {"time_sent":1552887795665,"sender_id":4,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 4"}
    88. User 4 received: {"time_sent":1552887795669,"sender_id":10,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 10"}
    89. User 7 send to 4: {"time_sent":1552887796702,"sender_id":7,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 7"}
    90. User 7 send to fashion: {"time_sent":1552887796710,"sender_id":7,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    91. User 12 received: {"time_sent":1552887796710,"sender_id":7,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    92. User 12 send to 10: {"time_sent":1552887797673,"sender_id":12,"addressee_id":10,"subject":"Greetings!","content":"Hello from: 12"}
    93. User 6 received: {"time_sent":1552887796710,"sender_id":7,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    94. User 5 received: {"time_sent":1552887796710,"sender_id":7,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    95. User 4 received: {"time_sent":1552887796702,"sender_id":7,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 7"}
    96. User 7 received: {"time_sent":1552887796710,"sender_id":7,"topic":"fashion","subject":"Something about fashion","content":"Great content about fashion"}
    97. User 10 received: {"time_sent":1552887797673,"sender_id":12,"addressee_id":10,"subject":"Greetings!","content":"Hello from: 12"}
    98. User 5 send to 9: {"time_sent":1552887797727,"sender_id":5,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 5"}
    99. User 2 send to 12: {"time_sent":1552887797722,"sender_id":2,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 2"}
    100. User 10 send to 2: {"time_sent":1552887797732,"sender_id":10,"addressee_id":2,"subject":"Greetings!","content":"Hello from: 10"}
    101. User 12 received: {"time_sent":1552887797722,"sender_id":2,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 2"}
    102. User 12 send to 8: {"time_sent":1552887798703,"sender_id":12,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 12"}
    103. User 9 received: {"time_sent":1552887797727,"sender_id":5,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 5"}
    104. User 8 received: {"time_sent":1552887798703,"sender_id":12,"addressee_id":8,"subject":"Greetings!","content":"Hello from: 12"}
    105. User 7 send to 1: {"time_sent":1552887798735,"sender_id":7,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 7"}
    106. User 2 received: {"time_sent":1552887797732,"sender_id":10,"addressee_id":2,"subject":"Greetings!","content":"Hello from: 10"}
    107. User 2 send to 12: {"time_sent":1552887798745,"sender_id":2,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 2"}
    108. User 2 send to sports: {"time_sent":1552887798750,"sender_id":2,"topic":"sports","subject":"Something about sports","content":"Great content about sports"}
    109. User 1 received: {"time_sent":1552887798735,"sender_id":7,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 7"}
    110. User 12 received: {"time_sent":1552887798745,"sender_id":2,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 2"}
    111. User 12 send to 6: {"time_sent":1552887799715,"sender_id":12,"addressee_id":6,"subject":"Greetings!","content":"Hello from: 12"}
    112. User 3 received: {"time_sent":1552887798750,"sender_id":2,"topic":"sports","subject":"Something about sports","content":"Great content about sports"}
    113. User 6 received: {"time_sent":1552887799715,"sender_id":12,"addressee_id":6,"subject":"Greetings!","content":"Hello from: 12"}
    114. User 11 received: {"time_sent":1552887798750,"sender_id":2,"topic":"sports","subject":"Something about sports","content":"Great content about sports"}
    115. User 11 send to 5: {"time_sent":1552887799742,"sender_id":11,"addressee_id":5,"subject":"Greetings!","content":"Hello from: 11"}
    116. User 7 received: {"time_sent":1552887798750,"sender_id":2,"topic":"sports","subject":"Something about sports","content":"Great content about sports"}
    117. User 10 received: {"time_sent":1552887798750,"sender_id":2,"topic":"sports","subject":"Something about sports","content":"Great content about sports"}
    118. User 10 send to 12: {"time_sent":1552887799756,"sender_id":10,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 10"}
    119. User 2 send to 11: {"time_sent":1552887799758,"sender_id":2,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 2"}
    120. User 1 send to science: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    121. User 12 received: {"time_sent":1552887799756,"sender_id":10,"addressee_id":12,"subject":"Greetings!","content":"Hello from: 10"}
    122. User 12 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    123. User 6 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    124. User 9 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    125. User 3 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    126. User 4 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    127. User 5 received: {"time_sent":1552887799742,"sender_id":11,"addressee_id":5,"subject":"Greetings!","content":"Hello from: 11"}
    128. User 11 received: {"time_sent":1552887799758,"sender_id":2,"addressee_id":11,"subject":"Greetings!","content":"Hello from: 2"}
    129. User 11 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    130. User 4 send to 7: {"time_sent":1552887800762,"sender_id":4,"addressee_id":7,"subject":"Greetings!","content":"Hello from: 4"}
    131. User 11 send to 4: {"time_sent":1552887800767,"sender_id":11,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 11"}
    132. User 1 received: {"time_sent":1552887799930,"sender_id":1,"topic":"science","subject":"Something about science","content":"Great content about science"}
    133. User 7 received: {"time_sent":1552887800762,"sender_id":4,"addressee_id":7,"subject":"Greetings!","content":"Hello from: 4"}
    134. User 4 received: {"time_sent":1552887800767,"sender_id":11,"addressee_id":4,"subject":"Greetings!","content":"Hello from: 11"}
    135. User 12 send to 10: {"time_sent":1552887801757,"sender_id":12,"addressee_id":10,"subject":"Greetings!","content":"Hello from: 12"}
    136. User 3 send to 9: {"time_sent":1552887801787,"sender_id":3,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 3"}
    137. User 9 received: {"time_sent":1552887801787,"sender_id":3,"addressee_id":9,"subject":"Greetings!","content":"Hello from: 3"}
    138. User 10 received: {"time_sent":1552887801757,"sender_id":12,"addressee_id":10,"subject":"Greetings!","content":"Hello from: 12"}
    139. User 4 send to 1: {"time_sent":1552887802836,"sender_id":4,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 4"}
    140. User 2 send to 6: {"time_sent":1552887802840,"sender_id":2,"addressee_id":6,"subject":"Greetings!","content":"Hello from: 2"}
    141. User 3 send to 5: {"time_sent":1552887802842,"sender_id":3,"addressee_id":5,"subject":"Greetings!","content":"Hello from: 3"}
    142. User 11 send to 6: {"time_sent":1552887802840,"sender_id":11,"addressee_id":6,"subject":"Greetings!","content":"Hello from: 11"}
    143. User 12 send to 5: {"time_sent":1552887802836,"sender_id":12,"addressee_id":5,"subject":"Greetings!","content":"Hello from: 12"}
    144. User 1 received: {"time_sent":1552887802836,"sender_id":4,"addressee_id":1,"subject":"Greetings!","content":"Hello from: 4"}
    145. User 5 received: {"time_sent":1552887802842,"sender_id":3,"addressee_id":5,"subject":"Greetings!","content":"Hello from: 3"}
    146. User 5 received: {"time_sent":1552887802836,"sender_id":12,"addressee_id":5,"subject":"Greetings!","content":"Hello from: 12"}
    147. User 6 received: {"time_sent":1552887802840,"sender_id":2,"addressee_id":6,"subject":"Greetings!","content":"Hello from: 2"}
    148. User 6 received: {"time_sent":1552887802840,"sender_id":11,"addressee_id":6,"subject":"Greetings!","content":"Hello from: 11"}
    149. User 5 send to politics: {"time_sent":1552887803879,"sender_id":5,"topic":"politics","subject":"Something about politics","content":"Great content about politics"}
    150. User 4 send to 3: {"time_sent":1552887803876,"sender_id":4,"addressee_id":3,"subject":"Greetings!","content":"Hello from: 4"}
    151. 
    152. Shutting down...Bye!
```

## list of references
1. [source code from book 'RabbitMQ Essentials - Chapter 2'](https://github.com/tolyo/rabbitmq-essentials/tree/master/ch02)
2. [Part 4: RabbitMQ Exchanges, routing keys and bindings](https://www.cloudamqp.com/blog/2015-09-03-part4-rabbitmq-for-beginners-exchanges-routing-keys-bindings.html)
