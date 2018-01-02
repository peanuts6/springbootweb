package xqy.msa.springbootweb.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xqy on 18/1/1.
 */

@MappedJdbcTypes(JdbcType.VARCHAR)
public class AuthorityTypeHandler extends BaseTypeHandler<SimpleGrantedAuthority>
{
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SimpleGrantedAuthority simpleGrantedAuthority, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,simpleGrantedAuthority.getAuthority());
    }

    @Override
    public SimpleGrantedAuthority getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new SimpleGrantedAuthority(resultSet.getString(s));
    }

    @Override
    public SimpleGrantedAuthority getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new SimpleGrantedAuthority(resultSet.getString(i));
    }

    @Override
    public SimpleGrantedAuthority getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new SimpleGrantedAuthority(callableStatement.getString(i));
    }
}
