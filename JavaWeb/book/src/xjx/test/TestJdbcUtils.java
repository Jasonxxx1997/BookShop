package xjx.test;

import org.junit.Test;
import xjx.utils.JdbcUtils;

public class TestJdbcUtils {
    @Test
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
        JdbcUtils.close(JdbcUtils.getConnection());
    }

}
