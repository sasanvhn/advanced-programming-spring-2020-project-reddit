package com.Reddit;

import java.util.ArrayList;
import java.util.List;

public class Comment extends Interaction {

    private String text;

    private List<Interaction> interactions;

    public Comment(User user, String text) {
        super(user);
        this.text = text;
        this.interactions = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void addInteraction(Interaction interaction) {

        interactions.add(interaction);
    }

    private static Comment comment(User user, Post post, String text) {

        Comment newComment = new Comment(user, text);

        post.addInteraction(newComment);

        return newComment;
    }

    private static Comment replyComment(User user, Comment comment, String text) {

        Comment newComment = new Comment(user, text);

        comment.addInteraction(newComment);

        return newComment;
    }

    public void showComment() {
        // tbd: showComment exactly like reddit
        System.out.println(getUser().getUsername() + ": " + text);
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
                ((Comment) interaction).countComments();
                ++count;
            }
        }
        return count;
    }

}
