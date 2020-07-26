package com.Reddit;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private String email;

    private List<Post> posts;
    private List<UserToUserRelation> userToUserRelations;
    private List<UserToSubredditRelation> userToSubredditRelations;

    public static List<User> userDatabase = new ArrayList<>();

    private User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.posts = new ArrayList<>();
        this.userToUserRelations = new ArrayList<>();
        this.userToSubredditRelations = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<UserToUserRelation> getUserToUserRelations() {
        return userToUserRelations;
    }

    public List<UserToSubredditRelation> getUserToSubredditRelations() {
        return userToSubredditRelations;
    }

    private void addPost(Post post) {
        posts.add(post);
    }

    private void addFollower(UserToUserRelation follower) {
        userToUserRelations.add(follower);
    }

    // unfollow : to do after user to user relations is done
    private void removeFollower(UserToUserRelation follower) {
        userToUserRelations.remove(follower);
    }

    private void subscribeSubreddit(UserToSubredditRelation subscriber) {
        userToSubredditRelations.add(subscriber);
    }

    private void removeSubscriber(UserToSubredditRelation subscriber) {
        userToSubredditRelations.remove(subscriber);
    }

    private static User createUser(String username, String password, String email) {
        return new User(username, password, email);
    }

    public static User signUp(String username, String password, String email) {

        // checking if the wanted username is already taken
        for (User user: userDatabase) {
            if (user.getUsername().equalsIgnoreCase(username) || user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Entered username or email is already taken!");
                return null;
            }
        }

        User newUser = User.createUser(username, password, email);
        userDatabase.add(newUser);

        return newUser;
    }

    public static User login(String username, String password) {

        for (User user: userDatabase) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) { // equals ignore case is for upper and lower letters
                    return user;
            }
        }

        return null; // in case of entered username and password does not exist in users database
    }

    public static User searchUser(String username) {

        for (User user: userDatabase) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }

    public boolean follow(String username) {

        User userToFollow = searchUser(username);

        if (userToFollow != null) {
            UserToUserRelation newUserToUserRelation = new UserToUserRelation(userToFollow);
            addFollower(newUserToUserRelation);
            return true;
        } else {
            return false;
        }
    }

    public boolean unFollow(String username) {

        for (UserToUserRelation userToUserRelation: userToUserRelations) {
            if (userToUserRelation.getUser().getUsername().equalsIgnoreCase(username)) {
                removeFollower(userToUserRelation);
                return true;
            }
        }
        return false;
    }

/*    public void post(String title, String body) {

        Post newPost = new Post(title, body);
        this.posts.add(newPost);
    }*/

    public Post post(String title) {

        Post newPost = new Post(title);
        this.posts.add(newPost);

        return newPost;
    }

/*    public void post(String title, String imageUrl, String body) {

        Post newPost = new Post(title, imageUrl, body);
        this.posts.add(newPost);
    }*/

    public boolean hasFollowed(User user) {

        for (UserToUserRelation userToUserRelation: userToUserRelations) {
            if (userToUserRelation.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSubscribed(Subreddit subreddit) {

        for (UserToSubredditRelation userToSubredditRelation: userToSubredditRelations) {
            if (userToSubredditRelation.getSubreddit().getUsername().equalsIgnoreCase(subreddit.getUsername())) {
                return true;
            }
        }
        return false;
    }

      //after subreddit is done
    public Subreddit makeSubreddit(String username, String subredditName) {

        // checking if the wanted username is already taken
        for (Subreddit subreddit: Subreddit.subredditDatabase) {
            if (subreddit.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Entered username is already taken!");
                return null;
            }
        }

        Subreddit newSubreddit = Subreddit.createSubreddit(subredditName, username);
        Subreddit.subredditDatabase.add(newSubreddit);

        return newSubreddit;
    }

    public boolean subscribe(String username) { //username here means a unique id for subreddit which is subredditname

        Subreddit foundSubreddit = Subreddit.searchSubreddit(username);

        if (foundSubreddit != null) {
            UserToSubredditRelation newUserToSubredditRelation = new UserToSubredditRelation(foundSubreddit);
            subscribeSubreddit(newUserToSubredditRelation);
            return true;
        } else {
            return false;
        }
    }

    public boolean unSubscribe(String username) {

        for (UserToSubredditRelation userToSubredditRelation: userToSubredditRelations) {
            if (userToSubredditRelation.getSubreddit().getUsername().equalsIgnoreCase(username)) {
                removeSubscriber(userToSubredditRelation);
                return true;
            }
        }
        return false;
    }

    //add posts to subreddit
    public boolean addPostToSubreddit(String username, String title) {

        Subreddit foundSubreddit = Subreddit.searchSubreddit(username);

        if (foundSubreddit != null) {
            foundSubreddit.getPosts().add(post(title));
            return true;
        } else {
            return false;
        }
    }

    // sendMessage (hoselam nmishe fek konam (-_-) )

}
