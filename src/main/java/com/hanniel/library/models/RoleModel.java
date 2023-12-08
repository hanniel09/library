package com.hanniel.library.models;

import com.hanniel.library.enums.RoleName;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Entity
@Table(name = "RoleModel")
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
