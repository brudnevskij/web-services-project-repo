# Web-services final project
### Description
This project introduces a micro-service app, which uses different API formats.
All micro-services are implemented to be runned in container, each micro-service dir has dockerfile.
Project also includes build tools implemented in makefile script. It can be found in a project folder.
During early stages of development docker-compose was used now project is orchestrated by k8s in one minikube kluster. All minikube yarn scripts can be found in project/k8s.


#### Micro-Services and languages of implementation
- Broker/APIGateway, Go
- Authentication, Go
- Logger, Go
- Mail, Go
- AMQP Listener, Go
- File save service, Java
- SOAP-based api, Python
- front-app, Go; html/css; JS;
#### Communication protocols
 - REST/JSON
 - RPC
 - gRPC
 - AMQP
 - SOAP
#### Sprints
During a project development I was folowing Scrum methodology. Here are weekly sprints results.
##### 1 sprint
###### Planning:
- Brainstorming project ideas
- Implement python SOAP service
###### Results:
- Implemented Java spring API
##### 2 sprint
###### Planning:
- Start learning micro-services with go
###### Results:
- Learnt Go std library
- Learnt Go Web-dev with stdlibs
- Go chi lib
##### 3 sprint
###### Planning:
- Build template for app
- Learn docker
###### Results:
- Built API gw/broker & docker container for it
- Built auth-service & docker container for it & postgre db container
- Built logger-service & docker container for it & mongo db container
- Built AMQP db conteiner & AMQP listener service & docker container for it
- docker-compose deployment yarn script
##### 4 sprint
###### Planning:
- Add new ways of communications (RPC, gRPC)
- Build containerized front end app
- Port Services to k8s
###### Results:
- Moved some services to RPC or gRPC.
- Built front app & docker container for it 
- Moved most services to k8s
