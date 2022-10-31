package dz.ztardz.ztartestproject.service;

import dz.ztardz.ztartestproject.dto.UserRequestDto;
import dz.ztardz.ztartestproject.dto.UserResponseDto;

import java.util.List;

public interface UserServiceInterface {
    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto findById(Integer idUser);

    UserResponseDto findByLoginUser(String loginUser);

    void delete(Integer idUser);

    UserResponseDto update(UserRequestDto clientRequestDto,Integer idUser);

    List<UserResponseDto> findAll();
}
