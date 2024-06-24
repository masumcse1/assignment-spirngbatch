# assignment-spirngbatch
# Before running this applicaiton need to update following Application Properties 
```
1. cron.value: Specifies the cron expression for scheduling tasks (default: 0 */1 * * * ?).
2. file.date.format: Defines the format for the date in the files (default: yyyy-MM-dd).
3. file.time.format: Defines the format for the time in the files (default: HH:mm:ss).
4. transactioninfo.file.path: Path to the transaction information file (example: file:///F:/transactionfile/dataSource.txt).
5. spring.datasource.url: Need to put valid postgreSQL database name & port 
6. spring.datasource.username: Need to put valid postgreSQL user 
7. spring.datasource.password: Password for the PostgreSQL database
```

# Cron Expression explanation----      (0 */1 * * * ?).
```
0   - At the 0th second.
*/1 - Every 1 minute (default).
*   - Every hour.
*   - Every day of the month.
*   - Every month.
?   - No specific day of the week.
```

#Spring Boot Application Build & Run Documentation Prerequisites
```
Java Development Kit (JDK): Ensure JDK 17 or higher .
Apache Maven:  Maven 3.6.0 or higher is installed.
PostgreSQL Database: Ensure PostgreSQL is running.
Update application.properties
```

# project running steps
```
navigate to application directory
mvn clean package 
java -jar target/assignment-spirngbatch-1.0.jar
```

# project testing steps
```
1.Import postman colleciton file from bellow location.
\postmancolleciton\springbatch.postman_collection.json
2. fistly need to call authentication api for token generation.
3. then test other api (update , search)



```


