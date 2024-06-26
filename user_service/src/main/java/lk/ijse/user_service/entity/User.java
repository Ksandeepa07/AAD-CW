package lk.ijse.user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int u_id;
    @Column(unique = true)
    private String email;
    private String password;
}
