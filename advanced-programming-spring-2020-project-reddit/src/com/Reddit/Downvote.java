package com.Reddit;

public class Downvote extends Score {

    public Downvote(User user) {
        super(user);
    }

    public static Downvote like(User user, Post post) {

        Downvote newDownvote = new Downvote(user);

        post.addInteraction(newDownvote);

        return newDownvote;
    }

    public static void disDownvote(User user, Post post) {

        for (Interaction interaction: post.getInteractions()) {

            if (interaction instanceof Downvote && interaction.getUser().getUsername().equals(user.getUsername())) {
                    post.getInteractions().remove(interaction);
                    return;
                }
        }
    }

    public static Downvote like(User user, Comment comment) {

        Downvote newDownvote = new Downvote(user);

        comment.addInteraction(newDownvote);

        return newDownvote;
    }

    public static void disDownvote(User user, Comment comment) {

        for (Interaction interaction: comment.getInteractions()) {

            if (interaction instanceof Downvote && interaction.getUser().getUsername().equals(user.getUsername())) {
                comment.getInteractions().remove(interaction);
                return;
            }
        }
    }
}
