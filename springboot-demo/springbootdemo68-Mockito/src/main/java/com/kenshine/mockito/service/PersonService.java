package com.kenshine.mockito.service;

import com.kenshine.mockito.dao.PersonDao;
import com.kenshine.mockito.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 13:52
 * @description：用户Service
 * @modified By：
 * @version: $
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;


    public boolean update(int id, String name) {
        Person person = personDao.getPerson(id);
        if (person == null) {
            return false;
        }

        Person personUpdate = new Person(person.getId(), name);
        return personDao.update(personUpdate);
    }


}
