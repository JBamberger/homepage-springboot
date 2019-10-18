# Springboot Homepage

This repository contains a Springboot application which served my homepage at
some point.

## Building the application

Run `gradlew build`.

## Deploy the application

Run `gradlew deploy`.

This requires a local properties file in `~/.gradle/gradle.properties` which
contains the following properties:

```properties
server_5_1_89_111_key_deployment_passphrase=<deployment-ssh-key-passphrase>
server_5_1_89_111_user_deployment_passphrase=<deployment-user-passphrase>
```

In addition `ssh` must be available and the deployment ssh key must be stored in
`~/.ssh/deployment`.

For more information on the deployment setup look [here][deploy-blogpost]

[deploy-blogpost]: https://www.jbamberger.de/java/springboot/gradle/nginx/centos/systemd/2018/12/29/springboot-deployment-with-nginx.html
