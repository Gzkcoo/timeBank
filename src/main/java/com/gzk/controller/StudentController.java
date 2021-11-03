package com.gzk.controller;

import com.gzk.entity.Student;
import com.gzk.service.StudentService;
import com.gzk.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

//    @RequestMapping("/login")
//    public String login(Student mystudent, Model model){
//        Student student = studentService.queryStudentByUser(mystudent.getUser());
//        if(student == null){
//            model.addAttribute("error","用户名不存在！");
//        }else {
//            if(student.getPsw().equals(mystudent.getPsw())){
//
//                return "success";
//            }else{
//                model.addAttribute("error","密码错误！");
//            }
//        }
//        return "error";
//    }

//    @RequestMapping(value = "/listareas")
//    @ResponseBody
//    public Map<String, Object> listArea() {
//        HashMap modleMap = new HashMap();
//
//        try {
//
//            modleMap.put("rows", "1");
//            modleMap.put("total", "2");
//        } catch (Exception e) {
//            modleMap.put("success", false);
//            modleMap.put("errMsg", e.toString());
//            e.printStackTrace();
//        }
//        return modleMap;
//    }

//    @RequestMapping("/login2")
//    @ResponseBody
//    public Map<String, Object> login2(Student mystudent){
//        HashMap modleMap = new HashMap();
//        List<Student> list = new ArrayList<Student>();
//
//        Student s1 = new Student("111","1111");
//        Student s2 = new Student("222","222");
//
//        list.add(s1);
//        list.add(s2);
//
//        Student student = studentService.queryStudentByUser(mystudent.getUser());
//        if(student == null){
//            modleMap.put("error","用户名不存在！");
//        }else {
//            if(student.getPsw().equals(mystudent.getPsw())){
//                modleMap.put("success","success");
//
//            }else{
//                modleMap.put("error","密码错误！");
//            }
//        }
//        modleMap.put("list",list);
//        return modleMap;
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpSession session, @RequestBody Student student){


        HashMap modleMap = new HashMap();
        Student student1 = studentService.queryStudentByUser(student.getUser());
        if(student1 == null){
            modleMap.put("error","用户名不存在");
        }else {
            if(student1.getPsw().equals(student.getPsw())){
                session.setAttribute("loginUser",student.getUser());
                modleMap.put("user",student.getUser());
                modleMap.put("psw",student.getPsw());
            }else{
                modleMap.put("error","密码错误");
            }
        }
        return modleMap;
    }
}
