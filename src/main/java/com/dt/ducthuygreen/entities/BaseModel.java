package com.dt.ducthuygreen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "is_deleted")
    protected Boolean deleted;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdDate;

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    protected String createdBy;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updatedDate;

    @Column(name = "updated_by")
    @LastModifiedBy
    protected String updatedBy;

}
