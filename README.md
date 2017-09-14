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

## How to run it

This is a multi-layer Maven project built using **Spring Boot**

To build the project just execute maven mvn clean package commands from the project root, with this you'll get a generated jar file on target folder.

Start and stop scripts located under under `src/data/scripts` folder. logs will be written to `/data/demo-fizzbuzz/logs` folder.

## RESTful API

The API provides the following interfaces

### Play Game

#### GET /api/v1/game/play/numbers/{comma separated numbers}

Request:

```
Headers:
Accept: application/json
Content-Type: application/json
```

Login success response:
```json
{
    "error": {
        "code": 0,
        "message": "No Error"
    },
    "fizzBuzzed": "1,2,fizz,4,buzz,fizz,7,buzz,11,fizz,13,fizzbuzz,fizz,fizzbuzz,32"
}
```
Login incorrect response:
```json
{
    "error": {
        "code": -9999,
        "message": "Unknown error! Please contact vmustafayev@gmail.com"
    }
}
```