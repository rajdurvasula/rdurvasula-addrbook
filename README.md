# Spring Boot Address Book sample application

## Components:
- Spring Boot Actuator
- JPA
- REST controller

## Application URL:
- Base URL: http://localhost:8080/myaddrbook

## Samples:
- Create Address Book entry:
  - URL: http://localhost:8080/myaddrbook/save
  - Content-type: application/json
  - Method: HTTP POST
'''
{
  "firstName":"Ganesh",
  "lastName":"Kumar",
  "title":"Mr",
  "company":"XYZ",
  "groupName":"Friends"
}
'''

- Get Address Book entry by Id:
  - URL: http://localhost:8080/myaddrbook/1
  - Content-type: application/json
  - Method: HTTP GET

- Update Address Book entry by Id:
  - URL: http://localhost:8080/myaddrbook/1
  - Content-type: application/json
  - Method: HTTP PUT
'''
{
  "firstName":"Ganesh",
  "lastName":"Kumar",
  "title":"Mr",
  "company":"XYZ",
  "groupName":"Family"
}
'''

