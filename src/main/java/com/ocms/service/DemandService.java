package com.ocms.service;

import com.ocms.entities.*;

import java.util.List;
import java.util.Map;

public interface DemandService {

    List<LatestDemandInfo> getLatest();

    DetailDemandInfo getDetail(Long userId,Long demandId);

    Map<String,Object> demandListData();

    Map<String,Object> demandListDataWithConditions(Integer pageCode,Long employType,String jobExperience,Integer demandDuration,Integer salary);

    ReturnDataAndInfo addDemand(Demand demand);

    Map<String,Object> getDemandApplyForChecker(Long checkerId,Integer pageCode);
    Map<String,Object> getDemandApplyForCheckerCloseModular(Long checkerId,Integer pageCode);

    Demand getById(Long id);

    ReturnDataAndInfo updateByChecker(MessageFromCheckerToManager messageFromCheckerToManager);

    Map<String,Object> getSignUpInfoForChecker(Long checkerId,Integer pageCode);

    ReturnDataAndInfo changeStatus(Long checkerId,Long demandId,Boolean status);

    ReturnDataAndInfo deleteDemand(Long checkerId,Long demandId);
}
