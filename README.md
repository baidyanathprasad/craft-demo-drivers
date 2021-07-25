## Craft-Demo:
This project is the demonstration of driver module's app

## Tech Stacks: 
**Kotlin(1.3.61)** is used as the programming language while **gradle wrapper(6.x)** is used as the build and test tool. For unit testing  **JUnit4.12** is used, **Dropwizard**. 

## Run Project:
- Export this project into any Kotlin/Java friendly editor (**IntelliJ Idea** suggested). 
- Let the automatically download the all dependencies (assuming suggested IDE is used).
- Create customer run environment in `Idea` -> `Edit Configuration -> Application -> add new application` then fill the following:  
> Main class: `com.baidyanath.AppKt`
> Program Arguments: `server appconfig-dev.yml`
> Working Directory: `/Users/baidyanathprasad/code/dropwizard-docker`
> Use class path of module: `dropwizard-docker.main`
> Leave the other setting as default.
> Finally, name it run craft-demo
> Save it.
> Click on `run craft-demo`.

## Unit Testing:
- Run the following commands for cleaning & unit testing - 
- `$: ./gradlew clean`
- `$: ./gradlew test`

## Docker Build & Run
Build the docker and create the image:
- `$: docker build -t <project_name> .`

Run the docker image:
- `$: docker run -it -p 8080:9080 -p 8081:8081 -e ENV_VARIABLE_VERSION=1.1.0 <image_name>`

Hit the http://localhost:8080
 
## Support:
For any issues facing to run this project kindly feel free to ping me on -**baidyanathprasadmdb@gmail.com**
