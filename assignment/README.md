# Getting Started

### Reference Documentation
For further reference, please consider the following sections:
  ***ADD LOMBOK JAR***
* Adding the library into your project.

```
 <dependency>
			<groupId>com.filestore</groupId>
			<artifactId>assignment</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
```
              
* Necessary code changes 
  
      
   1.Add the below given piece of code in the application class  
  
 ```
  @EnableMongoRepositories(basePackageClasses = DataStoreRepository.class)
  
  ```
  
* Sample Implementation 

```
@Bean
	CommandLineRunner run() {
		return args -> {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("assaasa", "asdasdfsdfsd");
			dataStoreService.create(jsonObject);

			dataStoreService.read("asadas");

		};
	}
```



