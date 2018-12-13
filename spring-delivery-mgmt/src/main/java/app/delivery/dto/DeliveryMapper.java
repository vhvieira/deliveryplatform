package app.delivery.dto;

import app.delivery.Delivery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DeliveryMapper {

    @Autowired
    ModelMapper modelMapper;

    public DeliveryGetDTO deliveryToDeliveryGetDTO(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryGetDTO.class);
    }

    public List<DeliveryGetDTO> deliveriesToDeliveryGetDTOList(List<Delivery> deliveryList) {
        return deliveryList.stream()
                .filter(Objects::nonNull)
                .map(this::deliveryToDeliveryGetDTO)
                .collect(Collectors.toList());
    }

}
