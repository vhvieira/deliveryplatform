package app.biker.dto;

import app.biker.Biker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BikerMapper {

    @Autowired
    ModelMapper modelMapper;

    public BikerGetDTO bikerToBikerGetDTO(Biker biker) {
        return modelMapper.map(biker, BikerGetDTO.class);
    }

    public Biker bikerGetDTOToBiker(BikerGetDTO bikerDTO) {
        return modelMapper.map(bikerDTO, Biker.class);
    }

    public List<BikerGetDTO> bikersToBikerGetDTO(List<Biker> bikerList) {
        return bikerList.stream()
                .filter(Objects::nonNull)
                .map(this::bikerToBikerGetDTO)
                .collect(Collectors.toList());
    }

    public Biker bikerUpdateDTOToBiker(BikerUpdateDTO updateDTO) { return modelMapper.map(updateDTO, Biker.class); }


}
