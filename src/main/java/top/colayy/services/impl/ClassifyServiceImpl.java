package top.colayy.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.colayy.dao.ClassifyDao;
import top.colayy.pojo.Classify;
import top.colayy.services.ClassifyService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyDao classifyDao;

    // 试题分类 -- 添加
    @Override
    public boolean addClassify(Classify classify) {
        if(classify.getuId() == null || "".equals(classify.getuId()) ||
            classify.getcName() == null || "".equals(classify.getcName()))
            return false;
        else{
            classify.setcId(UUID.randomUUID().toString());
            classify.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            return classifyDao.addClassify(classify) != 0;
        }
    }
    // 试题分类 -- 删除
    @Override
    public boolean delClassify(Classify classify) {
        if(classify.getuId() == null || "".equals(classify.getuId()) ||
            classify.getcId() == null || "".equals(classify.getcId()))
            return false;
        else
            return classifyDao.delClassify(classify) != 0;
    }
    // 试题分类 -- 修改名称
    @Override
    public boolean changeClassify(Classify classify) {
        if(classify.getuId() == null || "".equals(classify.getuId()) ||
            classify.getcId() == null || "".equals(classify.getcId()) ||
            classify.getcName() == null || "".equals(classify.getcName()))
            return false;
        else
            return classifyDao.changeClassify(classify) != 0;
    }
    // 试题分类 -- 显示所有
    @Override
    public List<Classify> queryAllClassify(String uId) {
        System.out.println(uId);
        return classifyDao.showClassify(uId);
    }
}
