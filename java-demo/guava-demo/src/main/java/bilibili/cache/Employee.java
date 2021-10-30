package bilibili.cache;

import com.google.common.base.MoreObjects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 22:43
 * @description：Cache资源
 * @modified By：
 * @version: $
 */
public class Employee {

    private final String name;
    private final String dept;
    private final String empID;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Name",this.getName())
                .add("Department",getDept())
                .add("EmployeeID",getEmpID()).toString();
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getEmpID() {
        return empID;
    }

    public Employee(String name, String dept, String empID) {
        this.name = name;
        this.dept = dept;
        this.empID = empID;
    }
}
