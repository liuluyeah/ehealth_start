package com.cn.ehealth.dao;

import com.cn.ehealth.model.Mypatient;
import com.cn.ehealth.model.MypatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MypatientMapper {
    int countByExample(MypatientExample example);

    int deleteByExample(MypatientExample example);

    int deleteByPrimaryKey(Integer idmypatient);

    int insert(Mypatient record);

    int insertSelective(Mypatient record);

    List<Mypatient> selectByExample(MypatientExample example);

    Mypatient selectByPrimaryKey(Integer idmypatient);

    int updateByExampleSelective(@Param("record") Mypatient record, @Param("example") MypatientExample example);

    int updateByExample(@Param("record") Mypatient record, @Param("example") MypatientExample example);

    int updateByPrimaryKeySelective(Mypatient record);

    int updateByPrimaryKey(Mypatient record);
}