import Util.Util;
import mapper.BorrowingMapper;
import mapper.TesMapper;
import org.apache.ibatis.session.SqlSession;

public class Main {
    public static void main(String[] args) {
        SqlSession session = Util.mysqlConnection(true);
        BorrowingMapper mapper = session.getMapper(BorrowingMapper.class);
        System.out.println(mapper.selectBorrowing());
    }
}
