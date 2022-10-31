package dz.ztardz.ztartestproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Integer idUser;
    private Integer idParams;
    private Integer idFretagence;
    private Integer idFretcentre;
    private String loginUser;
    private String passwordUser;
    private boolean enabled;
    private String profilUser;
    private String ipUser;
    private String nameUser;
    private String functionUser;
}
