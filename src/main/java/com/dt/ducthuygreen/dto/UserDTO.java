package com.dt.ducthuygreen.dto;

import java.util.Set;

import com.dt.ducthuygreen.entities.BaseModel;
import com.dt.ducthuygreen.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO extends BaseModel {
	private String userName;

    private String password;

    private String email;

    private String fullName;

    private String description;

    private Integer status;

    
    private Set<Role> roles;

}
