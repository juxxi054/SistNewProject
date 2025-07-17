package thyme.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import thyme.data.dto.CarDto;

public interface CarDaoInter extends JpaRepository<CarDto, Long>{

}