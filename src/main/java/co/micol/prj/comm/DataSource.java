package co.micol.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {  //Mybatis를 활용하는 DataSource 객체
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {}   //외부에서 생성 할 수 없도록 Private 생성자를 만듦
	
	public static SqlSessionFactory getInstance() {
		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return sqlSessionFactory;
	}
}
