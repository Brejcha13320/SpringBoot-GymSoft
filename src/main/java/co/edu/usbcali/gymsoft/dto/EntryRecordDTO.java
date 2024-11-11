package co.edu.usbcali.gymsoft.dto;

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

    //EntryRecord depende de ClientMembership
    private Integer clientMembershipId;
}
