package co.edu.usbcali.gymsoft.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "client_membership_id")
    private Integer clientMembershipId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "remaining_days")
    private Integer remainingDays;

    @Column
    private Integer quantity;

    @Column
    private Float cost;

    @Column
    private Float price;

    @Column
    private Boolean enabled;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
