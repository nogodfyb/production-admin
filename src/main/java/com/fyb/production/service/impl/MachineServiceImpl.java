package com.fyb.production.service.impl;

import com.fyb.production.entity.Machine;
import com.fyb.production.mapper.MachineMapper;
import com.fyb.production.service.IMachineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
@Service
public class MachineServiceImpl extends ServiceImpl<MachineMapper, Machine> implements IMachineService {

}
