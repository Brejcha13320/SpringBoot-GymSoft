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
@Table(name = "clients_memberships")
public class ClientMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_membership_id")
    private Integer clientMembershipId;

    @Column(name = "client_id")
    private Date clientId;

    @Column(name = "membership_id", nullable = false)
    private Date membershipId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "remaining_days", nullable = false, columnDefinition = "integer default 0")
    private Integer remainingDays;

    @Column(name = "quantity", nullable = false, columnDefinition = "integer default 0")
    private Integer quantity;

    @Column(name = "cost", nullable = false, columnDefinition = "float default 0")
    private Float cost;

    @Column(name = "price", nullable = false, columnDefinition = "float default 0")
    private Float price;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private Boolean enabled;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "membership_id", referencedColumnName = "membership_id")
    private Membership membership;
}