<h1> wealth-rating </h1>

Wealth-rating is a  RESTful API that allows users to send personal and financial data of a person to the server and get
feedback wether this person is rich or he isn't.

The service accepts JSON requests and responds with a JSON response.

<h1> How to use this application? </h1>

Clone the code and run it.

<h4> To Get all Richs in the Database </h4>

Go to your web browser and get into `$ localhost:8080/api/riches/all`

<h4> To Get Rich by Id </h4>

`$ http://localhost:8080/api/riches/getByID?Id={Id}`

<h4> To Post a Rich person to the database </h4>

send json body like this one:

{
  "id": 123456789,
  "personalInfo": {  
    "firstName": "Bill",   
    "lastName": "Gates",    
    "city": "Washington"    
  }, 
  "financialInfo": { 
    "cash": 16000000000,   
    "numberOfAssets": 50   
  } 
}

to: `$ http://localhost:8080/api/riches/saveRich`
