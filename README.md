## Pre Requisites:
1. Install Java and maven:
Download and install java in C:\Dev\Apps\Java folder on your machine from: https://www.oracle.com/in/java/technologies/downloads/#jdk21-windows
Download and export maven in C:\Dev\Apps\Maven from: https://maven.apache.org/download.cgi

2. Set environment variables:
Add Java home and maven home in environment variables:
JAVA_HOME: C:\Dev\Apps\Java
M2_HOME: C:\Dev\Apps\Maven\apache-maven-3.9.6

Add below in path variable:
%M2_HOME%\bin
%JAVA_HOME%\bin

3. Install intelliJ idea community addition.
4. Install git (Follow below links to use chocolatey for installing git)
https://chocolatey.org/install
https://community.chocolatey.org/packages/git.install#individual
5. Install docker desktop
https://docs.docker.com/get-docker/

## Setup local work repo
1. Create folder structure below and clone this project:
C:\Dev\Projects
2. Install cucumber plugin for intelliJ idea from marketplace.

Use these steps to clone from SourceTree, our client for using the repository command-line free. Cloning allows you to work on your files locally. If you don't yet have SourceTree, [download and install first](https://www.sourcetreeapp.com/). If you prefer to clone from the command line, see [Clone a repository](https://confluence.atlassian.com/x/4whODQ).

1. You’ll see the clone button under the **Source** heading. Click that button.
2. Now click **Check out in SourceTree**. You may need to create a SourceTree account or log in.
3. When you see the **Clone New** dialog in SourceTree, update the destination path and name if you’d like to and then click **Clone**.

## Running tests locally on Docker
1. Make sure Docker variable is set to True in Default.properties.
2. Run docker-compose -f docker-compose.yml up from project root folder.
3. Navigate to http://localhost:4444/ui/ in your browser and check multiple browser nodes are running.
4. Rum mvn clean test command in another powershell.
5. Once tests are finished running go back to previous powershell and press ctrl+C and run docker-compose -f docker-compose.yml down to release resources.
6. Verify test results report in target folder.
4. Open the directory you just created to see your repository’s files.

Now that you're more familiar with your Bitbucket repository, go ahead and add a new file locally. You can [push your change back to Bitbucket with SourceTree](https://confluence.atlassian.com/x/iqyBMg), or you can [add, commit,](https://confluence.atlassian.com/x/8QhODQ) and [push from the command line](https://confluence.atlassian.com/x/NQ0zDQ).