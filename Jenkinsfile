pipeline{
	agent any
	stages{
		stage('Clean Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn clean'
				}
			}
		}		
		stage('Compile Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn compile'
				}
			}
		}
		stage('Test Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn test'
				}
			}
		}
		/*stage('Deployment Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn deploy'
				}
			}
		}*/
	}
}