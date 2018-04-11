package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.EquipmentRepair;
import com.jingye.repository.EquipmentRepairRepository;
import com.jingye.service.EquipmentRepairService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Service("equipmentRepairService")
public class EquipmentRepairServiceImpl implements EquipmentRepairService {

    private static final Logger LOGGER = Logger.getLogger(EquipmentRepairServiceImpl.class);

	@Autowired
	private EquipmentRepairRepository equipmentRepairRepository;

    @Override
    public int saveEquipmentRepair(EquipmentRepair equipmentRepair) {
        if(equipmentRepair == null) {
            LOGGER.error("--> equipmentRepair 不能为null！" );
            return 0;
        }
        if(equipmentRepair.getId() == null) {
            LOGGER.error("--> equipmentRepair  不能为null！"  + equipmentRepair);
            return 0;
        }
        return equipmentRepairRepository.saveEquipmentRepair(equipmentRepair);
    }

    @Override
    public int saveEquipmentRepair(List<EquipmentRepair> equipmentRepairList) {
        List<EquipmentRepair> tempequipmentRepairList = new ArrayList<>();
        for(EquipmentRepair equipmentRepair : equipmentRepairList) {
            if(equipmentRepair == null) {
                LOGGER.error("--> equipmentRepair 不能为null！" );
                continue;
            }
            if(equipmentRepair.getId() == null) {
                LOGGER.error("--> equipmentRepair  不能为null！"  + equipmentRepair);
                continue;
            }
            tempequipmentRepairList.add(equipmentRepair);
        }
        return equipmentRepairRepository.saveBatchEquipmentRepair(tempequipmentRepairList);
    }

    @Override
    public List<EquipmentRepair> listEquipmentRepair() {
        return equipmentRepairRepository.listEquipmentRepair();
    }

    @Override
    public List<EquipmentRepair> listEquipmentRepairByParam(EquipmentRepair equipmentRepair) {
        return equipmentRepairRepository.listEquipmentRepairByParam(equipmentRepair);
    }

    @Override
    public PageInfoUtil<EquipmentRepair> listEquipmentRepairByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<EquipmentRepair> equipmentRepairPage = new PageInfo<EquipmentRepair>(equipmentRepairRepository.listEquipmentRepair());
        return new PageInfoUtil(equipmentRepairPage.getList(), pageNum, pageSize, equipmentRepairPage.getTotal());
    }

    @Override
    public PageInfoUtil<EquipmentRepair> listEquipmentRepairByParamAndPage(EquipmentRepair equipmentRepair, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<EquipmentRepair> equipmentRepairPage = new PageInfo<EquipmentRepair>(equipmentRepairRepository.listEquipmentRepairByParam(equipmentRepair));
        return new PageInfoUtil(equipmentRepairPage.getList(), pageNum, pageSize, equipmentRepairPage.getTotal());
    }

    @Override
    public int deleteEquipmentRepairByParam(EquipmentRepair equipmentRepair) {
        return equipmentRepairRepository.deleteEquipmentRepairByParam(equipmentRepair);
    }

    @Override
    public int updateEquipmentRepairByKey(EquipmentRepair equipmentRepair) {
        if(equipmentRepair == null) {
            LOGGER.error("--> equipmentRepair 不能为null！" );
            return 0;
        }
        if(equipmentRepair.getId() == null) {
            LOGGER.error("--> equipmentRepair  不能为null！"  + equipmentRepair);
            return 0;
        }
        return equipmentRepairRepository.updateEquipmentRepairByKey(equipmentRepair);
    }

    @Override
    public int updateEquipmentRepairByKey(List<EquipmentRepair> equipmentRepairList) {
        int successNum = 0;
        for(EquipmentRepair equipmentRepair : equipmentRepairList) {
            successNum += updateEquipmentRepairByKey(equipmentRepair);
        }
        return successNum;
    }


    @Override
    public EquipmentRepair getEquipmentRepairByKey(Integer id) {
        return equipmentRepairRepository.getEquipmentRepairByKey(id);
    }

    @Override
    public List<EquipmentRepair> listEquipmentRepairByKey(List<Integer> idList) {
        return equipmentRepairRepository.listEquipmentRepairByKey(idList);
    }

    @Override
    public int deleteEquipmentRepairByKey(Integer id) {
        return equipmentRepairRepository.deleteEquipmentRepairByKey(id);
    }

    @Override
    public int deleteEquipmentRepairByKey(List<Integer> idList) {
        return  equipmentRepairRepository.deleteBatchEquipmentRepairByKey(idList);
    }

}
