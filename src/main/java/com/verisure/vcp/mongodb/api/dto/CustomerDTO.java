package com.verisure.vcp.mongodb.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer DTO object
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO extends BaseDTO {

    @Schema(description = "Customer first name", required = true)
    public String firstName;
    
    @Schema(description = "Customer last name", required = true)
    public String lastName;

}
