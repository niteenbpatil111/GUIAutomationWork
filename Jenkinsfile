pipeline{
	agent any
	stages{
		stage('Sonar Scanning'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn sonar:sonar -Dsonar.projectKey=niteenbpatil111_GUIAutomationWork -Dsonar.organization=niteenbpatil111-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=b4abe4e1b43c7adda26e9d61aa51047e4cca2147 -Dsonar.source=src -Dsonar.java.binaries=target'
				}
			}
		}	
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