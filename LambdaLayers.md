# aws-lambda-layers

### Problem Scenario 

![image](https://github.com/user-attachments/assets/2927dc77-5326-4c17-bf35-0033e752cc76)


### Drawbacks

![image](https://github.com/user-attachments/assets/f55b9b5f-c5f0-409e-b75b-3fc1b761695a)


## Solution 

![image](https://github.com/user-attachments/assets/964841e2-22e3-4a54-afdc-e173d13f2f92)


![image](https://github.com/user-attachments/assets/5fa72cda-b79b-4d09-8dae-02de744e2742)


### How to in Java for Local

- Use as Maven provided in pom for local setup

  ![image](https://github.com/user-attachments/assets/826fa9ff-5800-4674-b4ef-487d32d938c8)


 ### Note 
 
- Layer and Lambda Functions needs to be in Same technology
- For Java, Lambda Layer must be uploaded as .zip and not .jar file.
- Also this .zip file while creating must be placed with in lib folder
- Lambda Max timeout is 15 minutes

### Reference

- [Lambda Layers in Java](https://www.youtube.com/watch?v=wnAI4VzkPJA)
- [Github Code](https://github.com/makhijanaresh/aws-integration-with-spring-boot/tree/main/LambdaLayerExample)
- [Lambda Layers in Detail](https://www.youtube.com/watch?v=stovPJCVXcw&t=381s)



