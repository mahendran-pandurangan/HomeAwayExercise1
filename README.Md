Pre-requisites to execute Exercise1:
* Java JDK must be installed - Either latest or version-7
* Maven must be installed - Preferably 3.3.X or above (I've used 3.3.9)
* Any Editor (OSS) (This is optional always user choice to use on their own). I've used ATOM to build this test suite.
* Used MAC-OSX (Incase for windows - please change chromedriver to windows specific under src/test/resources)  


Credentials to Login:
username: qatestdemo
password: test123$$



To run Test Suite - "mvn clean test -P homeawaysuite" 

To run individual testng test - RightClick on each tests and Run as TestNG Test



Issues:

* Selenium 2.0 i.e.,2.50.X supports all latest browser capabilities. Since I've used 2.48, hence you may see issue on latest Firefox. Either downgrade firefox to 41.0 or upgrade selenium to 2.50.X

* TestNg Suite doesn't work when trying to run on the same browsers(parallel test) --this issue observed only in local

* Currently Browsers and locators are hard-coded which this can be parameterized when developing complete test suite. We can always
have better plan to pass browser, environment, platforms, versions, remoteUrl everything from CLI.(using desiredCapabilities) 

* As requirements mentioned specifically to use POM, this particular tests can be very well covered from Data-Driven way or Hybrid(Keyword+Data-Driven). Less maintenance and easy to build tests.

* When running test suite (not individual tests) - SubmitOrderApp.java when running against Firefox - "Go to Checkout" button not working. This can be bug specifically for FF browser.(or may be version related issue)

* Logger info - used standard SYSO



