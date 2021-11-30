package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("/new")
    @POST
    public Response createSubject(Subject subject){
        Subject res = subjectService.createSubject(subject);
        return Response.ok(res).build();
    }

    @Path("all")
    @GET
    public Response getAllSubjects(){
        return Response.ok(subjectService.getAll()).build();
    }

    @Path("")
    @PUT
    public Response updateSubject(Subject subject){
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{id}")
    @GET
    public Response getSubjectById(@PathParam("id") Long id){
        List<Subject> subjects = subjectService.getSubjectData(id);
        return Response.ok(subjects).build();
    }
}
