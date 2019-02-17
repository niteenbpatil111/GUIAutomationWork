pipeline{
	agent any
	stages{
		stage('Clean Stage'){
			steps{
				withMaven(maven: 'apache-maven-3.6.0')
				{
					sh 'mvn clean'
				}
			}
		}		
		stage('Compile Stage'){
			steps{
				withMaven(maven: 'apache-maven-3.6.0')
				{
					sh 'mvn compile'
				}
			}
		}
		stage('Test Stage'){
			steps{
				withMaven(maven: 'apache-maven-3.6.0')
				{
					sh 'mvn test'
				}
			}
		}
		stage('Deployment Stage'){
			steps{
				withMaven(maven: 'apache-maven-3.6.0')
				{
					sh 'mvn deploy'
				}
			}
		}
	}
}