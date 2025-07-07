package boot.mvc.dto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MycarInter extends JpaRepository<MycarDto , Long> {

}
