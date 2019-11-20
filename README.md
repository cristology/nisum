# nisum

https://github.com/cristology/nisum.git


1.- For compile project
mvn clean install

2.- For execute run the following command:
java -jar target/demo-0.0.1-SNAPSHOT.jar

or

mvn spring-boot:run (from target directory)



3. For test rest services

Different methods implemented:

SAVE URL: localhost:8088/persona/save
REQUEST: 
{
	"name":"Manuel",
	"lastName":"Pavez",
	"address":"Piuquenes 3697",
	"phoneNumber":"956573SSAA785",
	"hairColour":"black"
}

MODIFY URL: localhost:8088/persona/modify
REQUEST:
{
	"id":"1",
	"name":"Manuel",
	"lastName":"Pavez",
	"address":"Piuquenes 3697",
	"phoneNumber":"956573SSAA785",
	"hairColour":"black"
}


RETRIEVE URL: localhost:8088/persona/1

DELETE URL: localhost:8088/persona/delete/1
