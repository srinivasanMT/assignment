# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* Adding the library into your project.

```
 <dependency>
			<groupId>com.filestore</groupId>
			<artifactId>assignment</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
```
              
*Necessary code changes 
  
      
   1.Add the below given piece of code in the application class  
  
 ```
  @EnableMongoRepositories(basePackageClasses = DataStoreRepository.class)
  
  ```
  
* Sample Implementation 

```
@Bean
	CommandLineRunner run() {
		return args -> {
			AssignmentData assignmentData = new AssignmentData();
			assignmentData.setKey("asadas");
			assignmentData.setValue("asdadasdadadasdas");
			dataStoreService.create(assignmentData);

			Thread.sleep(61000);

			dataStoreService.read("asadas");

		};
	}
```



