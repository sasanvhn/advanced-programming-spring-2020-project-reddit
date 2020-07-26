package com.Reddit;

public class Upvote extends Score {

    public Upvote(User user) {
        super(user);
    }

    public static Upvote like(User user, Post post) {

        Upvote newUpvote = new Upvote(user);

        post.addInteraction(newUpvote);

        return newUpvote;
    }

    public static void disUpvote(User user, Post post) {

        for (Interaction interaction: post.getInteractions()) {

            if (interaction instanceof Upvote && interaction.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                post.getInteractions().remove(interaction);
                return;
            }
        }
    }

    public static Upvote like(User user, Comment comment) {

        Upvote newUpvote = new Upvote(user);

        comment.addInteraction(newUpvote);

        return newUpvote;
    }

    public static void disDownvote(User user, Comment comment) {

        for (Interaction interaction: comment.getInteractions()) {

            if (interaction instanceof Upvote && interaction.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                comment.getInteractions().remove(interaction);
                return;
            }
        }
    }
}
