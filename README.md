# WSO2 API Microgateway
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/slack-microgateway-blueviolet)](https://join.slack.com/t/wso2-apim/shared_invite/enQtNzEzMzk5Njc5MzM0LTgwODI3NmQ1MjI0ZDQyMGNmZGI4ZjdkZmI1ZWZmMjNkY2E0NmY3ZmExYjkxYThjNzNkOTU2NWJmYzM4YzZiOWU)

The WSO2 API Microgateway is a Cloud Native API Gateway which can be used to expose one or many microservices as APIs.


## Why WSO2 API Microgateway
Microservices have become the norm for modern application architecture. Workloads of modern applications are spread 
across many groups of microservices, cloud services and legacy services. The characteristics and behaviors of such 
heterogeneous services have a massive diversity. Such as authentication mechanisms, message formats, high availability 
factors and so on.
The WSO2 API Microgateway is designed to expose heterogeneous microservices as APIs to end consumers using a common API 
interface based on the Open API Specification. This helps expose microservices using a unified interface to external 
consumers, internal consumers and partners. It applies the common quality of service attributes on API requests such as 
security, rate limiting and analytics and also offers a wide range of features which helps organizations to deploy APIs 
microservice architectures efficiently.

## Microgateway quick start

*Prerequisites*
    - Make sure you have installed *docker* on your machine.
    - Make sure you have installed the *docker-compose* on your machine

Let's host our first API on a Microgateway. We will be exposing the publicly available [petstore services](https://petstore.swagger.io/) via  microgateway.

1. First download the CLI tool(APICTL) and the microgateway distributions
and extract them to a folder of your choice.
  * [CLI (APICTL)](https://github.com/wso2/product-apim-tooling/releases/tag/4.0.0-M5)
  * [Microgateway Distribution](https://github.com/wso2/product-microgateway/releases/tag/v4.0.0-m5)
  
Note: WSO2 Microgateway v4.0.0-m5 is compatible with APICTL 4.0.0-M5.

CLI tool extracted location will be referred as `CLI_HOME` and Microgateway distribution extracted location would be 
referred as `MG_HOME`.

2. Using your command line client tool add the 'CLI_HOME' folder to your PATH variable.
```
export PATH=$PATH:<CLI_HOME>
```

3. Let's create our first project with name "petstore" by adding the [open API definition](https://petstore.swagger.io/v2/swagger.json) of the petstore . You can do that by executing the following command using your command line tool.
```
apictl init petstore --oas https://petstore.swagger.io/v2/swagger.json
```

4. The project is now initialized. You should notice a directory with name "petstore" being created in the location 
where you executed the command. 

 
5. Now lets start the microgateway on docker by executing the docker compose script inside the `MG_HOME`. Navigate to `MG_HOME` and execute the following command
```
docker-compose up -d
```

Once containers are up and running, we can monitor the status of the containers using the following command

```
docker ps | grep mg-
```

6. Now let's deploy our first API to Microgateway using the project created in the step 3. Navigate to the location where the petstore project was initialized.
Execute the following command to deploy the API in the microgateway

```
apictl mg deploy --host https://localhost:9843 --file petstore  -u admin -p admin -k
```

The user credentials can be configured in the configurations of the `MG_HOME` distribution. `admin:admin` is the default accepted credentials by the 
microgateway adapter..

7. The next step would be to invoke the API using a REST tool. Since APIs on the Microgateway are by default secured. We need a valid token in order to invoke the API. 
Use the following sample token accepted by the microgateway to access the API. Lets set the token to command line as a variable


```
TOKEN=eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ==.eyJhdWQiOiJBT2syNFF6WndRXzYyb2QyNDdXQnVtd0VFZndhIiwic3ViIjoiYWRtaW5AY2FyYm9uLnN1cGVyIiwibmJmIjoxNTk2MDA5NTU2LCJhenAiOiJBT2syNFF6WndRXzYyb2QyNDdXQnVtd0VFZndhIiwic2NvcGUiOiJhbV9hcHBsaWNhdGlvbl9zY29wZSBkZWZhdWx0IiwiaXNzIjoiaHR0cHM6Ly9sb2NhbGhvc3Q6OTQ0My9vYXV0aDIvdG9rZW4iLCJrZXl0eXBlIjoiUFJPRFVDVElPTiIsImV4cCI6MTYyNzU0NTU1NiwiaWF0IjoxNTk2MDA5NTU2LCJqdGkiOiIyN2ZkMWY4Ny01ZTI1LTQ1NjktYTJkYi04MDA3MTFlZTJjZWMifQ==.otDREOsUUmXuSbIVII7FR59HAWqtXh6WWCSX6NDylVIFfED3GbLkopo6rwCh2EX6yiP-vGTqX8sB9Zfn784cIfD3jz2hCZqOqNzSUrzamZrWui4hlYC6qt4YviMbR9LNtxxu7uQD7QMbpZQiJ5owslaASWQvFTJgBmss5t7cnurrfkatj5AkzVdKOTGxcZZPX8WrV_Mo2-rLbYMslgb2jCptgvi29VMPo9GlAFecoMsSwywL8sMyf7AJ3y4XW5Uzq7vDGxojDam7jI5W8uLVVolZPDstqqZYzxpPJ2hBFC_OZgWG3LqhUgsYNReDKKeWUIEieK7QPgjetOZ5Geb1mA==
``` 

8. We can now invoke the API running on the microgateway using cURL as below.
```
curl -X GET "https://localhost:9095/v2/pet/findByStatus?status=available" -H "accept: application/json" -H "Authorization:Bearer $TOKEN" -k
```


#### Microgateway Components
- **APICTL** : The APICTL is used to initiate Microgateway projects as well as to deploy APIs in to Microgateway. This is a developer tool used
 to deploy APIs into Microgateway

- **Router** : The client facing component of the Microgateway. The downstream request will reach the proxy component and it will route the request
to the desired destination.

- **Enforcer** : This component will intercept the request going through the Router and applies security, rate limiting, publish analytics data and etc.
Router will forward the request to this component in order to validate and to add additional QoS.

- **Adapter** : The component configures the Router and the enforcer components dynamically during the runtime upon receiving an event for API
creation or update.
#### Architecture

The following diagram illustrates how the WSO2 API Microgateway expose micro services using Open API definition as well 
as exposing APIs from [WSO2 API Manager](https://wso2.com/api-management/).

![Alt text](Architecture.png?raw=true "Title")


#### WSO2 API Microgateway APICTL commands

Following are the basic commands in APICTL which is used to deploy/update APIs in Microgateway

Note: Before you execute any of the commands below you need to add the path to the `<CLI_HOME` directory to the PATH environment variable. Ex: /home/dev/wso2am-micro-gw/bin

##### Init

`$ apictl init <project_name> --oas <filePathToOpenAPI_or_openAPIUrl`

The "apictl init" command is used to initialize a project structure with artifacts required to deploy API in Microgateway. This will create a **api_definitions**  directory.

Execute `apictl help init` to get more detailed information regarding the setup command.

Example

    $ apictl init petstore --oas https://petstore.swagger.io/v2/swagger.json

Let's see how we can expose the [petstore swagger](samples/petstore_swagger3.yaml) using the micro-gw.

##### Deploy

`$ apictl mg deploy --host <url_of_adaptor> --file <file_path_of_project_initiated_from_apictl>  --username <Username> --password <Password> -k`

Upon execution of this command, CLI tool deploy the API described with open API in the Microgateway.
```
 --host - Service url in which the Microgateway adapter is exposed.
 --file - File path of the project intitiated from apictl tool.
 --username - A valid username in order to communicate with the adapter (ex: admin)
 --password - The password of the user.
```
Example

	$ apictl mg deploy --host https://localhost:9843 --file petstore.zip  --username admin --password admin


#### Invoke API exposed via microgateway
Once APIs are exposed we can invoke API with a valid jwt token or an opaque access token.
In order to use jwt tokens microgateway should be presented with  a jwt signed by a trusted OAuth2 service. There are few ways we can get a jwt token

1. Any third party secure token service
The public certificate of the token service which used to sign the token should be added to the trust store of the microgateway.
The jwt should have the claims **sub, aud, exp** in order to validate with microgateway

1. Get jwt from WSO2 API Manager
Please refer the [documentation](https://docs.wso2.com/display/AM260/Generate+a+JWT+token+from+the+API+Store) on how to get a valid jwt

The following sample command can be used to invoke the "/pet/findByStatus" resource of the petstore API

```
curl -X GET "https://localhost:9095/petstore/v1/pet/findByStatus?status=available" -H "accept: application/xml" -H "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ik5UQXhabU14TkRNeVpEZzNNVFUxWkdNME16RXpPREpoWldJNE5ETmxaRFUxT0dGa05qRmlNUSJ9.eyJhdWQiOiJodHRwOlwvXC9vcmcud3NvMi5hcGltZ3RcL2dhdGV3YXkiLCJzdWIiOiJhZG1pbiIsImFwcGxpY2F0aW9uIjp7ImlkIjoyLCJuYW1lIjoiSldUX0FQUCIsInRpZXIiOiJVbmxpbWl0ZWQiLCJvd25lciI6ImFkbWluIn0sInNjb3BlIjoiYW1fYXBwbGljYXRpb25fc2NvcGUgZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9sb2NhbGhvc3Q6OTQ0M1wvb2F1dGgyXC90b2tlbiIsImtleXR5cGUiOiJQUk9EVUNUSU9OIiwic3Vic2NyaWJlZEFQSXMiOltdLCJjb25zdW1lcktleSI6Ilg5TGJ1bm9oODNLcDhLUFAxbFNfcXF5QnRjY2EiLCJleHAiOjM3MDMzOTIzNTMsImlhdCI6MTU1NTkwODcwNjk2MSwianRpIjoiMjI0MTMxYzQtM2Q2MS00MjZkLTgyNzktOWYyYzg5MWI4MmEzIn0=.b_0E0ohoWpmX5C-M1fSYTkT9X4FN--_n7-bEdhC3YoEEk6v8So6gVsTe3gxC0VjdkwVyNPSFX6FFvJavsUvzTkq528mserS3ch-TFLYiquuzeaKAPrnsFMh0Hop6CFMOOiYGInWKSKPgI-VOBtKb1pJLEa3HvIxT-69X9CyAkwajJVssmo0rvn95IJLoiNiqzH8r7PRRgV_iu305WAT3cymtejVWH9dhaXqENwu879EVNFF9udMRlG4l57qa2AaeyrEguAyVtibAsO0Hd-DFy5MW14S6XSkZsis8aHHYBlcBhpy2RqcP51xRog12zOb-WcROy6uvhuCsv-hje_41WQ==" -k
```
Please note that the jwt provided in the command is a jwt token retrieved from WSO2 API Manager with higher expiry time which can be used with any API not protected with scopes.
This token works with any API since by default the microgateway config uses the public certificate of WSO2 API Manager to validate the signature.
