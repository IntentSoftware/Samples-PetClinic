package com.spring_petclinic.spring_petclinic_rest.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.spring_petclinic.spring_petclinic_rest.domain.models.Visit;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetVisitDTO {
    private int id;
    private java.time.LocalDate visitDate;
    private String description;

    public static PetVisitDTO mapFromVisit(Visit visit, ModelMapper mapper) {
        return mapper.map(visit, PetVisitDTO.class);
    }

    public static List<PetVisitDTO> mapFromVisits(Collection<Visit> visits, ModelMapper mapper) {
        return visits
            .stream()
            .map(visit -> PetVisitDTO.mapFromVisit(visit, mapper))
            .collect(Collectors.toList());
    }
}