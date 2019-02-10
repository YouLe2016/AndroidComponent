package com.wyl.basemodule.utils;

import java.util.Collection;

/**
 * 时间：2019/1/3 11:12
 * 描述：集合工具类
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class CollectionsUtils {

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @param <E>
     * @return
     */
    public static <E> boolean isEmpty(Collection<E> collection) {
        return collection == null || collection.isEmpty();
    }


}
