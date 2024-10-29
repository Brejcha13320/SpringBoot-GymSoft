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
@Table(name = "entry_records")
public class EntryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_record_id")
    private Integer entryRecordId;

    @OneToOne
    @JoinColumn(name = "client_membership_id", referencedColumnName = "client_membership_id")
    private ClientMembership clientMembership;

    @Column(name = "entry_date")
    private Date entryDate;
}
