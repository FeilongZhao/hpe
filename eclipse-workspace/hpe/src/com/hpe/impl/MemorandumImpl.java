package com.hpe.impl;

import java.util.List;
import java.util.Map;

import com.hpe.po.Memorandum;

public interface MemorandumImpl {

    Boolean addMemorandum(Memorandum memorandum);

    boolean deleteMemorandum(int userId,int memorandum_id);

    boolean updateMemorandum(int userId,int memorandum_id,Map<String, String> content);

    List<Memorandum> getMemorandum(int userId);

}
