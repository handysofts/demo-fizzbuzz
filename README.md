# demo-fizzbuzz
Demo app for Fizz Buzz game

A user gives a number (or many) and expects a reply with numbers divisible by three replaced with the word "fizz" and numbers divisible by five with the word "buzz".
See more detailed description: http://en.wikipedia.org/wiki/Fizz_buzz

&nbsp;

Used technologies are below
- Maven
- Java 8
- Spring boot
- Spring data
- H2 in-memory Database
- Flyway
- Lombok
- Logback
- Thymeleaf
- Jquery
- Bootstrap
- JS
- HTML
- CSS

**NOTE:** If lombok plugin not installed to your IDE please install before import project source

&nbsp;

H2 db used for simplicity, you can use any db configuring datasource from `application.properties`.

Flyway used for auto migration/creation of DB. So you can simply create and use your own DB to start the project.

You can change, increase or decrease divide conditions and words from db.

Start and stop scripts located under under `src/data/scripts` folder. logs will be written to `/data/demo-fizzbuzz/logs` folder. 

