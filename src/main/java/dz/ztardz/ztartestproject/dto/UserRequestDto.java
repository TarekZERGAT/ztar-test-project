package dz.ztardz.ztartestproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotNull
    private Integer idParams;

    private Integer idFretagence;

    private Integer idFretcentre;

    @NotNull
    private String loginUser;

    @NotNull
    @Size(min = 3,max = 20,message = "le nombre de caractére doit etre compris entre 3 et 20")
    private String passwordUser;

    @NotNull
    private boolean enabled;

    @NotNull
    private String profilUser;

    private String ipUser;

    @NotNull
    private String nameUser;

    private String functionUser;
}
