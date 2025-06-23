package spring.board.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends SqlSessionDaoSupport implements BoardDaoInter {

	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		
		return getSqlSession().selectOne("");
	}
	
}
