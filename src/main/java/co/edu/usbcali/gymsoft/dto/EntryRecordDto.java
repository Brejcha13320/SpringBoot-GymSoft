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
public class EntryRecordDto {
    private Integer entryRecordId;
    private ClientMembershipDto clientMembership;
    private Date entryDate;
}
