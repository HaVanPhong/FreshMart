package com.dt.ducthuygreen.services;

import java.util.List;

import com.dt.ducthuygreen.dto.SignupDTO;
import com.dt.ducthuygreen.dto.UserDTO;
import com.dt.ducthuygreen.dto.UserUpdateDTO;
import com.dt.ducthuygreen.dto.pagination.PaginateDTO;
import com.dt.ducthuygreen.entities.User;

public interface UserService {
	Long countAll();
	
	List<User> getAllUsers();

    User findById(Long userId);

    User findByUsername(String username);

    User create(UserDTO userDTO);

    User create(SignupDTO signUpDTO);

    User update(UserUpdateDTO userUpdateDTO, User currentUser);

    User update(User user);

    void deleteById(Long userId);

    void createAdminAccount(User user);

}
