package org.javaguru.travel.insurance.core.api.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import org.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelCalculatePremiumCoreResult {

    private List<ValidationErrorDTO> errors;

    private AgreementDTO agreement;

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }

}
