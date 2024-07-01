package lk.ijse.vehicle_service.controller;

import jakarta.validation.Valid;
import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleService;
import lk.ijse.vehicle_service.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RestTemplate restTemplate;

    public VehicleController() {
        System.out.println("Vehicle Controller Instantiated");
    }

    @PostMapping("/save")
    public VehicleDTO save(@Valid @RequestBody VehicleDTO vehicleDTO){

        try {
            System.out.println(vehicleDTO);
            Boolean isExist = restTemplate.getForObject("http://USER-SERVICE/api/v1/users/findById/"+vehicleDTO.getU_id(), Boolean.class);
            if (Boolean.TRUE.equals(isExist)){
                return vehicleService.save(vehicleDTO);
            }
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

        return null;
    }

    @PatchMapping("/update")
    public VehicleDTO update(@Valid @RequestBody VehicleDTO vehicleDTO){

        try {
            System.out.println(vehicleDTO);
            Boolean isExist = restTemplate.getForObject("http://USER-SERVICE/api/v1/users/findById/"+vehicleDTO.getU_id(), Boolean.class);
            if (Boolean.TRUE.equals(isExist)){
                return vehicleService.update(vehicleDTO);
            }

        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

        return null;
    }

    @DeleteMapping("/delete/{vehicleId}")
    public boolean delete(@PathVariable Integer vehicleId){

        try {
            System.out.println(vehicleId);
            return vehicleService.delete(vehicleId);

        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

    }

    @GetMapping("/findById/{vehicleId}")
    public Boolean findById(@PathVariable Integer vehicleId){
        System.out.println("vehicle id is "+vehicleId);
        return vehicleService.existById(vehicleId);

    }
}
