pipeline{
	agent any
	stages{
		/*Run The Sonar Scan on the code, to verify the code quality*/
		stage('Sonar Scanning'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn sonar:sonar -Dsonar.projectKey=niteenbpatil111_GUIAutomationWork -Dsonar.organization=niteenbpatil111-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=b4abe4e1b43c7adda26e9d61aa51047e4cca2147 -Dsonar.source=src -Dsonar.java.binaries=target'
				}
			}
		}
		/*Verify the project is correct and all necessary information is available*/	
		stage('Validate Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn validate'
				}
			}
		}
		/*Clean all the libraries .class files*/			
		stage('Clean Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn clean'
				}
			}
		}
		/*Compile the source code of the project*/		
		stage('Compile Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn compile'
				}
			}
		}/*test the compiled source code using suitable unit testing framework. 
		This test should't required the code be packaged or deployed*/
		stage('Test Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn test'
				}
			}
		}
		/*Take the compiled code and packaged it into it's distribution format, suce as JAR*/
		stage('Package Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn package'
				}
			}
		}
		/*Run any tests on results of integration test to ensure quality criterias are met*/
		stage('Verify Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn verify'
				}
			}
		}
		/*Install the package into local repository, for use as dependancy in other projects locally*/
		stage('Install Stage'){
			steps{
				withMaven(maven : 'apache-maven-3.6.0')
				{
					bat 'mvn install'
				}
			}
		}
		/*Done the build environment. Copies the final package to the remote repository for sharing with other project, developers*/
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