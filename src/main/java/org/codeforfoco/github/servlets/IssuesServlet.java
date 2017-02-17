package org.codeforfoco.github.servlets;

import org.codeforfoco.github.api.IssueService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by afibarra on 2/11/17.
 */
@WebServlet(urlPatterns = {"/createIssue"})
public class IssuesServlet extends HttpServlet {

    @Inject
    private IssueService issueService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String issueTitle = request.getParameter("issueTitle");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userComment = request.getParameter("userComment");

        issueService.createAnIssue(issueTitle, buildUserComment(firstName, lastName, email, userComment));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String buildUserComment(String... userInfo) {
        StringBuilder userComment = new StringBuilder();

        // 0 - firstName
        // 1 - lastName
        // 2 - email
        // 3 - userComment

        userComment.append("**Name: **").append(userInfo[0]).append(userInfo[1]).append("<br/>");
        userComment.append("**Email: **").append(userInfo[2]).append("<br/>");
        userComment.append("**Comment: **").append(userInfo[3]);

        return userComment.toString();
    }
}
