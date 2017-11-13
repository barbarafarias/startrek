# startrek


## Requirements
 - [JAVA 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
 - [Apache Maven](https://maven.apache.org/index.html)

## How to Setup the project
* `$ git clone git@github.com:barbarafarias/startrek.git` - Clone the project
* `$ cd startrek` - Go into the project's folder
* `$ mvn clean install` - Compile and install the project's dependencies
* `$ cd target` - Go into the project's target folder
* `$ java -jar SheldonApp-1.0.jar <start_trek_character_name>` - Run the program and get the character specie

### Notes
* For names with special char use slash scape.
Example: $ java -jar SheldonApp-1.0.jar T\\'Pol