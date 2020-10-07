package com.company.project.configurer;

/**
 * @author LJX
 */
public class DynamicDataSourceHolder {
    private static  final ThreadLocal<DynamicDataSourceGlobal> holder = new ThreadLocal<>();
    private DynamicDataSourceHolder(){}

    public static void putDataSource(DynamicDataSourceGlobal dataSource){
        holder.set(dataSource);
    }

    public static DynamicDataSourceGlobal getDataSource(){
        return holder.get();
    }

    public static void clearDataSource(){
         holder.remove();
    }
}
