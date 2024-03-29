package com.wttch.wcbs.data.mybatis.item;

import com.wttch.wcbs.data.mybatis.enums.QueryParamType;
import lombok.NoArgsConstructor;

/**
 * 字符串精确查询字段
 *
 * <p>sql: key = 'value'
 *
 * @author wttch
 */
@NoArgsConstructor
class QueryStringItem extends BaseEqualQueryItem<String> {

  /**
   * 获取通用查询的字段的数值类型
   *
   * @return 通用查询的字段的数值类型
   */
  @Override
  public Class<String> valueType() {
    return String.class;
  }

  /**
   * 获取处理的查询字段的类型
   *
   * @return 处理查询的字段的类型
   */
  @Override
  public QueryParamType queryParamType() {
    return QueryParamType.STRING;
  }
}
