package org.codeforfoco.github.api;

import java.io.IOException;

/**
 * Created by afibarra on 2/11/17.
 */
public interface IssueService {
    boolean createAnIssue(String issueTitle, String userComment) throws IOException;
    String buildUserComment(String... userInfo);
}
