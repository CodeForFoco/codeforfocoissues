# Creating Issues

## Getting Started

This small application allows the user to create a new **Issue** remotely.

The following info is required to be stored in the **src/main/webapp/WEB-INF/classes/application.properties** file:

- GitHub account name
- Repository name
- Token

There are two ways to create a new **Issue**

1. Using a "conventional" URL

   ```
   http://\[hostname\]\[:8080\]/createIssue?issueTitle=ATitle&firstName=AFirstName&lastName=ALastName&email=AnEmail&userComment=AComment
   ```

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
## Bugs / Feedback / Suggestions

We encourage you to [open up an issue][newissue] if you have any feedback, suggestions or bugs.

## License

MIT, see [LICENSE](/LICENSE) for full license.

[slack]: https://codeforfoco.slack.com/
[slackinvite]: https://codeforfocoslack.herokuapp.com
[fork]: https://help.github.com/articles/fork-a-repo/
[forkthisrepo]: https://github.com/CodeForFoco/TODOUPDATEURL#fork-destination-box
[contributing]: https://github.com/CodeForFoco/org/blob/master/CONTRIBUTING.md
[githubissue]: https://github.com/CodeForFoco/TODOUPDATEURL/issues
[newissue]: https://github.com/CodeForFoco/TODOUPDATEURL/issues/new
[pullrequest]: https://github.com/CodeForFoco/TODOUPDATEURL/pulls