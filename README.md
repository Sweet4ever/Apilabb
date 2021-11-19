# Apilabb


Endpoints: 
http://localhost:8080/student-management-system/api/v1/students/new
example request body
{
    "firstName": "oskar",
    "lastName": "pilborg",
    "email": "oskar@pilborg.se",
    ("phoneNumber": "123") frivillig
}
http://localhost:8080/student-management-system/api/v1/students/all
http://localhost:8080/student-management-system/api/v1/students/{id}
id startar från 1 när ny student är skapad
http://localhost:8080/student-management-system/api/v1/students/searchByLastName?lastName="lastname"
"lastname" är en sträng
http://localhost:8080/student-management-system/api/v1/students/update/phone/{id}
http://localhost:8080/student-management-system/api/v1/students/update/firstName/{id}
http://localhost:8080/student-management-system/api/v1/students/update/lastName/{id}
http://localhost:8080/student-management-system/api/v1/students/update/email/{id}
