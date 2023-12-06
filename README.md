# SimpleCakeApplicationDemo
this is a simple application about Springboot with DDD 

# Code layer
the code of this application was divided into four layers that contains userinteface layer、application layer、domain layer and infrastructure layer.
the concept of four layer is deriven from DDD(Domain Drive Design).
the UserInterface is similar Controller.
the Application layer is used to combine different domain sevice to achieve the business logical.
the Domain layer is similar like Service layer.
the Infrastructure layer is similar like Dao layer.

This design model is proficient for dividing a large project to different micro software project.

# fuction
this simple application was designed for online cakesales mangement. it contains two roles (user and employee),user enable to query cake foods opened to user. and
enable to query all cake foods and add the cake information. 
besides that it support user and employee to view different menu and add or update or delete menu;

# description
DTO:DTO is used as a layer of protection, which can shield possible data field modifications on the front end. Please take this


