# sysadm-sharedLib

Reusable Jenkins Pipeline shared library for simple Docker workflows used in the ITI DevOps CI/CD course.

## Structure

- `src/edu/iti/docker.groovy` – exposes helper functions for building, logging into, and pushing Docker images from declarative or scripted pipelines.

## Provided steps

| Function | Description |
| --- | --- |
| `docker.build(imageName, imageTag)` | Wraps `docker build -t imageName:imageTag .` |
| `docker.login(username, password)` | Runs `docker login -u username -p password` |
| `docker.push(imageName, imageTag)` | Runs `docker push imageName:imageTag` |

## Usage

1. Publish this repository as a Jenkins shared library (e.g., `sysadm-sharedLib`).
2. Reference it in your Jenkinsfile:

```groovy
@Library('sysadm-sharedLib') _

pipeline {
    agent any
    stages {
        stage('Build & Push') {
            steps {
                script {
                    def image = 'registry.example.com/app'
                    def docker = edu.iti.docker
                    docker.build(image, tag)
                    docker.login(env.REGISTRY_USER, env.REGISTRY_PASS)
                    docker.push(image, tag)
                }
            }
        }
    }
}
```


