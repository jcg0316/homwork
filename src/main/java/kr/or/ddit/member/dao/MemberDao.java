package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoInf {

	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDao(){
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* Method : getLogData
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 : 로그인에 필요한 아이디,비밀번호 얻어오는 메소드 
	 */
	@Override
	public MemberVO getLogData(MemberVO mvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberVO MemberVO = sqlSession.selectOne("member.getLogData",mvo);
		sqlSession.close();
		
		return MemberVO;
	}

}
