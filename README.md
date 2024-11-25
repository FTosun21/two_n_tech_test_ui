# 2NTech Task - BDD Framework With Cucumber

### Codes And Tests Prepared By :
Fatih Tosun

QA Automation Engineer

Github name: FTosun21

email: fatihtosun.qa@gmail.com
___
### Getting Started
To get start with this framework, you will need to have the following software on your system.

• Java 8 or later \
• Maven 4.7 or later \

1. Open terminal or command prompt and navigate to the root directory of the project.
2. Run the following command to download the required dependencies:
    ``` mvn clean install```
3. Run the following command to run the tests:
    ``` mvn verify```
4. Open the project with Intellij IDEA
   - Go to Runner Class inside the project
   - Click Run button
   #### Run With Runner Class
   - Go to Runner Class 
   - Add a tag name
   - Click the "Run" Button
___
### Project Overview
This project includes test automation scenarios for the 2NHABER and 2NTECH websites. 
The main goal is to verify important features of these websites using a dynamic, reusable, and expandable test framework.

### Features Tested
#### 1. Navbar Functionality
The user can click all elements in the 2NHABER website's navbar, and all pages should open without any issues.

The test for the navbar is fully dynamic.
If a new element is added to the navbar, the test will still work without updates.
Logic: A single method is used to handle the clicking and verification in a loop.
#### 2. Search Functionality
The user can perform a search on the 2NHABER website's homepage by following these steps:

Click the search button.
Enter a search term, like “İstanbul,” into the search box.
Click the dynamically selected news article (e.g., the 8th result).
Navigate to the article's detail page and verify it is correct.
Note: The news article's position is dynamic. You can change the number (e.g., from the 8th to the 3rd) without modifying the rest of the test.

#### 3. Form Submission
The user can fill out a form on the 2NTECH website by completing these steps:

Complete all fields in Step 1 of the form.
Select the position “Test Engineer” in Step 2.
Submit the form successfully and verify that it was sent.

### Technologies Used
Java: Programming language for automation.
Selenium WebDriver: Browser automation tool.
Cucumber: Framework for BDD (Behavior Driven Development).
JUnit: Test management and reporting.
JSoup: HTML parsing library. (It was added to the pom.xml file but was not used because it had not been experienced before.)
Maven: Dependency and build management.

## Project Structure
src\
├── main\
├── test\
│   ├── java\
│   │   └── pages       # Page Object Model classes|
│   │   └── runners     # Test runners\
│   │   └── stepDefs    # Step definitions for Cucumber\
│   │   └── utils       # Helper methods
│   │
│   └── resources
│       └── features    # Cucumber feature files
│       └── uploadFile  # upload file
│
├── config      # Configuration files


### My framework is a Cucumber and Hybrid Framework which contains BDD and DDT Frameworks.
• I built my framework by using Java Programming Language.\
• I used maven as a build automation tool for this framework.\
• I used Selenium (4.25.0), Cucumber and Junit to orchestrate my tests, and put the dependencies inside pom.xml file.\
• For assertions/verifications, I utilized JUnit assertions to compare expected and actual results.\
• I created a properties file to store related data such as browser, url, credential and some info.\
• I used Page Object Model Design Pattern to enhance test maintenance and reducing code duplication. This is one of the most famous Selenium approaches.\
• Inside pages package; I used Page Classes to store and identify the elements that I worked on.\
• I used the PageFactory class and initElements method to initialize them.\
• Inside runners package; in the Runner class, I used glues to connect feature files to step definitions.\
• I added the report plugin to Runner to generate HTML reports.\
• I also used tags for tests that I want to run in bulk.\
• stepDefinitions package is the place where my actual test scripts are.\
• Inside stepDefinitions package I used Hooks class as pre-and post-test implementations.\
• I added a screenshot interface in After method in Hooks class; when the scenario fails, it takes a screenshot.\
• I defined the test steps by adhering to the scenarios given.\
• Inside utilities package, utility classes such as BrowserUtils, Driver, and ConfigurationReader were stored.\
• I used the Singleton Design Pattern in Driver class by declaring constructor of class as private, so that no one instantiates class outside of it. \
• And declared a static method with return type as object of class which should check if class is already instantiated once.\
• Inside features directory, which is under resources directory, I created 3 feature file.\
• In these feature files I used Cucumber and Gherkin language for non-technical people to understand what is going on in testing.\
• By this way I implemented BDD (Behavior Driven Development). \
• My framework is easy to maintain since I have elements and methods stored in one centralized place. \
• If any changes happen on the application about the elements, I know where to go and how to fix it to run test scripts correctly.
