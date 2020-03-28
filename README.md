# Project Title

URL shortener

# Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

# Prerequisites

The following software is required to be installed

```
JDK 1.8
Apache Maven 3.x
```


# Install & Run TestCases

After downloading this artifact from GitHub. From the project folder, execute the following command to clean install application.
Note; This will run the test cases also

```
mvn clean install
```

# Starting the Application

To start this web application, use the following command from the project folder

```
mvn spring-boot:run
```


# Using the application

1. To get shorter form of URL, go to browser and open http://localhost:8080

2. To test the shortened URL, click on the 

# Design Approach

Its truncating from the well known MD5 algorithm and generating shortened string.

Tested it for 50k different URLs. It did not create any issue.

a. Used MD5 hashing to create a message digest for a given url.
b. First 5 bytes of the 16 bytes generated from the digest, is taken and converted into bigdecimal.
c. Then final string is generated using the alphabets/digits (62 different characters). 
d. The final string generated is stored in hashmap for reuse.


