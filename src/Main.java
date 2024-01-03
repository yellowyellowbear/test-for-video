import com.example.po.Bucket;
import com.example.po.Filee;
import com.example.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
            InputStream config= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf= new SqlSessionFactoryBuilder().build(config);
            SqlSession ss=ssf.openSession();


            List<Filee> filees =ss.selectList("com.example.mapper.FileMapper.selectID",1);
            System.out.println(filees);


            ss.commit();
            ss.close();
//use for video
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
