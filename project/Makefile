FRONT_END_BINARY=frontApp
BROKER_BINARY=brokerApp
AUTH_BINARY=authApp
LOGGER_BINARY=loggerServiceApp
MAIL_BINARY=mailApp
LISTENER_BINARY=listenerApp
FRONT_BINARY=frontEndApp
## up: starts all containers in the background without forcing build
up:
	@echo "Starting Docker images..."
	docker-compose up -d
	@echo "Docker  images started!"
##up_build stops docker-compose, builds all projects and starts docker compose
up_build: build_broker build_auth build_logger build_mail build_listener build_front_linux
	@echo "Stopping docker images"
	docker-compose down
	@echo "Building"
	docker-compose up --build -d
	@echo "Docker imgs built and started"

## down: stop docker compose
down: 
	@echo "Stopping docker compose"
	docker-compose down
	@echo "Done!"

##build_broker: builds broker binary
build_broker:
	@echo "Building broker binary..."
	cd ../broker-service/ && env GOOS=linux CGO_ENABLED=0 go build -o ${BROKER_BINARY} ./cmd/api
	@echo "Done"

##build_logger: builds logger binary
build_logger:
	@echo "Building logger binary..."
	cd ../logger-service/ && env GOOS=linux CGO_ENABLED=0 go build -o ${LOGGER_BINARY} ./cmd/api
	@echo "Done"	
## build auth app
build_auth:
	@echo "Building auth binary..."
	cd ../authentication-service/ && env GOOS=linux CGO_ENABLED=0 go build -o ${AUTH_BINARY} ./cmd/api
	@echo "Done"
## build mail app
build_mail:
	@echo "Building mail binary..."
	cd ../mail-service/ && env GOOS=linux CGO_ENABLED=0 go build -o ${MAIL_BINARY} ./cmd/api
	@echo "Done"
## build listener app
build_listener:
	@echo "Building listener binary..."
	cd ../listener-service/ && env GOOS=linux CGO_ENABLED=0 go build -o ${LISTENER_BINARY} .
	@echo "Done"
## build listener app
build_front_linux:
	@echo "Building front end app binary..."
	cd ../front-end/ && env GOOS=linux CGO_ENABLED=0 go build -o ${FRONT_BINARY} ./cmd/web
	@echo "Done"
## build front
build_front:
	@echo "Building front end binary..."
	cd ../front-end && env CGO_ENABLED=0 go build -o ${FRONT_END_BINARY} ./cmd/web
	@echo "Done"
##starts front end
start:
	@echo "Starting front end"
	cd ../front-end && go build -o ${FRONT_END_BINARY} ./cmd/web
	cd ../front-end && ./${FRONT_END_BINARY} &