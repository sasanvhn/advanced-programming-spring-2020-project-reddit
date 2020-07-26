package com.Reddit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Post {

    private String title;
    private String imageUrl;
    private String body;
    private Date publishDate = new Date();

    private ArrayList<Interaction> interactions;

/*    public Post(String title, String imageUrl, String body) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.body = body;
        this.interactions = new ArrayList<>();
    }

    // image is optional
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        this.interactions = new ArrayList<>();
    }*/

    // in reddit image and body are optional -> we can set them later
    public Post(String title) {
        this.title = title;
        this.interactions = new ArrayList<>();
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User postSender(Post post) {

        for (User user: User.userDatabase) {
            for (Post userPost: user.getPosts()) {
                if (userPost.equals(post)) {
                    return user;
                }
            }
        }
        return null;
    }

    public void showPost() {
        // tbd: showPost exactly like reddit
        User sender = postSender(this);
        System.out.println("Posted by " + sender.getUsername());
        System.out.println("\t" + title);
        System.out.println(body);
    }

    public void addInteraction(Interaction interaction) {

        interactions.add(interaction);
    }

    public static List<Post> postsForUser(User user) { // posts gonna show in home according to "USERS" and "SUBREDDITS" followed

        ArrayList<Post> userPosts = new ArrayList<>(user.getPosts()); // initialized with users own posts

        for(UserToUserRelation userToUserRelation : user.getUserToUserRelations()) { // users followed
            userPosts.addAll(userToUserRelation.getUser().getPosts());
        }

        for(UserToSubredditRelation userToSubredditRelation : user.getUserToSubredditRelations()) { // subreddits followed
            userPosts.addAll(userToSubredditRelation.getSubreddit().getPosts());
        }


        userPosts.sort(Comparator.comparingInt(Post::countScores)); // sorting according to score

        return userPosts;
    }



    public static void showPostForUser(User user) {

        List<Post> userPosts = postsForUser(user);

        if (userPosts.isEmpty()) {
            System.out.println("No posts yet!");
        } else {
            for (int i = 0; i < userPosts.size(); i++) {
                System.out.println((i+1) + ". ");
                userPosts.get(i).showPost();
                System.out.println();
            }
        }
    }

    public int countScores() {

        int count = 0;
        for(Interaction interaction: interactions) {

            if (interaction instanceof  Score) {
                if (interaction instanceof Upvote) {
                    ++count;
                }
                else if (interaction instanceof  Downvote) {
                    --count;
                }
            }
        }
        return count;
    }

    public int countComments() {

        int count = 0;
        for (Interaction interaction: interactions) {

            if(interaction instanceof Comment ) {
                count+=((Comment) interaction).countComments();
                ++count;
            }
        }
        return count;
    }

    public static List<Post> userPosts(User user) { //posts for specific user

        ArrayList<Post> userPosts = new ArrayList<>(user.getPosts());

        userPosts.sort(Comparator.comparingInt(Post::countScores)); // sorting according to score

        return userPosts;
    }

}
