package com.verisure.vcp.mongodb.api.controller.feign;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.verisure.vcp.mongodb.api.dto.ItemDTO;
import com.verisure.vcp.mongodb.client.FeignClientExample;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;



/**
 * Sample controller used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Slf4j
@RestController
@RequestMapping("/feign")
@Tag(name = "Feign demo")
public class FeignController {

    @Autowired
    private FeignClientExample feingClient;

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/feign", method = RequestMethod.GET)
    @ResponseBody
    @Operation(
            description = "Feign:: view the list of ALL application items",
            responses = {
                    @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = ItemDTO.class))), responseCode = "200")
            }
    )
    public List<ItemDTO> getItemsWithFeign() {
        LOGGER.debug("getItemsWithFeign::Trying to retrieve all items");
        List<ItemDTO> items = feingClient.getItems();
        return items;
    }
       
}
