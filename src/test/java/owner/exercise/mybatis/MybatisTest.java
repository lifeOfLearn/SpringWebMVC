package owner.exercise.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class MybatisTest {

	@Test
	public void test() {
		//第一步：獲得SqlSession對象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        //執行SQL
        //方式一：getMapper：獲取映射器，也就是獲取xml文件中的mapper配置
        //這裡使用(UserDao.class)是透過反射，獲取Mapper中的UserDao實例
        Dao dao = sqlSession.getMapper(Dao.class);
        //創建UserDao實例後，執行其中的方法
        List<StoreSales> userList = dao.getAllUser(); 

        for(StoreSales user : userList){
            System.out.println(user);
        }
        sqlSession.close();
	}
}
