package com.Reddit;

public class UserToSubredditRelation {

    private Subreddit subreddit;

    public UserToSubredditRelation(Subreddit subreddit) {
        this.subreddit = subreddit;
    }

    public Subreddit getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(Subreddit subreddit) {
        this.subreddit = subreddit;
    }
}
