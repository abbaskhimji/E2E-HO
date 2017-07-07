Instructions

1. Run mvn clean package from the directory where the POM is located.

		e.g. at command prompt C:\myapp2\file-service>
		
		mvn clean package
		
		
2. Run mvn exec:java  -Dexec.args=<the path where the test files are located>

		e.g. at command prompt C:\myapp2\file-service>
		
		mvn exec:java  -Dexec.args=C:\myapp2\file-service\src\test\resources\test-files
		
Please note I have currently hard coded HTML files as UNSUPPORTED.  If you want to add/change this you have to change the line in App.java and run the above steps again.
