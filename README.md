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
http://localhost:8080/student-management-system/api/v1/students/update<br />
skicka med en request body


id startar från 1 när ny student är skapad<br />
http://localhost:8080/student-management-system/api/v1/students/searchByLastName?lastName="lastname"<br />
"lastname" är en sträng<br />

http://localhost:8080/student-management-system/api/v1/subjects/new<br />
example request body<br />
{<br />
    "name": "matte"
}<br />
http://localhost:8080/student-management-system/api/v1/subjects/all<br />
http://localhost:8080/student-management-system/api/v1/subjects/{id}<br />
http://localhost:8080/student-management-system/api/v1/subjects/update<br />
skicka med en request body

http://localhost:8080/student-management-system/api/v1/teachers/new<br />
example request body<br />
{<br />
    "name": "test"
}<br />
http://localhost:8080/student-management-system/api/v1/teachers/all<br />
http://localhost:8080/student-management-system/api/v1/teachers/{id}<br />
http://localhost:8080/student-management-system/api/v1/teachers/update<br />
skicka med en request body

http://localhost:8080/student-management-system/api/v1/teachers/getSpecificInfo/{subjectId}/{teachersId}
