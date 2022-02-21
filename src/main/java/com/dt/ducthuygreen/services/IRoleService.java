package com.dt.ducthuygreen.services;

import org.springframework.stereotype.Service;

import com.dt.ducthuygreen.entities.Role;

public interface IRoleService {
	Role getRoleByName(String roleName);
}
