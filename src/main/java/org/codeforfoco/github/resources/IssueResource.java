package org.codeforfoco.github.resources;

import java.io.Serializable;

/**
 * Created by dev on 5/22/17.
 */
public class IssueResource implements Serializable {
    private static final long serialVersionUID = -8441155726616625838L;

    private String issueTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String userComment;

    public IssueResource() { }

    public IssueResource(String issueTitle, String firstName, String lastName, String email, String userComment) {
        this.issueTitle = issueTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userComment = userComment;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
