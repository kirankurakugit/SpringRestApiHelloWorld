ipeline{

     agent any
      
     stages{
     stage('CheckoutCodefromScm')
{
      steps{

      git 'https://github.com/kirankurakugit/RestApiHelloWorld.git'

     echo "checkoutcode from scm is successfull"
    }
    }
    
   stage('Build'){
    steps{
   mvn clean package
  echo "buiild
    }
        stage("deploy"){
      cp SpringRestiApiHelloworld/target/SpringMVC.war  /opt/apache-tomcat9.0/webapps       
        }
     
   
}
