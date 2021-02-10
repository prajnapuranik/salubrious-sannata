## salubrious-sannata

Developed from scratch, this project has gone through 3 versions so far, each version an improvement and a step closer to being an app that tracks your physical activities. 

Each version is detailed below. 

**TL;DR :** Started with implementation of a basic REST API and tested it using POSTMAN. Improved on the API to create a coherent front-end using Bootstrap and Thymeleaf, secured it through Spring Security and connected the API to a MySQL database to complete the flow. In the process of developing an activity module that serves as a homepage for user and contains user operations.

--------------------------------

**Initial setup commit:** Spring Application with controller

**Version 1:** Added get, post, put and delete requests to a Service class with Controller


**Version 2:** Eliminated dependency on hardcoded data, now using Apache Derby inbuild into Eclipse

Data being saved and retrieved from the DB

All the REST methods have been verified through POSTMAN


**Version 3:** Functioning REST API that takes input from user using Thymeleaf and UI designed using Bootstrap. Security enforced using Spring security

Entered user names are saved successfully to a MySQL database


**Summary:** Complete flow implemented from front-end to the back-end. Data picked up from user is processed, stored and retrieved on demand. User can register and then login using the same details. User homepage under construction.


**Pending:** Login page redirection to home yet to be implemented

Activity module in the user's homepage to be implemented
