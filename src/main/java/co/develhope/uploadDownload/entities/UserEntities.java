package co.develhope.uploadDownload.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(indexes = {
    @Index(unique = true , name = "email_idx", columnList = "email")
})
public class UserEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firsName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String profilePicture;
}
