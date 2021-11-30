# Apilabb


Endpoints: <br />
http://localhost:8080/student-management-system/api/v1/students/new<br />
example request body<br />
{<br />
    "firstName": "oskar",<br />
    "lastName": "pilborg",<br />
    "email": "oskar@pilborg.se",<br />
    ("phoneNumber": "123") frivillig<br />
}<br />
http://localhost:8080/student-management-system/api/v1/students/all<br />
http://localhost:8080/student-management-system/api/v1/students/{id}<br />
id startar från 1 när ny student är skapad<br />
http://localhost:8080/student-management-system/api/v1/students/searchByLastName?lastName="lastname"<br />
"lastname" är en sträng<br />
http://localhost:8080/student-management-system/api/v1/students/update/phone/{id}<br />
http://localhost:8080/student-management-system/api/v1/students/update/firstName/{id}<br />
http://localhost:8080/student-management-system/api/v1/students/update/lastName/{id}<br />
http://localhost:8080/student-management-system/api/v1/students/update/email/{id}<br />
