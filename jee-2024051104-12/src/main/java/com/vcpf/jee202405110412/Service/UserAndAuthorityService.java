package com.vcpf.jee202405110412.Service;
import com.vcpf.jee202405110412.entity.Authority;
import com.vcpf.jee202405110412.entity.User;

import java.util.List;
public interface UserAndAuthorityService {
    public void saveAll();
    public List<User> findByAuthorityList_id(int id);
    public List<User> findByAuthorityList_name(String name);
    public List<Authority> findByUserList_id(int id);
    public List<Authority> findByUserList_Username(String username);
}