package com.phos.freshvotes.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Folarin on 01/09/2020
 */

@Entity
public class Vote {

    @EmbeddedId
    private VoteId pk;
    private Boolean upvote;

    public VoteId getPk() {
        return pk;
    }

    public void setPk(VoteId pk) {
        this.pk = pk;
    }

    public Boolean getUpvote() {
        return upvote;
    }

    public void setUpvote(Boolean upvote) {
        this.upvote = upvote;
    }
}
