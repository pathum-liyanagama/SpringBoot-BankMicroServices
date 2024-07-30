package com.pathum.bank.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // This class will act as superclass to all entities
@EntityListeners(AuditingEntityListener.class) // Autofill audit columns like CreatedDate, CreatedBy etc
@Getter
@Setter
@ToString
public class BaseEntity {

    @CreatedDate // Automatically add current datetime for audit column createdAt
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy // class AuditAwareImpl contains the logic to identify user
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
