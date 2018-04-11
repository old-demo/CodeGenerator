package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.PublicEquipment;
import com.jingye.repository.PublicEquipmentRepository;
import com.jingye.service.PublicEquipmentService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Service("publicEquipmentService")
public class PublicEquipmentServiceImpl implements PublicEquipmentService {

    private static final Logger LOGGER = Logger.getLogger(PublicEquipmentServiceImpl.class);

	@Autowired
	private PublicEquipmentRepository publicEquipmentRepository;

    @Override
    public int savePublicEquipment(PublicEquipment publicEquipment) {
        if(publicEquipment == null) {
            LOGGER.error("--> publicEquipment 不能为null！" );
            return 0;
        }
        if(publicEquipment.getId() == null) {
            LOGGER.error("--> publicEquipment Id 不能为null！"  + publicEquipment);
            return 0;
        }
        return publicEquipmentRepository.savePublicEquipment(publicEquipment);
    }

    @Override
    public int savePublicEquipment(List<PublicEquipment> publicEquipmentList) {
        List<PublicEquipment> temppublicEquipmentList = new ArrayList<>();
        for(PublicEquipment publicEquipment : publicEquipmentList) {
            if(publicEquipment == null) {
                LOGGER.error("--> publicEquipment 不能为null！" );
                continue;
            }
            if(publicEquipment.getId() == null) {
                LOGGER.error("--> publicEquipment Id 不能为null！"  + publicEquipment);
                continue;
            }
            temppublicEquipmentList.add(publicEquipment);
        }
        return publicEquipmentRepository.saveBatchPublicEquipment(temppublicEquipmentList);
    }

    @Override
    public List<PublicEquipment> listPublicEquipment() {
        return publicEquipmentRepository.listPublicEquipment();
    }

    @Override
    public List<PublicEquipment> listPublicEquipmentByParam(PublicEquipment publicEquipment) {
        return publicEquipmentRepository.listPublicEquipmentByParam(publicEquipment);
    }

    @Override
    public PageInfoUtil<PublicEquipment> listPublicEquipmentByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PublicEquipment> publicEquipmentPage = new PageInfo<PublicEquipment>(publicEquipmentRepository.listPublicEquipment());
        return new PageInfoUtil(publicEquipmentPage.getList(), pageNum, pageSize, publicEquipmentPage.getTotal());
    }

    @Override
    public PageInfoUtil<PublicEquipment> listPublicEquipmentByParamAndPage(PublicEquipment publicEquipment, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PublicEquipment> publicEquipmentPage = new PageInfo<PublicEquipment>(publicEquipmentRepository.listPublicEquipmentByParam(publicEquipment));
        return new PageInfoUtil(publicEquipmentPage.getList(), pageNum, pageSize, publicEquipmentPage.getTotal());
    }

    @Override
    public int deletePublicEquipmentByParam(PublicEquipment publicEquipment) {
        return publicEquipmentRepository.deletePublicEquipmentByParam(publicEquipment);
    }

    @Override
    public int updatePublicEquipmentByKey(PublicEquipment publicEquipment) {
        if(publicEquipment == null) {
            LOGGER.error("--> publicEquipment 不能为null！" );
            return 0;
        }
        if(publicEquipment.getId() == null) {
            LOGGER.error("--> publicEquipment Id 不能为null！"  + publicEquipment);
            return 0;
        }
        return publicEquipmentRepository.updatePublicEquipmentByKey(publicEquipment);
    }

    @Override
    public int updatePublicEquipmentByKey(List<PublicEquipment> publicEquipmentList) {
        int successNum = 0;
        for(PublicEquipment publicEquipment : publicEquipmentList) {
            successNum += updatePublicEquipmentByKey(publicEquipment);
        }
        return successNum;
    }


    @Override
    public PublicEquipment getPublicEquipmentByKey(Integer id) {
        return publicEquipmentRepository.getPublicEquipmentByKey(id);
    }

    @Override
    public List<PublicEquipment> listPublicEquipmentByKey(List<Integer> idList) {
        return publicEquipmentRepository.listPublicEquipmentByKey(idList);
    }

    @Override
    public int deletePublicEquipmentByKey(Integer id) {
        return publicEquipmentRepository.deletePublicEquipmentByKey(id);
    }

    @Override
    public int deletePublicEquipmentByKey(List<Integer> idList) {
        return  publicEquipmentRepository.deleteBatchPublicEquipmentByKey(idList);
    }

}
