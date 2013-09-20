Maven Unit / Integration Test Guide (MaUI Test Guide)
=====================================================


Describe the best practice for doing unit and integrations tests in Maven.

The Idea of this module based on [http://jira.codehaus.org/browse/MNG-1563](http://jira.codehaus.org/browse/MNG-1563).


License
-------
[Apache License, Version 2.0, January 2004](http://www.apache.org/licenses/)

Homepage
--------

The Maven Unit Integration Test Guide [http://khmarbaise.github.com/maui](http://khmarbaise.github.com/maui)

Name
----
 - MaUI Test Guide

Roadmap
-------
 - Unit Testing with Maven
   - maven-surefire-plugin

 - Integration Testing with Maven
   - maven-failsafe-plugin

 - Integration Testing in Maven Plugin Development
   - maven-invoker-plugin

 - Code Coverage for Unit Testing
   - Cobertura, Emma
     http://mojo.codehaus.org/emma-maven-plugin/index.html
     http://mojo.codehaus.org/cobertura-maven-plugin/index.html

 - Code Coverage for Integration Testing
   - Coberatura?, Emma4it ? 
   - How to do this?
     
   - http://www.sonatype.com/people/2009/06/integration-tests-with-maven-part-2-test-coverage-reports/
   - http://blog.jayway.com/2008/12/13/getting-coverage-for-integration-tests/
   - https://github.com/activelylazy/coverage-example
   - http://www.petrikainulainen.net/programming/maven/creating-code-coverage-reports-for-unit-and-integration-tests-with-the-jacoco-maven-plugin/

 - mvn release:.... -Darguments="-Dxxxx" caused by calling instance during release process.

 - JBehave
   - http://jbehave.org/reference/stable/maven-goals.html

Status
------
 - First description about unit test and integration test done.

TODOs
-----

 - Integration test into separate module
   - examples how to use cargo?

 - Maven Plugin Development
   - Unit Test examples 
   - Integration test examples
     - for example with Maven Invoker Plugin

 - Maven Unit Testing
   - Example for multiple usage:
     - copy xyz-test.jar into target/test folder (dependency:unpack)
       run the tests there..

 - Reporting Unit Tests results

 - Reporting code coverage results

 - Reporting Integration test results

 - Reporting Integration test coverage results.

Naming Convention for the examples
----------------------------------

  - Prefixes of the projects:

    mp - Maven Plugin

    ut - Unit Test

    it - Integration Test


    ut-       - Unit Test

    it-       - Integration Tests

    mp-it-... - Maven Plugin - Integration Test

