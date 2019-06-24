package com.learnrest.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class Todo {

    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

    public Todo(long id, String username, String description, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;

        this.targetDate = new Date();

        this.isDone = isDone;
    }

    public Todo() {
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getTargetDate() {
        return this.targetDate;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Todo)) return false;
        final Todo other = (Todo) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$targetDate = this.getTargetDate();
        final Object other$targetDate = other.getTargetDate();
        if (this$targetDate == null ? other$targetDate != null : !this$targetDate.equals(other$targetDate))
            return false;
        if (this.isDone() != other.isDone()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Todo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $targetDate = this.getTargetDate();
        result = result * PRIME + ($targetDate == null ? 43 : $targetDate.hashCode());
        result = result * PRIME + (this.isDone() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Todo(id=" + this.getId() + ", username=" + this.getUsername() + ", description=" + this.getDescription() + ", targetDate=" + this.getTargetDate() + ", isDone=" + this.isDone() + ")";
    }

//    public Todo(long id, String username, String description, boolean isDone) {
//        this(id,username,description,new Date(), isDone);
//    }
}
