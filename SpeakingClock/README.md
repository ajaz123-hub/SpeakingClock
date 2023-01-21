### Reference Documentation

This is a springboot application. you can import this in your IDE and start it(TimeconversionApplication) as spring boot application.
Once started, its running on default port 8080. Below are urls you can hit to test the date.
There is a service class HumanReadableDateService which you can run independently as a java application with or without parameters.
HumanReadableDateService has main method so that it can be run independently.

# 1 - http://localhost:8080/api/humanfriendlytext?time=13:00 - For time that you supply
# 2 - http://localhost:8080/api/humanfriendlytext  - For current time
# 3 - I have added tests in class HumanReadableDateServiceTest for service class level tests.
# 4 - HumanReadableDateService class has a main method so that this class can be run independently as java application with or without parameters.
