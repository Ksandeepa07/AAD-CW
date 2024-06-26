package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;

public interface VehicleService {
    VehicleDTO save(VehicleDTO vehicleDTO);
    VehicleDTO update(VehicleDTO vehicleDTO);
    boolean delete(String vehicleId);
}
