# Creating Issues

## Getting Started

This small application allows the user to create a new **Issue** remotely.

The following info is required to be stored in the **application.properties** file:

- GitHub account name
- Repository name
- Token

There are two ways to create a new **Issue**

1. Using a "conventional" URL and query parameters as follows:

   http://\[hostname\]\[:8080\]/createIssue?issueTitle=ATitle&firstName=AFirstName&lastName=ALastName&email=AnEmail&userComment=AComment

2. Sending a **POST** request to the following REST Endpoint:

   http://\[hostname\]:\[:8080\]/issues

   And the following body:
   
   ```json
   { 
	    "issueTitle":"ATitle",
	    "firstName":"AFirstName",
	    "lastName":"ALastName",
	    "email":"AnEmail",
	    "userComment":"AComment"
   }
   ```
   
##
## Running the application locally

1. $ mvn clean install
2. $ java -jar target/issues-swarm.jar

Example using **cURL**:

```
curl -X POST \
  http://127.0.0.1:8080/issues \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"issueTitle":"ATitle",
	"firstName":"AFirstName",
	"lastName":"ALastName",
	"email":"AnEmail",
	"userComment":"AComment"
}'
```

Example using **jQuery**:

```javascript
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://127.0.0.1:8080/issues",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache"
  },
  "processData": false,
  "data": "{\n\t\"issueTitle\":\"ATitle\",\n\t\"firstName\":\"AFirstName\",\n\t\"lastName\":\"ALastName\",\n\t\"email\":\"AnEmail\",\n\t\"userComment\":\"AComment\"\n}"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});
```