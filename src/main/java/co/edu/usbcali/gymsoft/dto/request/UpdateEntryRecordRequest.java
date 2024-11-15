package co.edu.usbcali.gymsoft.dto.request;


import co.edu.usbcali.gymsoft.utils.validation.EntryRecordMessage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEntryRecordRequest {

    @NotNull(message = EntryRecordMessage.NOT_NULL_CLIENT_MEMBERSHIP_ID)
    private Integer clientMembershipId;

    private Date entryDate;
}
