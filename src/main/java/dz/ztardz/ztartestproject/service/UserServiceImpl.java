package dz.ztardz.ztartestproject.service;

import dz.ztardz.ztartestproject.dto.UserRequestDto;
import dz.ztardz.ztartestproject.dto.UserResponseDto;
import dz.ztardz.ztartestproject.exception.NotFoundException;
import dz.ztardz.ztartestproject.model.Users;
import dz.ztardz.ztartestproject.repository.UsersRepositoryInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("v1")
public class UserServiceImpl implements UserServiceInterface{
    @Autowired
    private UsersRepositoryInterface userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*public UserServiceImpl(UsersRepositoryInterface userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }*/

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        Users user = modelMapper.map(userRequestDto,Users.class);
        Users saved = userRepository.save(user);
        return modelMapper.map(saved,UserResponseDto.class);
    }

    @Override
    public UserResponseDto findById(Integer idUser) {
        Users user = userRepository.findById(idUser).orElseThrow(() -> new NotFoundException("User not Found"));
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public UserResponseDto findByLoginUser(String loginUser) {
        Users user = userRepository.findByLoginUser(loginUser);
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public void delete(Integer idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public UserResponseDto update(UserRequestDto clientRequestDto, Integer idUser) {
        Optional<Users> userOptional = userRepository.findById(idUser);
        if (userOptional.isPresent()){
            Users user = modelMapper.map(clientRequestDto,Users.class);
            user.setIdUser(idUser);
            Users updated = userRepository.save(user);
            return modelMapper.map(user,UserResponseDto.class);
        }
        else{
            throw new NotFoundException("User not Found");
        }
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(el -> modelMapper.map(el,UserResponseDto.class)).collect(Collectors.toList());
    }
}
