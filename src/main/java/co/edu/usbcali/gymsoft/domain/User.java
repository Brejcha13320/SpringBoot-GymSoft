package co.edu.usbcali.gymsoft.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username",length = 100, nullable = false)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "role", length = 50, nullable = false)
    private String role;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private Boolean enabled;

    //@Column(name = "created_at", updatable = false)
    @Column(name = "created_at")

    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /*@PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
    */

}