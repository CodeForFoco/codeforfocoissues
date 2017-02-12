package org.codeforfoco.github;

import com.jcabi.github.*;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Github github = new RtGithub("87e1b9ecb8ad2630a4037ce56139d6825f8360c3");
        Repo repo = github.repos().get(new Coordinates.Simple("afibarra", "afibarra.github.io"));
        Issue issue = repo.issues().create("How are you?", "");
        //issue.comments().post("My first comment!");
    }
}
