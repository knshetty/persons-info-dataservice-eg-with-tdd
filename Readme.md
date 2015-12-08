Person-Info Service - A Toy Example
===================

This example service is a Java implementation, which can perform data-extraction from multiple resources and performs simple transformation operations on the extracted dataset. In addition, this service can filter dataset based on certain property value before outputting info to the screen.

----------
## High-Level Requirements
* This service must be a standalone Java implementation i.e. a command line program
* This service should exhibit the following capabilities:
	* Ability to extract information concerning persons dataset from multiple data sources  
	* Ability to handle flat-file as a data source
	* Ability to print-to-screen following information concerns persons: name, surname, age

## Technical Requirements
* This service implemented as a command line tool can accept arguments i.e. at least one. Here, the modes of operations are: (a) When run without parameters >> prints all data (b) When run with parameter "nuoriso" >> prints the information on minors (i.e. persons below the age of 18 years).
* Source code must be divided into two or more packages
* Unit testing must be carried out
* Use of Java interface, for example:
	1. An isolated implementation retrieves data from only CSV flat-file
	2. Another isolated implementation houses dummy data
* Basic Javadocs should be generated

## Prerequisites

You will need the following software installed on your computer.

* [JVM runtime environment](https://www.java.com)


## Installation

1. `$ git clone https://github.com/knshetty/persons-info-dataservice-eg-with-tdd.git`
2. Change into the newly created directory
3. Now, using a IDE like [Eclipse](http://www.eclipse.org/ide/) import this project & generate a jar file named `person-info-service.jar`

## Running

* Approach 1 `$ java -jar person-info-service.jar`
* Approach 2 `$ java -jar person-info-service.jar nuoriso`

## Useful Links
* [Read/Parse CSV file in Java programming language](http://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/)
* [A fast, programmer-friendly, free CSV library for Java](https://github.com/super-csv/super-csv)
* Unit testing and exceptional handling:
	* http://stackoverflow.com/questions/28174044/unit-test-that-an-exception-has-been-caught-and-handled
	* http://programmers.stackexchange.com/questions/212309/how-do-i-test-a-file-reader
* JUnit testing:
	* http://junit.org
	* {JUnit FAQ](http://junit.org/faq.html#atests_1)
	* [JUnit Testing Video Tutorial](https://www.youtube.com/watch?v=1M7gzXC9434)
	* [JUnit Matchers](http://tutorials.jenkov.com/java-unit-testing/matchers.html)
* [Java data collections]( http://javamex.com/tutorials/collections/how_to_choose.shtml)
* [eBook: The Well-Grounded Java Developer, by Benjamin J. Evans, Martijn Verburg, 2012](http://it-ebooks.info/book/854/)