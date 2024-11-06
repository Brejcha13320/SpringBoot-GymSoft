package co.edu.usbcali.gymsoft.dto;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntryRecordDTO {
    private Integer entryRecordId;
    private Date entryDate;
    private Integer clientMembershipId;
}
