package day17.teammanager.service;


import day17.teammanager.entity.employee.Architect;
import day17.teammanager.entity.employee.Designer;
import day17.teammanager.entity.employee.Employee;
import day17.teammanager.entity.employee.Programmer;
import day17.teammanager.entity.equipment.NoteBook;
import day17.teammanager.entity.equipment.PC;
import day17.teammanager.entity.equipment.Printer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import static day17.teammanager.util.Data.*;


/**
 * 获取员工和设备数据的service
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class NameListService {
    private Employee[] employees;
    /**
     * 记录employees 数组的索引，最大为其length-1
     **/
    private int total;

    /**
     * 根据id 从employees 查找对应的员工对象
     *
     * @param id 员工id
     * @return 员工对象
     * @throws TeamException 如果没有找到员工则报异常
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("根据这个id：" + id + "无法找到对应的员工");
    }

    /**
     * 将文件中的员工数据和设备数据填充进employees 数组中
     *
     * @throws TeamException 如果员工编号或者设备编号无对应则报异常
     */
    public NameListService() throws TeamException {

        employees = new Employee[EMPLOYEES.length];

        fillEmployees();

        fillEquipment();

    }

    /**
     * 为employees 数组中的每个程序员及其子类装配对应的设备对象
     *
     * @throws TeamException 如果设备编号无对应则报异常
     */
    private void fillEquipment() throws TeamException {
        for (int i = 1; i < EQIPMENTS.length; i++) {
            int num = Integer.parseInt(EQIPMENTS[i][0]);
            String[] str = EQIPMENTS[i];
            switch (num) {
                //PC      :21, model, display
                //NoteBook:22, model, price
                //Printer :23, type, name
                case (PC):
                    ((Programmer) employees[i]).setEquipment(new PC(str[1], str[2]));
                    break;
                case (NOTEBOOK):
                    ((Programmer) employees[i]).setEquipment(new NoteBook(str[1], Double.parseDouble(str[2])));
                    break;
                case (PRINTER):
                    ((Programmer) employees[i]).setEquipment(new Printer(str[1], str[2]));
                    break;
                default:
                    throw new TeamException("没有对应的设备类型编号");
            }
        }
    }

    /**
     * 将文件中的员工数据组装成对应的对象并填充进employees 数组
     *
     * @throws TeamException 如果员工编号无对应则报异常
     */
    private void fillEmployees() throws TeamException {

        for (String[] employeeStr : EMPLOYEES) {
            int i = Integer.parseInt(employeeStr[0]);
            switch (i) {
                case (EMPLOYEE):
                    //Employee  :  10, id, name, age, salary
                    Employee employee = new Employee(Integer.parseInt(employeeStr[1]), employeeStr[2], Integer.parseInt(employeeStr[3]), Double.parseDouble(employeeStr[4]));
                    employees[total++] = employee;
                    break;
                case (PROGRAMMER):
                    //Programmer:  11, id, name, age, salary
                    Programmer programmer = (Programmer) new Programmer().setId(Integer.parseInt(employeeStr[1])).setName(employeeStr[2]).setAge(Integer.parseInt(employeeStr[3])).setSalary(Double.parseDouble(employeeStr[4]));
                    employees[total++] = programmer;
                    break;
                case (DESIGNER):
//                    12, id, name, age, salary, bonus
                    Designer designer = (Designer) new Designer().setBonus(Double.parseDouble(employeeStr[5])).setId(Integer.parseInt(employeeStr[1])).setName(employeeStr[2]).setAge(Integer.parseInt(employeeStr[3])).setSalary(Double.parseDouble(employeeStr[4]));
                    employees[total++] = designer;
                    break;
                case (ARCHITECT):
                    //Architect :  13, id, name, age, salary, bonus, stock
                    Architect architect = (Architect) new Architect().setStock(Integer.parseInt(employeeStr[6])).setBonus(Double.parseDouble(employeeStr[5])).setId(Integer.parseInt(employeeStr[1])).setName(employeeStr[2]).setAge(Integer.parseInt(employeeStr[3])).setSalary(Double.parseDouble(employeeStr[4]));
                    employees[total++] = architect;
                    break;
                default:
                    throw new TeamException("没有对应的员工类型编号");
            }
        }
    }


}
