package cn.qtone.services;

import cn.qtone.business.client.UserMapper;
import cn.qtone.business.client.mapperclient.UserMapperClient;
import cn.qtone.business.model.Criteria;
import cn.qtone.business.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user
 * @version 1.0 2015-11-10
 * @powerby hetgyd 
 */
@Service
public class UserService implements UserMapperClient {
    @Autowired
    private UserMapper userMapper;

    public int countByExample(Criteria example) {
        int count = this.userMapper.countByExample(example);
        return count;
    }

    public User selectByPrimaryKey(Integer userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    public List<User> selectByExample(Criteria example) {
        return this.userMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer userId) {
        return this.userMapper.deleteByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(Criteria example) {
        return this.userMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(User record, Criteria example) {
        return this.userMapper.updateByExampleSelective(record, example.getCondition());
    }

    public int updateByExample(User record, Criteria example) {
        return this.userMapper.updateByExample(record, example.getCondition());
    }

    public int insert(User record) {
        return this.userMapper.insert(record);
    }

    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }
}