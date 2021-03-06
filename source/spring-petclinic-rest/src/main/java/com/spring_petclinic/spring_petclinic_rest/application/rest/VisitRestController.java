package com.spring_petclinic.spring_petclinic_rest.application.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring_petclinic.spring_petclinic_rest.application.models.PetVisitDTO;
import com.spring_petclinic.spring_petclinic_rest.application.models.VisitCreateDTO;
import com.spring_petclinic.spring_petclinic_rest.application.models.VisitUpdateDTO;
import com.spring_petclinic.spring_petclinic_rest.application.services.VisitRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.spring_petclinic.spring_petclinic_rest.application.models.VisitDTO;

@RestController
@RequestMapping("/api/visits")
@Api(value = "VisitRestController")
@AllArgsConstructor
public class VisitRestController {
    private final VisitRestService visitRestService;

    @GetMapping("/{visitId}")
    @ApiOperation(value = "getVisit")
    public ResponseEntity<VisitDTO> getVisit(@PathVariable(value = "visitId") Integer visitId) {
        final VisitDTO result = visitRestService.getVisit(visitId);
        if (result == null) {
            return new ResponseEntity<VisitDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "addVisit")
    public ResponseEntity<Void> addVisit(@RequestBody VisitCreateDTO dto) {
        visitRestService.addVisit(dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{visitId}")
    @ApiOperation(value = "updateVisit")
    public ResponseEntity<Void> updateVisit(@PathVariable(value = "visitId") Integer visitId, @RequestBody VisitUpdateDTO dto) {
        visitRestService.updateVisit(visitId, dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{visitId}")
    @ApiOperation(value = "deleteVisit")
    public ResponseEntity<Void> deleteVisit(@PathVariable(value = "visitId") Integer visitId) {
        visitRestService.deleteVisit(visitId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}