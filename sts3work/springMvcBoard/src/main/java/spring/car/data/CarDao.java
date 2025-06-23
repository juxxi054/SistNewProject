package spring.car.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements CarDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<CarDto> getAllCarList() {
		// TODO Auto-generated method stub
		return session.selectList("getAllOfMyCar");
	}

}