# Setup

IntelliJ must be run as admin

- install intellij into C:\dev\devtools\IntelliJ IDEA Community Edition 2023.2.5
- install notepad++ into: C:\dev\devtools\Notepad++
- install git into: C:\Program Files\Git
- install jdk into C:\dev\devtools\jdk-21
- set JAVA_HOME for user to C:\dev\devtools\jdk-21
- restart intelliJ
- download apache-maven-3.9.5-bin.zip
- extract to C:\dev\devtools\apache-maven-3.9.5
- download apache tomcat 9
- extract to C:\dev\devtools\apache-tomcat-9.0.83
- install postgres 16
- install to: C:\dev\devtools\PostgreSQL\16
- all items checked
- username: postgres
- password: root
- port: 5432
- db: testdb
- open psqlcommand line util
- login
- create database testdb;
- create database proddb;
- commit;
- edit C:\Windows\System32\drivers\etc\hosts
- add 127.0.0.1 postgres
- run flyway baseline
- run flyway migrate
- its annoying, but you have to change the url of flyway-maven-plugin between proddb and testdb to make sure they both are migrated etc.
## development requires

JAVA_HOME be set to a jdk manually downloaded from oracle
(one selected via intellij wil not work)
mvn installed
apache tomcat installed
and smart tomcat plugin for intellij
unit file support(systemd) plugin
running postgres server

# How this project was built

cd C:\dev\spring-jersey

mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes
-DinteractiveMode=false -DgroupId=com.example -DartifactId=simple-service-webapp -Dpackage=com.example
-DarchetypeVersion=2.40

# Troubleshooting

have to select the top level tomcat directory for intellij to be able to find catalina.jar for smart tomcat to work

Try running on 8081 if tomcat is running on 8080

Note exceptions if the run configuration for smart tomcat fails.
This may mean that 8080 is not a good port (may not be obvious from the exception)

If tests sparsely fail (meaning not a whole section)
try running flyway:migrate first, it could be that the model is not up to date

# Postgres

Setup postgresql 16
username: postgres
password: root
port: 5432
db: testdb

# Flyway

First setup postgres
Then run: mvn flyway:baseline
Should be no errors
then run: mvn flyway:migrate
Should be no errors

# New Deployment Package
Run war:war from maven
This would show you changes made to \src\main\webapp\index.jsp

# Recommendations

JSON Sorter is a useful utility if you are going to be dealing with
production pool modifications.

