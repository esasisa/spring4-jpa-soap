# spring-jpa-soap
    Spring4 JPA SOAP web services deployed on tomcat.

    Note :- Please copy  com.sandy.services.soap.Employee.java while changing any thing in XSD and uncommenting the <plugin> tag in pom.xml.
    pom will generate a new objects. I am using Employee object as an entity. while generating stub system will remove all the JPA anotations from Employee.java entity.
    
Deploy on Heroku
    
        install  Heroku Toolbelt from here https://toolbelt.heroku.com/
    
        Register on https://heroku.com/ and create a project with name <> on heroku site.
    
        Open "Git Bash" - Right click in any directory and open "Git Bash" prompt.
    
        Create the postgress database in heroku and provide the DB details in src/main/resources/application.properties
    
        Build the project using mvn install, and move to target folder and open the "Git Bash" prompt 
    
        Run "heroku deploy:war --war <war file name> --app <application name created on heroku>"
    
        Check the Log heroku "logs --tail --app <application name>"
    
        Open WSDL https://<application name>.herokuapp.com/ws/employees.wsdl
