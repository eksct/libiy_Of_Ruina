package Servlet.imp;


import Servlet.BorrowingService;
import Util.Util;
import mapper.BorrowingMapper;
import mapper.TesMapper;
import obj.Borrowing;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
* @author g
* @description 针对表【borrowing】的数据库操作Service实现
* @createDate 2023-05-30 12:06:54
*/
public class BorrowingServiceImpl extends ServiceImpl implements BorrowingService{

    @Override
    public List<Borrowing> getBorrowings() {
        try(SqlSession sqlSession = Util.mysqlConnection(true)) {
            BorrowingMapper mapper = sqlSession.getMapper(BorrowingMapper.class);
            return mapper.selectBorrowing();
        }
    }

    /**
     * @return
     */
    @Override
    public boolean Insert(Borrowing bor) {
        try(SqlSession sqlSession = Util.mysqlConnection(true)){
            return sqlSession.getMapper(BorrowingMapper.class).INSERT(bor)>0;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int Delete(String id) {
        try(SqlSession sqlSession = Util.mysqlConnection(true)){
            return sqlSession.getMapper(BorrowingMapper.class).DELETE(id);
        }
    }
}




