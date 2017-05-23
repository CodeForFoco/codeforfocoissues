package org.codeforfoco.github.core;

import com.jcabi.github.*;
import org.codeforfoco.github.annotations.Property;
import org.codeforfoco.github.api.IssueService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by afibarra on 2/11/17.
 */
public class IssueServiceImpl implements IssueService {
    private Github github;
    private Repo repo;

    @Inject
    @Property
    private String accountName;
    @Inject
    @Property
    private String repoName;
    @Inject
    @Property
    private String token;

    @PostConstruct
    private void setUp() {
        github = new RtGithub(token);
        repo = github.repos().get(new Coordinates.Simple(accountName, repoName));
    }

    @Override
    public boolean createAnIssue(String issueTitle, String userComment) throws IOException {
        Issue issue = repo.issues().create(issueTitle, userComment);

        return !issue.exists();
    }

    @Override
    public String buildUserComment(String... userInfo) {
        StringBuilder userComment = new StringBuilder();

        // 0 - firstName
        // 1 - lastName
        // 2 - email
        // 3 - userComment

        userComment.append("**Name:** ").append(userInfo[0]).append(" ").append(userInfo[1]).append("<br/>");
        userComment.append("**Email:** ").append(userInfo[2]).append("<br/>");
        userComment.append("**Comment:** ").append(userInfo[3]);

        return userComment.toString();
    }
}
