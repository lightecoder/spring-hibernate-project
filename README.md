## Project name
### Spring project with Hibernate ORM 

## Description
In this project I created relational mapping between Dto Entity objects and MySql tables with Spring Data. I'm using 
Hibernate @ManyToOne mapping and cloning mechanism in order to avoid duplicating inserted rows by Hibernate. Also, I used 
Flyway for creating Db tables and prepopulate the data. In order to perform inserting into tables rows with Hibernate
I create method @Bean in main runner class DemoApplication, so Hibernate could control and increment sequence index in 
its table. Otherwise, arises the conflict between Flyway and Hibernate if we insert rows in tables without Hibernate knowing 
and incrementing its indexes.

## Table of Contents
* [Project name](#project-name)
* [Description](#description)
* [Prerequisites](#prerequisites)
* [Authors](#author)

### Prerequisites
To run the project you need: 
* create Spring Boot project
* run MySql and create db for Flyway

## Author
Bodiak Yaroslav




