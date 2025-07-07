package boot.jpa.repojitery;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.jpa.dto.ShopDto;

public interface ShopDaoInter  extends JpaRepository<ShopDto,Long> {

}
