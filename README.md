## AWS Lambda Triggers on S3 Upload

S3 Upload Triggers AWS Lambda using Java 21 and AWS SDK 2.x. 

## Getting Started

Follow the below instructions to get started with the source code:
- [Make sure you have all Requirements](#requirements)
- [Make sure to add AWS SDK for Java 2.x ](#Dependencies)

## Requirements

- [AWS Account](https://aws.amazon.com/console/)
- [IAM user with access-key and secret-access-key (user’s credentials)](https://lightsail.aws.amazon.com/ls/docs/en_us/articles/amazon-lightsail-managing-access-for-an-iam-user)
- [Download mock test file from](https://www.mockaroo.com/)


## Reference

- [Why Spring Boot is not Recommended for Lambda](https://www.reddit.com/r/java/comments/y4kuvr/is_anyone_using_java_spring_boot_in_aws_lambda/)
- [Amazon S3 Bucket Example](https://docs.aws.amazon.com/code-library/latest/ug/java_2_s3_code_examples.html)
- [Maven Setup](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/setup-project-maven.html)
- [AWS Lambda Examples](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/java_lambda_code_examples.html)
- [AWS Lambda Example YT 1](https://www.youtube.com/watch?v=3oV4Nj_ruOA)
- [AWS Lambda Example YT 2](https://www.youtube.com/watch?v=wk8Lk8R7Pck&t=3s)
  

## Dependencies

- AWS Java SDK Amazon S3:

```xml
<dependencies>
<!-- S3 AWS SDK for Java 2.x -->
<dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>s3</artifactId>
</dependency>

<!-- Lambda Core, AWS SDK, this is still available only in Java 1.x  -->
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-core</artifactId>
    <version>1.2.3</version>
</dependency>

<!-- Lambda events, AWS SDK, this is still available only in Java 1.x  -->
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-events</artifactId>
    <version>3.13.0</version>
</dependency>

</dependencies>

<dependencyManagement>
<dependencies>
    <dependency>
        <groupId>software.amazon.awssdk</groupId>
        <artifactId>bom</artifactId>
        <version>${aws.version}</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
</dependencies>
</dependencyManagement>
```

