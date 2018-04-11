package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.PropertyCosts;
import com.jingye.repository.PropertyCostsRepository;
import com.jingye.service.PropertyCostsService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Service("propertyCostsService")
public class PropertyCostsServiceImpl implements PropertyCostsService {

    private static final Logger LOGGER = Logger.getLogger(PropertyCostsServiceImpl.class);

	@Autowired
	private PropertyCostsRepository propertyCostsRepository;

    @Override
    public int savePropertyCosts(PropertyCosts propertyCosts) {
        if(propertyCosts == null) {
            LOGGER.error("--> propertyCosts 不能为null！" );
            return 0;
        }
        if(propertyCosts.getId() == null) {
            LOGGER.error("--> propertyCosts id 不能为null！"  + propertyCosts);
            return 0;
        }
        return propertyCostsRepository.savePropertyCosts(propertyCosts);
    }

    @Override
    public int savePropertyCosts(List<PropertyCosts> propertyCostsList) {
        List<PropertyCosts> temppropertyCostsList = new ArrayList<>();
        for(PropertyCosts propertyCosts : propertyCostsList) {
            if(propertyCosts == null) {
                LOGGER.error("--> propertyCosts 不能为null！" );
                continue;
            }
            if(propertyCosts.getId() == null) {
                LOGGER.error("--> propertyCosts id 不能为null！"  + propertyCosts);
                continue;
            }
            temppropertyCostsList.add(propertyCosts);
        }
        return propertyCostsRepository.saveBatchPropertyCosts(temppropertyCostsList);
    }

    @Override
    public List<PropertyCosts> listPropertyCosts() {
        return propertyCostsRepository.listPropertyCosts();
    }

    @Override
    public List<PropertyCosts> listPropertyCostsByParam(PropertyCosts propertyCosts) {
        return propertyCostsRepository.listPropertyCostsByParam(propertyCosts);
    }

    @Override
    public PageInfoUtil<PropertyCosts> listPropertyCostsByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PropertyCosts> propertyCostsPage = new PageInfo<PropertyCosts>(propertyCostsRepository.listPropertyCosts());
        return new PageInfoUtil(propertyCostsPage.getList(), pageNum, pageSize, propertyCostsPage.getTotal());
    }

    @Override
    public PageInfoUtil<PropertyCosts> listPropertyCostsByParamAndPage(PropertyCosts propertyCosts, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PropertyCosts> propertyCostsPage = new PageInfo<PropertyCosts>(propertyCostsRepository.listPropertyCostsByParam(propertyCosts));
        return new PageInfoUtil(propertyCostsPage.getList(), pageNum, pageSize, propertyCostsPage.getTotal());
    }

    @Override
    public int deletePropertyCostsByParam(PropertyCosts propertyCosts) {
        return propertyCostsRepository.deletePropertyCostsByParam(propertyCosts);
    }

    @Override
    public int updatePropertyCostsByKey(PropertyCosts propertyCosts) {
        if(propertyCosts == null) {
            LOGGER.error("--> propertyCosts 不能为null！" );
            return 0;
        }
        if(propertyCosts.getId() == null) {
            LOGGER.error("--> propertyCosts id 不能为null！"  + propertyCosts);
            return 0;
        }
        return propertyCostsRepository.updatePropertyCostsByKey(propertyCosts);
    }

    @Override
    public int updatePropertyCostsByKey(List<PropertyCosts> propertyCostsList) {
        int successNum = 0;
        for(PropertyCosts propertyCosts : propertyCostsList) {
            successNum += updatePropertyCostsByKey(propertyCosts);
        }
        return successNum;
    }


    @Override
    public PropertyCosts getPropertyCostsByKey(Integer id) {
        return propertyCostsRepository.getPropertyCostsByKey(id);
    }

    @Override
    public List<PropertyCosts> listPropertyCostsByKey(List<Integer> idList) {
        return propertyCostsRepository.listPropertyCostsByKey(idList);
    }

    @Override
    public int deletePropertyCostsByKey(Integer id) {
        return propertyCostsRepository.deletePropertyCostsByKey(id);
    }

    @Override
    public int deletePropertyCostsByKey(List<Integer> idList) {
        return  propertyCostsRepository.deleteBatchPropertyCostsByKey(idList);
    }

}
