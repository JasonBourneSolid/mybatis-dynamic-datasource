package com.company.project.configurer;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;


import java.util.Properties;

/**
 * @author LJX
 */
@Intercepts(value = {
        @Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class}),
        @Signature( type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
}
)
public class DynamicPlugin implements Interceptor {

    /**
     * 1.拿到SQL类型
     * 2.判断SQL类型
     * 3.设置DynamicDataSourceHolder
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] objects = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement)objects[0];
        if (mappedStatement.getSqlCommandType().equals(SqlCommandType.SELECT)){
            DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.SLAVE);
        }else{
            DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.MASTER);

        }
        return invocation.proceed();
    }

    /***
     * 插件使用插件链。控制插件执行顺序
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 初始化插件是设置属性
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
