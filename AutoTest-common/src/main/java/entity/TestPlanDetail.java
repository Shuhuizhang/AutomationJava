package entity;

import com.haizol.automation.model.TbTestCase;
import com.haizol.automation.model.TestPlan;

import java.io.Serializable;
import java.util.List;

public class TestPlanDetail implements Serializable {

    private TestPlan testPlan;
    private List<TbTestCase> caseList;

    public TestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(TestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public List<TbTestCase> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<TbTestCase> caseList) {
        this.caseList = caseList;
    }
}
