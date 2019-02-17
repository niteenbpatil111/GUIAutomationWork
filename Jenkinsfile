pipeline{
	agent any
	stages{
		stage('Compile Stage'){
			steps{
				withMaven(maven: apache-maven-3.6.0)
				{
					sh 'mvn clean compile'
				}
			}
		}
		stage('Test Stage'){
			steps{
				withMaven(maven: apache-maven-3.6.0)
				{
					sh 'mvn test'
				}
			}
		}
		stage('Deployment Stage'){
			steps{
				withMaven(maven: apache-maven-3.6.0)
				{
					sh 'mvn deploy'
				}
			}
		}
	}
}