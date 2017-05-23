package org.codeforfoco.github.services;

import org.codeforfoco.github.api.IssueService;
import org.codeforfoco.github.resources.IssueResource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static javax.ws.rs.core.Response.Status;

/**
 * Created by afibarra on 5/22/17.
 */
@Path("issues")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IssuesRS {
    @Inject
    private IssueService issueService;

    @POST
    public Response createIssue(IssueResource issueResource) throws IOException {
        issueService.createAnIssue(issueResource.getIssueTitle(), issueService.buildUserComment(issueResource.getFirstName(),
                issueResource.getLastName(), issueResource.getEmail(), issueResource.getUserComment()));

        return Response.status(Status.NO_CONTENT).build();
    }
}
