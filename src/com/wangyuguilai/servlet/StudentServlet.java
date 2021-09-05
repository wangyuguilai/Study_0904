package com.wangyuguilai.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyuguilai.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student(1,"chenwei");
        Student stu2 = new Student(2,"mary");
        Student stu3 = new Student(3,"tom");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
