 def call (ip,creds,warfile) {
  //install ssh agent plugin
   sshagent(['creds']) {
   // copy war file to tomcat-dev server
   sh "scp -o StrictHostKeyChecking=no target/${warfile} ec2-user@${ip}:/opt/tomcat9/webapps" 
   //restart tomcat
   sh "ssh ec2-user@${ip} /opt/tomcat9/bin/shutdown.sh"
   sh "ssh ec2-user@${ip} /opt/tomcat9/bin/startup.sh"
   }
 }
