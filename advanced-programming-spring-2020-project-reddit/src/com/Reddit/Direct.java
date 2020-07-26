package com.Reddit;

import java.util.List;

public class Direct {

    private User user;

    private List<String> messages;

    public Direct(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getMessages() {
        return messages;
    }

}
