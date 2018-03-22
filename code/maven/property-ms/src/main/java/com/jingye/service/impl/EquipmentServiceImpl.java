package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Equipment;
import com.jingye.repository.EquipmentRepository;
import com.jingye.service.EquipmentService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

    private static final Logger LOGGER = Logger.getLogger(EquipmentServiceImpl.class);

	@Autowired
	private EquipmentRepository equipmentRepository;

    @Override
    public int saveEquipment(Equipment equipment) {
        if(equipment == null) {
            LOGGER.error("--> equipment 不能为null！" );
            return 0;
        }
        if(equipment.getEquipmentId() == null) {
            LOGGER.error("--> equipment 编号 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentCycle() == null) {
            LOGGER.error("--> equipment 检修周期 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentName() == null) {
            LOGGER.error("--> equipment 名称 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentVendor() == null) {
            LOGGER.error("--> equipment 生产厂商 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentNumber() == null) {
            LOGGER.error("--> equipment 数量 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentProduce() == null) {
            LOGGER.error("--> equipment 生产日期 不能为null！"  + equipment);
            return 0;
        }
        return equipmentRepository.saveEquipment(equipment);
    }

    @Override
    public int saveEquipment(List<Equipment> equipmentList) {
        List<Equipment> tempequipmentList = new ArrayList<>();
        for(Equipment equipment : equipmentList) {
            if(equipment == null) {
                LOGGER.error("--> equipment 不能为null！" );
                continue;
            }
            if(equipment.getEquipmentId() == null) {
                LOGGER.error("--> equipment 编号 不能为null！"  + equipment);
                continue;
            }
            if(equipment.getEquipmentCycle() == null) {
                LOGGER.error("--> equipment 检修周期 不能为null！"  + equipment);
                continue;
            }
            if(equipment.getEquipmentName() == null) {
                LOGGER.error("--> equipment 名称 不能为null！"  + equipment);
                continue;
            }
            if(equipment.getEquipmentVendor() == null) {
                LOGGER.error("--> equipment 生产厂商 不能为null！"  + equipment);
                continue;
            }
            if(equipment.getEquipmentNumber() == null) {
                LOGGER.error("--> equipment 数量 不能为null！"  + equipment);
                continue;
            }
            if(equipment.getEquipmentProduce() == null) {
                LOGGER.error("--> equipment 生产日期 不能为null！"  + equipment);
                continue;
            }
            tempequipmentList.add(equipment);
        }
        return equipmentRepository.saveBatchEquipment(tempequipmentList);
    }

    @Override
    public List<Equipment> listEquipment() {
        return equipmentRepository.listEquipment();
    }

    @Override
    public List<Equipment> listEquipmentByParam(Equipment equipment) {
        return equipmentRepository.listEquipmentByParam(equipment);
    }

    @Override
    public PageInfoUtil<Equipment> listEquipmentByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Equipment> equipmentPage = new PageInfo<Equipment>(equipmentRepository.listEquipment());
        return new PageInfoUtil(equipmentPage.getList(), pageNum, pageSize, equipmentPage.getTotal());
    }

    @Override
    public PageInfoUtil<Equipment> listEquipmentByParamAndPage(Equipment equipment, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Equipment> equipmentPage = new PageInfo<Equipment>(equipmentRepository.listEquipmentByParam(equipment));
        return new PageInfoUtil(equipmentPage.getList(), pageNum, pageSize, equipmentPage.getTotal());
    }

    @Override
    public int deleteEquipmentByParam(Equipment equipment) {
        return equipmentRepository.deleteEquipmentByParam(equipment);
    }

    @Override
    public int updateEquipmentByKey(Equipment equipment) {
        if(equipment == null) {
            LOGGER.error("--> equipment 不能为null！" );
            return 0;
        }
        if(equipment.getEquipmentId() == null) {
            LOGGER.error("--> equipment 编号 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentCycle() == null) {
            LOGGER.error("--> equipment 检修周期 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentName() == null) {
            LOGGER.error("--> equipment 名称 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentVendor() == null) {
            LOGGER.error("--> equipment 生产厂商 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentNumber() == null) {
            LOGGER.error("--> equipment 数量 不能为null！"  + equipment);
            return 0;
        }
        if(equipment.getEquipmentProduce() == null) {
            LOGGER.error("--> equipment 生产日期 不能为null！"  + equipment);
            return 0;
        }
        return equipmentRepository.updateEquipmentByKey(equipment);
    }

    @Override
    public int updateEquipmentByKey(List<Equipment> equipmentList) {
        int successNum = 0;
        for(Equipment equipment : equipmentList) {
            successNum += updateEquipmentByKey(equipment);
        }
        return successNum;
    }


    @Override
    public Equipment getEquipmentByKey(Integer equipmentId) {
        return equipmentRepository.getEquipmentByKey(equipmentId);
    }

    @Override
    public List<Equipment> listEquipmentByKey(List<Integer> equipmentIdList) {
        return equipmentRepository.listEquipmentByKey(equipmentIdList);
    }

    @Override
    public int deleteEquipmentByKey(Integer equipmentId) {
        return equipmentRepository.deleteEquipmentByKey(equipmentId);
    }

    @Override
    public int deleteEquipmentByKey(List<Integer> equipmentIdList) {
        return  equipmentRepository.deleteBatchEquipmentByKey(equipmentIdList);
    }

}
