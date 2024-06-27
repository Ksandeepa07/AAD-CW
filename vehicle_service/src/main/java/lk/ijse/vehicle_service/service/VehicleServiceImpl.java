package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.entity.User;
import lk.ijse.vehicle_service.entity.Vehicle;
import lk.ijse.vehicle_service.repo.VehicleRepo;
import lk.ijse.vehicle_service.service.exception.DuplicateRecordException;
import lk.ijse.vehicle_service.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getV_id())){
            throw new DuplicateRecordException("This vehicle id is already exist!!!");
        }
        return mapper.map(vehicleRepo.save(mapper.map(vehicleDTO,Vehicle.class)),VehicleDTO.class);
    }

    @Override
    public VehicleDTO update(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getV_id())){
            return mapper.map(vehicleRepo.save(mapper.map(vehicleDTO,Vehicle.class)),VehicleDTO.class);
        }

        throw new NotFoundException("can't find vehicle with this id!!");

    }

    @Override
    public boolean delete(Integer vehicleId) {
        if (vehicleRepo.existsById(vehicleId)){
            vehicleRepo.deleteById(vehicleId);
            return true;
        }

        throw new NotFoundException("Can't find user with this id!!");

    }
}
