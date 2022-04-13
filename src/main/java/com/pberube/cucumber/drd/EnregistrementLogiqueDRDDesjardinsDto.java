package com.pberube.cucumber.drd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnregistrementLogiqueDRDDesjardinsDto {
    public static final int NOMBRE_SEGMENTS_PAR_ENREGISTREMENT = 6;
    private String typeEnregistrementLogique;
    private List<SegmentDRDDto> segments;

}
