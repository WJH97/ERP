package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.mapper.TechnologyMapper;
import com.erp.web4j.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/3 Time 19:38
 */
@Service("technologyService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class TechnologyServiceImpl implements TechnologyService {


    // 注入mapper
    @Autowired
    TechnologyMapper technologyMapper;



    @Override
    public List<Technology> findTechnology(Integer page, Integer rows) {
        return technologyMapper.findTechnology((page-1)*rows,rows);
    }

    @Override
    public List<Technology> searchByPrimaryKey(String  searchValue, Integer page, Integer rows) {
        return technologyMapper.searchByPrimaryKey(searchValue,(page-1)*rows,rows);

    }

    @Override
    public List<Technology> searchByName(String  searchValue, Integer page, Integer rows) {
        return technologyMapper.searchByName(searchValue,(page-1)*rows,rows);
    }

    /**
     * 插入操作
     * @param technology
     * @return 返回true，插入成功  返回false ， 插入失败
     */
    @Override
    public boolean insert(Technology technology) {
        Technology selectByPrimaryKey = technologyMapper.selectByPrimaryKey(technology.getTechnologyId());
        if(selectByPrimaryKey==null) {
            int i = technologyMapper.insert(technology);
            return i == 1;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Technology technology) {

        int i = technologyMapper.updateByPrimaryKey(technology);
        return i==1;
    }

    @Override
    public boolean deleteBatch(int [] ids) {
       /* for (int i = 0; i < ids.length; i++) {
            int i1 = technologyMapper.deleteByPrimaryKey(ids[i]);
        }*/
        int i = technologyMapper.deleteBatch(ids);
        if(i == ids.length) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Technology selectTechnologyById(String technologyName) {
        Technology technology =  technologyMapper.searchByName3(technologyName);
        return technology;
    }


}
