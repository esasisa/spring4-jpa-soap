# spring-jpa-soap
    Spring4 JPA SOAP web services deployed on tomcat.

    Note :- Please copy  com.sandy.services.soap.Employee.java while changing any thing in XSD and uncommenting the <plugin> tag in pom.xml.
    pom will generate a new objects. I am using Employee object as an entity. while generating stub system will remove all the JPA anotations from Employee.java entity.
    
Deploy on Heroku
    install  Heroku Toolbelt from here https://toolbelt.heroku.com/
    
    1- Register on https://heroku.com/ and create a project with name <> on heroku site.
    
    2- Open "Git Bash" - Right click in any directory and open "Git Bash" prompt.
    
    3- Create the postgress database in heroku and provide the DB details in src/main/resources/application.properties
    
    3- Build the project using mvn install, and move to target folder and open the "Git Bash" prompt 
    
    4- Run "heroku deploy:war --war <war file name> --app <application name created on heroku>"
    
    5- Check the Log heroku "logs --tail --app <application name>"
    
    6- Open WSDL https://<application name>.herokuapp.com/ws/employees.wsdl
