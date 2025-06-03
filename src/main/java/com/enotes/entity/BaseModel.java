package com.enotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {

     private boolean  isActive;
     private boolean isDeleted;
     private Integer createdBy;
     @Temporal(TemporalType.TIMESTAMP)
     private Date createdAt;
     private Integer updateBy;
     private Date updateDate;

     @PrePersist
     protected void onCreate() {
          this.createdAt = new Date();
          this.isDeleted = false;
          this.isActive = true;
     }

     @PreUpdate
     protected void onUpdate() {
          this.updateDate = new Date();
     }
}
