package co.edu.usbcali.gymsoft.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "remaining_days")
    private Integer remainingDays;

    @Column(name = "quantity", nullable = false, columnDefinition = "integer default 1")
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

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @JsonIgnoreProperties("clientMemberships")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "membership_id", referencedColumnName = "membership_id")
    @JsonIgnoreProperties("clientMemberships")
    private Membership membership;

    @Builder.Default
    @OneToMany(mappedBy = "clientMembership", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("clientMembership")
    private List<EntryRecord> entryRecords = new ArrayList<>();
}
