package com.simplilearn.util;


import org.springframework.data.domain.Page;

import com.simplilearn.model.User;

public class UserPager {

    private final Page<User> users;

    public UserPager(Page<User> users) {
        this.users = users;
    }

    public int getPageIndex() {
        return users.getNumber() + 1;
    }

    public int getPageSize() {
        return users.getSize();
    }

    public boolean hasNext() {
        return users.hasNext();
    }

    public boolean hasPrevious() {
        return users.hasPrevious();
    }

    public int getTotalPages() {
        return users.getTotalPages();
    }

    public long getTotalElements() {
        return users.getTotalElements();
    }

    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
    }

}