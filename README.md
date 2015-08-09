# Vagrant Puppet Spring

This is a sample project including
* An ubuntu vagrant box with some plugins which are auto installed  
  * vagrant-hostmanager (auto-update hosts file)
  * vagrant-librarian-puppet (install Puppet modules using Librarian-Puppet)
* Puppet to manage what is installed and configured inside the box
  * jdk8
  * gradle
  * maven
  * postgres
* Advanced SpringBoot Sample Application
  * crud-Sample
  * liquibase
  * remote-debugging
  * spring-loadeded

## Getting started

1. Make sure you have installed vagrant and run
```
vagrant up
```
2. Import the gradle or maven project in your IDE (for example IntelliJ IDEA)  
3. ssh into the vagrant box
```
vagrant ssh
```
4. Inside the ssh-session navigate to the `~/project`-directory and run  
  ```
  ./gradleRunDebug.sh  
  ```
  or
  ```
  ./mavenRunDebug.sh  
  ```
5. Use your IDE to connect to the remote debugging session.  
  In IntelliJ edit the run configuration and add a `Remote`-configuration.  
  The only thing you have to replace is the hostname, use `10.0.0.10` or `springvagrant.box`.
6. Open a browser and navigate to  
  http://10.0.0.10:8080/person  
  or  
  http://springvagrant.box:8080/person  
7. You can now set breakpoints and change the code with automatic code hot swapping within the limitations of spring-loaded.
