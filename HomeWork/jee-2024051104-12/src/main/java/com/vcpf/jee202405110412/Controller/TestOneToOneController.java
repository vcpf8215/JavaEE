package com.vcpf.jee202405110412.Controller;
import java.util.List;

import com.vcpf.jee202405110412.Service.PersonAndIdCardService;
import com.vcpf.jee202405110412.entity.IdCard;
import com.vcpf.jee202405110412.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <pre>
 * 人员和身份证：一对一
 * 1. 初始化数据
 * 2. 查询所有：人表，或是证表
 * 3. 按人查证：查人，带出证的信息
 * 4. 按证查人：查证，带出人的信息
 * </pre>
 */
@RestController
public class TestOneToOneController {

    @Autowired
    private PersonAndIdCardService personAndIdCardService;

    // http://localhost:8080/ch6_2/save
    @GetMapping("/save")
    public String save() {
        personAndIdCardService.saveAll();
        return "人员和身份保存成功！";
    }
    // http://localhost:8080/ch6_2/findAllPerson
    @GetMapping("/findAllPerson")
    public List<Person> findAllPerson() {
        return  personAndIdCardService.findAllPerson();
    }
    // http://localhost:8080/ch6_2/findAllIdCard
    @GetMapping("/findAllIdCard")
    public List<IdCard>  findAllIdCard() {
        return personAndIdCardService.findAllIdCard();
    }
    /**
     * 根据人员ID查询身份信息（关联查询）
     * // http://localhost:8080/ch6_2/findByPerson_id?id=1
     */
    @GetMapping("/findByPerson_id")
    public IdCard findByPerson_id(Integer id) {
        return personAndIdCardService.findByPerson_id(id);
    }
    /**
     * 根据人员ID查询身份信息（关联查询）
     * // http://localhost:8080/ch6_2/findByAddressAndCode?address=北京&code=123456789
     */
    @GetMapping("/findByAddressAndCode")
    public List<IdCard> findByAddressAndCode(String address, String code){
        return personAndIdCardService.findByAddressAndCode(address, code);
    }
    /**
     * 根据身份ID查询人员信息（关联查询）
     * // http://localhost:8080/ch6_2/findByIdCard_id?id=1
     */
    @GetMapping("/findByIdCard_id")
    public Person findByIdCard_id(Integer id) {
        return personAndIdCardService.findByIdCard_id(id);
    }
    // http://localhost:8080/ch6_2/findByPnameAndPsex?pname=陈恒1&psex=男
    @GetMapping("/findByPnameAndPsex")
    public List<Person> findByPnameAndPsex(String pname, String psex) {
        return personAndIdCardService.findByPnameAndPsex(pname, psex);
    }
    // http://localhost:8080/ch6_2/getOneIdCard?id=1
    @GetMapping("/getOneIdCard")
    public IdCard getOneIdCard(Integer id) {
        return personAndIdCardService.getOneIdCard(id);
    }
    // http://localhost:8080/ch6_2/getOnePerson?id=1
    @GetMapping("/getOnePerson")
    public Person getOnePerson(Integer id) {
        return personAndIdCardService.getOnePerson(id);
    }
}
