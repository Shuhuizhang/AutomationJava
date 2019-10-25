package entity;

import com.haizol.automation.model.TbTestCase;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname RunPlan
 * @Date 2019/10/20 20:45
 * @Created by StevenZsh
 * @Description TODO
 */
public class RunPlan implements Serializable {


    private String planName;
    private List<TbTestCase> testList;


    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public List<TbTestCase> getTestList() {
        return testList;
    }

    public void setTestList(List<TbTestCase> testList) {
        this.testList = testList;
    }
}
