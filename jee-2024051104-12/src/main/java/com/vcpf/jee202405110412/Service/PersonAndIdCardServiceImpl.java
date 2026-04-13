package com.vcpf.jee202405110412.Service;
import java.util.*;

import com.vcpf.jee202405110412.Repository.IdCardRepository;
import com.vcpf.jee202405110412.Repository.PersonRepository;
import com.vcpf.jee202405110412.entity.IdCard;
import com.vcpf.jee202405110412.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonAndIdCardServiceImpl implements PersonAndIdCardService{
    
    @Autowired
    private IdCardRepository idCardRepository;
    @Autowired
    private PersonRepository personRepository;
    @Override
    public void saveAll() {
        //保存身份证
        IdCard ic1 = new IdCard();
        ic1.setCode("510001202604040001");
        ic1.setAddress("双流");
        Calendar c1 = Calendar.getInstance();
        c1.set(2023, 8, 13);
        ic1.setBirthday(c1);
        IdCard ic2 = new IdCard();
        ic2.setCode("510001202604040002");
        ic2.setAddress("武侯");
        Calendar c2 = Calendar.getInstance();
        c2.set(2023, 8, 14);
        ic2.setBirthday(c2);
        IdCard ic3 = new IdCard();
        ic3.setCode("510001202604040003");
        ic3.setAddress("锦江");
        Calendar c3 = Calendar.getInstance();
        c3.set(2023, 8, 15);
        ic3.setBirthday(c3);
        List<IdCard> idCards = new ArrayList<IdCard>();
        idCards.add(ic1);
        idCards.add(ic2);
        idCards.add(ic3);
        idCardRepository.saveAllAndFlush(idCards);
        //保存人员
        Person p1 = new Person();
        p1.setPname("郑佳娃1");
        p1.setPsex("男");
        p1.setPage(18);
        p1.setIdCard(ic1);
        Person p2 = new Person();
        p2.setPname("郑佳娃2");
        p2.setPsex("女");
        p2.setPage(19);
        p2.setIdCard(ic2);
        Person p3 = new Person();
        p3.setPname("郑佳娃3");
        p3.setPsex("女");
        p3.setPage(20);
        p3.setIdCard(ic3);
        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        personRepository.saveAllAndFlush(persons);
    }
    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }
    @Override
    public List<IdCard> findAllIdCard() {
        return idCardRepository.findAll();
    }
    /**
     * 根据人员ID查询身份信息（关联查询）
     */
    @Override
    public IdCard findByPerson_id(Integer id) {
        return idCardRepository.findByPerson_id(id);
    }
    @Override
    public List<IdCard> findByAddressAndCode(String address, String code) {
        return idCardRepository.findByAddressAndCode(address, code);
    }
    /**
     * 根据身份ID查询人员信息（关联查询）
     */
    @Override
    public Person findByIdCard_id(Integer id) {
        return personRepository.findByIdCard_id(id);
    }
    @Override
    public List<Person> findByPnameAndPsex(String pname, String psex) {
        return personRepository.findByPnameAndPsex(pname, psex);
    }
    @Override
    public IdCard getOneIdCard(Integer id) {
        return idCardRepository.getReferenceById(id);
    }
    @Override
    public Person getOnePerson(Integer id) {
        return personRepository.getReferenceById(id);
    }
}
