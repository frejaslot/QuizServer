package server.endpoints;

import server.controller.AdminController;
import server.utility.Globals;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/question")
public class QuestionEndpoint {
    AdminController adminController = new AdminController();

    @POST
    public Response createQuestion(String questionJson) {
        Globals.log.writeLog(getClass().getName(), this, "Quiz question created", 2);

        Boolean questionCreated = adminController.createQuestion(questionJson);

        return Response
                .status(200)
                .type("application/json")
                .entity("{\"questionCreated\":\"true\"}")
                .build();
    }
}
