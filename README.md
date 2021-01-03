# Automotive Customization System
Automotive Customization System is an individual project using Java. The application allow multiple users get access to the server, and modify the data (which is cars) in the server. The sever and client object was implemented using Object Oriented Programing to encapsulate the implementation and access to the user. ArrayList is used as the main container for this project (instead of a real database). The update data is write to a text file to simplifier the process. The container can be replace with a database system (SQL Server or My SQL), and will perform the full function of an API.

![alt text](https://github.com/jackyhuynh/automotiveCustomizationSystem-Java/blob/main/picture/Capture%201.PNG)

## Technology:
Java, Servlet, Object-Oriented Design, Encapsulation, Data Structures, Algorithm, Apache Tom Cat, Servelet, Client-Sever Implementation

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
What things you need to install the software and how to install them
- Eclipse IDE: The Eclipse IDE is famous for our Java Integrated Development Environment (IDE), but we have a number of pretty cool IDEs, including our C/C++ IDE, JavaScript/TypeScript IDE, PHP IDE, and more. 
- Java Runtime Enviroment and Java Virtual Machine: Java software for your computer, or the Java Runtime Environment, is also referred to as the Java Runtime, Runtime Environment, Runtime, JRE, Java Virtual Machine, Virtual Machine, Java VM, JVM, VM, Java plug-in, Java plugin, Java add-on or Java download.
- Apache Tomcat (called "Tomcat" for short) is an open-source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and WebSocket technologies. Tomcat provides a "pure Java" HTTP web server environment in which Java code can run.

### Installing

A step by step series of examples that tell you how to get a development enviroment running.
Download and Install Java (Java Runtime Enviroment or Java Virtual Machine)
* [Java for Windows](https://java.com/en/download/) - we should download and install JVM before the Eclipse IDE 
Download and Install Eclipse IDE
* [Install Eclipse IDE](https://www.eclipse.org/ide/) - If you haven't downloaded and installed Eclipse IDE yet, here's how to get started.
There is other IDE that can run Java code, but we must download the JVM
* [Install Apache Tomcat](https://tomcat.apache.org/download-80.cgi) 


## Running the tests
Explain how to run the automated tests for this system:
### Run Server and test if Server is function properly
- Start server Server/driver/Driver.java
```
package driver;

/*
 *
 * Author :	Truc Huynh
 * Program :	AutomotiveSystem
 */

import java.io.IOException;
import java.net.ServerSocket;
import server.CreateServerConnectionToClient;

public class Driver {
	
	public static void main(String args[])throws IOException 
        {
            CreateServerConnectionToClient server = new CreateServerConnectionToClient(new ServerSocket(5555));
        }
}
```
- Tested complete successfully.

### Simultaneously create three clients and test if they are function properly
-Start client Client/driver/Driver.java

```
package driver;

/*
 *
 * Author :	Truc Huynh
 * Program :	AutomotiveSystem
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import client.DefaultSocketClient;

public class Driver 
{	
	public static void main(String args[])
        {
            String LocalHost = "";
            try
            {
                //Get the LocalHost...
                 LocalHost =  InetAddress.getLocalHost().getHostName();
            }
            catch (UnknownHostException e){
                System.err.println ("Unable to find local host");
            }
            DefaultSocketClient d = new DefaultSocketClient(LocalHost, 5555);
            d.start();
 	 }
                
}
```
- Tested complete successfully.

### Upload the data to Server (#1):
Create multithreading Server that can handle multiple clients. In Image 1, I run one server and three clients. The Server will receive a properties file (data) which upload by the client (#1), parse it, and store it on the server. (Validate data is successfully upload)

![alt text](https://github.com/jackyhuynh/automotiveCustomizationSystem-Java/blob/main/picture/Capture%201.PNG)

- Tested complete successfully.

### Send Request to Server (#2)
e. Received Request from Server (#2) (#3)




## Deployment

Can be deploy to sever using Apache Tomcat 

## Built With

* [Microsoft Visual Studio](https://visualstudio.microsoft.com/downloads/) - The full-featured integrated development environment (IDE) for Android, iOS, Windows, web, and cloud 
* [.NET](https://dotnet.microsoft.com/download/dotnet-framework) -  Free. Cross-platform. Open source. A developer platform for building Internet of Thing(IOT), Microservices, Desktop, Cloud, Mobile, Machine Learning, Web, Game.

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Truc Huynh** - *Initial work* - [TrucDev](https://github.com/jackyhuynh)
* **Yien Lin** - *Initial work* - [YienLin](https://www.linkedin.com/in/yienlin/)
* **Dmitry Sokolov** - *Initial work* - [DmitrySokolov](https://www.linkedin.com/in/dmitry-sokolov-726596a4/)

## Format
my README.md format was retrieved from
* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)
See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

