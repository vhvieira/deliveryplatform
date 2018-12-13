package app.biker;

import app.biker.dto.BikerGetDTO;
import app.biker.dto.BikerMapper;
import app.biker.dto.BikerSummaryDTO;
import app.biker.dto.BikerUpdateDTO;
import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rafael Leal on 20/10/2018.
 */
@Service
public class BikerServiceImpl implements BikerService {

    @Autowired
    private BikerRepository bikerRepository;

    @Autowired
    private BikerMapper bikerMapper;

    @Override
    public List<BikerGetDTO> listAllBikers() {
        List<Biker> bikers = bikerRepository.findByStatusCode(StatusCode.A);
        List<BikerGetDTO> bikersDTO = bikerMapper.bikersToBikerGetDTO(bikers);
        return bikersDTO;
    }

    @Override
    public List<BikerSummaryDTO> listAllBikersSummary() {
        return this.bikerRepository.getAllActiveBikersSummary();
    }

    @Override
    public BikerGetDTO getBikerById(Long id) {
        Optional<Biker> optBiker =  bikerRepository.findById(id);
        return optBiker.map(biker -> this.bikerMapper.bikerToBikerGetDTO(biker)).orElse(null);

    }

    @Override
    public Biker addBiker(Biker biker) {
        biker.setStatusCode(StatusCode.A);
        return bikerRepository.save(biker);
    }

    @Override
    public BikerGetDTO updateBiker(BikerUpdateDTO bikerUpdateDTO) {
        Biker biker = this.bikerMapper.bikerUpdateDTOToBiker(bikerUpdateDTO);
        biker = this.bikerRepository.save(biker);

        return this.bikerMapper.bikerToBikerGetDTO(biker);
    }

    @Override
    public void deleteBiker(Long id) {
        this.bikerRepository.updateStatusCodeByBikerId(id, StatusCode.D);
    }
}
