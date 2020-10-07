package com.company.project.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LJX
 */
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Resource
    private  DataSource masterDataSource;
    @Resource
    private  DataSource slaveDataSource;

    @Override
    public void afterPropertiesSet() {
        setDefaultTargetDataSource(masterDataSource);
        Map<Object,Object> targetDatasource = new HashMap<>();
        targetDatasource.put(DynamicDataSourceGlobal.MASTER.name(),masterDataSource);
        targetDatasource.put(DynamicDataSourceGlobal.SLAVE.name(),slaveDataSource);
        super.setTargetDataSources(targetDatasource);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if (DynamicDataSourceHolder.getDataSource().equals(DynamicDataSourceGlobal.MASTER)){
            return DynamicDataSourceGlobal.MASTER.name();
        }else {
            return DynamicDataSourceGlobal.SLAVE.name();
        }
    }
}
