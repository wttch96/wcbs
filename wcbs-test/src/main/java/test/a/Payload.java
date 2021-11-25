package test.a;

import com.wttch.wcbs.data.mybatis.QueryRequest;
import com.wttch.wcbs.data.mybatis.annotations.QueryColumn;
import com.wttch.wcbs.data.mybatis.annotations.QueryStringColumn;
import lombok.Data;

@Data
public class Payload implements QueryRequest {
  @QueryColumn(columnName = "X")
  private String test;

  @QueryStringColumn(columnName = "X")
  private String test1;
}