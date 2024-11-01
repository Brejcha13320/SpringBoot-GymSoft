package co.edu.usbcali.gymsoft.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id")
    private Integer membershipId;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "cost", columnDefinition = "float default 0", nullable = false)
    private Float cost;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private Boolean enabled;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany
    @JoinColumn(name = "membership_id", referencedColumnName = "membership_id")
    @JsonBackReference
    private List<ClientMembership> clientMemberships;

    /*@ManyToMany
    @JoinTable(
            name = "clients_memberships",
            joinColumns = @JoinColumn(name = "membership_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Membership> courses = new HashSet<>();*/
}
