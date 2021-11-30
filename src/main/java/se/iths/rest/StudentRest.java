package se.iths.rest;

import se.iths.CustomException;
import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("new")
    @POST
    public Response createStudent(Student student){
        try{
            Student stud = studentService.createStudent(student);
            return Response.ok(stud).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The data provided is not acceptable")
                    .type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("searchByLastName")
    @GET
    public Response getStudentByLastName(@QueryParam("lastName") String lastName){
        List<Student> students = studentService.getStudentByLastName(lastName);
        if(students == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with lastName: "+ lastName + " could not be found")
                    .type(MediaType.APPLICATION_JSON).build();
        }
        return Response.ok(students).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id){
        Student student = studentService.findStudentById(id);
        if(id == 0){
            CustomException error = new CustomException();
            return error.CustomException("Testing custom exception");
        }
        if(student == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with id: "+ id + " could not be found")
                    .type(MediaType.APPLICATION_JSON).build();
        }
        return Response.ok(student).build();
    }

    @Path("all")
    @GET
    public Response getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        if(students == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No students could be found")
                    .type(MediaType.APPLICATION_JSON).build();
        }
        return Response.ok(students).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteById(@PathParam("id") Long id){
        try{
            return studentService.deleteStudentById(id);
        }
        catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No students could be found")
                    .type(MediaType.APPLICATION_JSON).build();
        }
    }
}
