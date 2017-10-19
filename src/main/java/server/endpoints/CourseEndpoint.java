package server.endpoints;

import com.google.gson.Gson;
import server.dbmanager.DbManager;
import server.models.Course;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/courses")
public class CourseEndpoint {

    DbManager dbmanager = new DbManager();

    @GET
    public Response loadCourses (){
        ArrayList<Course> courses = dbmanager.loadCourses();

        return Response.status(200).entity(new Gson().toJson(courses)).build();

    }

}