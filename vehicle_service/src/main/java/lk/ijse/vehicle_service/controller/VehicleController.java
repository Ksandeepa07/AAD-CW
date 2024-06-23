package lk.ijse.vehicle_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    public VehicleController() {
        System.out.println("Vehicle Controller Instantiated");
    }

    @GetMapping
    public String getVehicles(){
        return "Vehicle 1, Vehicle 2, Vehicle 3";
    }
}
