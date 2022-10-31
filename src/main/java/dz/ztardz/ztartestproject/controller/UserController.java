package dz.ztardz.ztartestproject.controller;

import dz.ztardz.ztartestproject.dto.UserRequestDto;
import dz.ztardz.ztartestproject.dto.UserResponseDto;
import dz.ztardz.ztartestproject.service.UserServiceImpl;
import dz.ztardz.ztartestproject.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody() UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.save(userRequestDto);
        return new ResponseEntity<>(userResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Integer id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/loginuser/{loginuser}")
    public ResponseEntity<UserResponseDto> findByLoginUser(@PathVariable("loginuser") String loginUser) {
        UserResponseDto userResponseDto = userService.findByLoginUser(loginUser);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> update(@Valid @RequestBody() UserRequestDto usertRequestDto,@PathVariable("id") Integer id) {
        UserResponseDto userResponseDto = userService.update(usertRequestDto, id);
        return ResponseEntity.accepted().body(userResponseDto);
    }
}
