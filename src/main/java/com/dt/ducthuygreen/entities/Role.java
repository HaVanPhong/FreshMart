package com.dt.ducthuygreen.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Role")
@Transactional
public class Role extends BaseModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4124841846465023072L;

	@Column(name = "role_name", nullable = false)
    private String roleName;

  //link to table Users
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
    
    public Role() {}
    
    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Long id, Boolean deleted, Date createdDate, String createdBy, Date updatedDate, String updatedBy,
			String roleName, Set<User> users) {
		super(id, deleted, createdDate, createdBy, updatedDate, updatedBy);
		this.roleName = roleName;
		this.users = users;
	}

	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
