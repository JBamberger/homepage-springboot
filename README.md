# jbamberger-de-homepage
This repository contains the spring boot application which backs the jbamberger.de homepage.

# building the application
run `gradlew build`

# deploy the application
run `gradlew deploy`
This requires a local properties file in `~/.gradle/gradle.properties` which contains the following properties:
```
server_5_1_89_111_key_deployment_passphrase=<deployment-ssh-key-passphrase>
server_5_1_89_111_user_deployment_passphrase=<deployment-user-passphrase>
```
In addition `ssh` must be available and the deployment ssh key must be stored in `~/.ssh/deployment`.
