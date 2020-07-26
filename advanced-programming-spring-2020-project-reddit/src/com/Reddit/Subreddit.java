package com.Reddit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Subreddit {

    private String name;
    private String username;
    private String description;
    private String logoUrl;

    private List<Post> posts;

    public static List<Subreddit> subredditDatabase = new ArrayList<>();

    private Subreddit(String name, String username) {
        this.name = name;
        this.username = username;
        this.posts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public static Subreddit createSubreddit(String name, String username) {
        return new Subreddit(name, username);
    }

    public static List<Post> postsForUser(User user) { // posts gonna show in home according to "USERS" followed

        ArrayList<Post> subredditPosts = new ArrayList<>();

        for(UserToSubredditRelation userToSubredditRelation : user.getUserToSubredditRelations()) {
            subredditPosts.addAll(userToSubredditRelation.getSubreddit().getPosts());
        }

        return subredditPosts;
    }

    public static Subreddit searchSubreddit(String username) {

        for (Subreddit subreddit: subredditDatabase) {
            if (subreddit.getUsername().equalsIgnoreCase(username)) {
                return subreddit;
            }
        }

        return null;
    }
}
