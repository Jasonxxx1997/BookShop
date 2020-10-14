package xjx.dao.imp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import xjx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //一些通用的数据库操作
    private QueryRunner queryrunner = new  QueryRunner();
    /**
     * 通用的增删改操作
     */
    public int update(String sql,Object...args){
        Connection conn =JdbcUtils.getConnection();
        try {
            return queryrunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }
    /**
     * 查询返回一个对象
     */
    public <T> T queryForOne(String sql, Class<T> type, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryrunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
    /**
     * 查询返回多条记录
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryrunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
    /**
     * 分组函数查询
     */
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryrunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
