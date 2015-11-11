package cn.qtone.business.client.mapperclient;

import cn.qtone.business.model.Criteria;
import cn.qtone.business.model.User;
import java.util.List;

/**
 * user
 * @version 1.0 2015-11-10
 * @powerby hetgyd 
 */
public interface UserMapperClient {
    int countByExample(Criteria example);

    User selectByPrimaryKey(Integer userId);

    List<User> selectByExample(Criteria example);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByExample(Criteria example);

    int updateByExampleSelective(User record, Criteria example);

    int updateByExample(User record, Criteria example);

    int insert(User record);

    int insertSelective(User record);
}