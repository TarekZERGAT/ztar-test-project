package dz.ztardz.ztartestproject.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer idUser;

    @Column(name = "id_params")
    private Integer idParams;

    @Column(name = "id_fretagence")
    private Integer idFretagence;

    @Column(name = "id_fretcentre")
    private Integer idFretcentre;

    @Column(name = "login_user")
    private String loginUser;

    @Column(name = "password_user")
    private String passwordUser;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "profil_user")
    private String profilUser;

    @Column(name = "ip_user")
    private String ipUser;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "function_user")
    private String functionUser;
}