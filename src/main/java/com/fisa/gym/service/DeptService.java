//package com.fisa.gym.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.fisa.gym.model.DeptRepository;
//import com.fisa.gym.model.domain.Dept;
//
//@Service
//public class DeptService {
//
//    private final DeptRepository deptRepository;
//
//    @Autowired
//    public DeptService(DeptRepository deptRepository) {
//        this.deptRepository = deptRepository;
//    }
//
//    public boolean insert(Dept dept) {
//        try {
//            deptRepository.save(dept);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean update(int deptno, String newLoc) {
//        try {
//            Dept dept = deptRepository.findById(deptno).orElse(null);
//            if (dept != null) {
//                dept.setLoc(newLoc);
//                deptRepository.save(dept);
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public List<Dept> selectAll() {
//        return deptRepository.findAll();
//    }
//    
//    // 부가적인 메소드는 필요에 따라 추가할 수 있습니다.
//}
