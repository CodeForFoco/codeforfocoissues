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
        String userComment = request.getParameter("userComment");

        issueService.createAnIssue(issueTitle, userComment);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
