package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.RescaleOp;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("/new")
    @POST
    public Response createTeacher(Teacher teacher){
        try{
            Teacher res = teacherService.createTeacher(teacher);
            return Response.ok(res).build();
        }
        catch(Exception e){

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("E: "+ e)
                    .type(MediaType.APPLICATION_JSON).build();
        }

    }

    @Path("{id}")
    @GET
    public Response getTeacherById(@PathParam("id") Long id){
        Teacher teacher = teacherService.findTeacherById(id);
        return Response.ok(teacher).build();
    }

    @Path("all")
    @GET
    public Response getAllTeachers(){
        return Response.ok(teacherService.getAll()).build();
    }

    @Path("")
    @PUT
    public Response updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("getSpecificInfo/{subId}/{teachId}")
    @GET
    public Response getSpecific(@PathParam("subId") Long subId, @PathParam("teachId") Long teachId){
        List list = teacherService.getSpecifiedStudentsPerSubjectAndTeacher(subId, teachId);
        return Response.ok(list).build();
    }
}

