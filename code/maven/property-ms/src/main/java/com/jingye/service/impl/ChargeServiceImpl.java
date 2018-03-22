package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Charge;
import com.jingye.repository.ChargeRepository;
import com.jingye.service.ChargeService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@Service("chargeService")
public class ChargeServiceImpl implements ChargeService {

    private static final Logger LOGGER = Logger.getLogger(ChargeServiceImpl.class);

	@Autowired
	private ChargeRepository chargeRepository;

    @Override
    public int saveCharge(Charge charge) {
        if(charge == null) {
            LOGGER.error("--> charge 不能为null！" );
            return 0;
        }
        if(charge.getChargeId() == null) {
            LOGGER.error("--> charge 收费标准id 不能为null！"  + charge);
            return 0;
        }
        if(charge.getChargeMoney() == null) {
            LOGGER.error("--> charge 收费金额 不能为null！"  + charge);
            return 0;
        }
        if(charge.getChargeName() == null) {
            LOGGER.error("--> charge 收费标准名 不能为null！"  + charge);
            return 0;
        }
        if(charge.getChargeKind() == null) {
            LOGGER.error("--> charge 收费标准类别 不能为null！"  + charge);
            return 0;
        }
        return chargeRepository.saveCharge(charge);
    }

    @Override
    public int saveCharge(List<Charge> chargeList) {
        List<Charge> tempchargeList = new ArrayList<>();
        for(Charge charge : chargeList) {
            if(charge == null) {
                LOGGER.error("--> charge 不能为null！" );
                continue;
            }
            if(charge.getChargeId() == null) {
                LOGGER.error("--> charge 收费标准id 不能为null！"  + charge);
                continue;
            }
            if(charge.getChargeMoney() == null) {
                LOGGER.error("--> charge 收费金额 不能为null！"  + charge);
                continue;
            }
            if(charge.getChargeName() == null) {
                LOGGER.error("--> charge 收费标准名 不能为null！"  + charge);
                continue;
            }
            if(charge.getChargeKind() == null) {
                LOGGER.error("--> charge 收费标准类别 不能为null！"  + charge);
                continue;
            }
            tempchargeList.add(charge);
        }
        return chargeRepository.saveBatchCharge(tempchargeList);
    }

    @Override
    public List<Charge> listCharge() {
        return chargeRepository.listCharge();
    }

    @Override
    public List<Charge> listChargeByParam(Charge charge) {
        return chargeRepository.listChargeByParam(charge);
    }

    @Override
    public PageInfoUtil<Charge> listChargeByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Charge> chargePage = new PageInfo<Charge>(chargeRepository.listCharge());
        return new PageInfoUtil(chargePage.getList(), pageNum, pageSize, chargePage.getTotal());
    }

    @Override
    public PageInfoUtil<Charge> listChargeByParamAndPage(Charge charge, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Charge> chargePage = new PageInfo<Charge>(chargeRepository.listChargeByParam(charge));
        return new PageInfoUtil(chargePage.getList(), pageNum, pageSize, chargePage.getTotal());
    }

    @Override
    public int deleteChargeByParam(Charge charge) {
        return chargeRepository.deleteChargeByParam(charge);
    }

    @Override
    public int updateChargeByKey(Charge charge) {
        if(charge == null) {
            LOGGER.error("--> charge 不能为null！" );
            return 0;
        }
        if(charge.getChargeId() == null) {
            LOGGER.error("--> charge 收费标准id 不能为null！"  + charge);
            return 0;
        }
        if(charge.getChargeMoney() == null) {
            LOGGER.error("--> charge 收费金额 不能为null！"  + charge);
            return 0;
        }
        if(charge.getChargeName() == null) {
            LOGGER.error("--> charge 收费标准名 不能为null！"  + charge);
            return 0;
        }
        if(charge.getChargeKind() == null) {
            LOGGER.error("--> charge 收费标准类别 不能为null！"  + charge);
            return 0;
        }
        return chargeRepository.updateChargeByKey(charge);
    }

    @Override
    public int updateChargeByKey(List<Charge> chargeList) {
        int successNum = 0;
        for(Charge charge : chargeList) {
            successNum += updateChargeByKey(charge);
        }
        return successNum;
    }


    @Override
    public Charge getChargeByKey(Integer chargeId) {
        return chargeRepository.getChargeByKey(chargeId);
    }

    @Override
    public List<Charge> listChargeByKey(List<Integer> chargeIdList) {
        return chargeRepository.listChargeByKey(chargeIdList);
    }

    @Override
    public int deleteChargeByKey(Integer chargeId) {
        return chargeRepository.deleteChargeByKey(chargeId);
    }

    @Override
    public int deleteChargeByKey(List<Integer> chargeIdList) {
        return  chargeRepository.deleteBatchChargeByKey(chargeIdList);
    }

}
