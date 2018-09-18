package com.customs.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.customs.configuration.StationConfig;
import com.customs.entity.Person;
import com.customs.services.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
//    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private IPersonService personService;
    @Autowired
    private StationConfig stationConfig;

    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Person getById(@PathVariable Long id) {
	Person person = personService.getById(id);
	return person;
    }

    @RequestMapping("/index")
    public String toIndex() {
	return "index";
    }

    @RequestMapping("/add/age")
    @ResponseBody
    public Integer addAge(int age, Long id) throws Exception {
	System.out.println(stationConfig.toString());
	return personService.addAge(age, id);
    }

    @RequestMapping("/list")
    @ResponseBody
    public void getAll(HttpServletRequest req) {
	System.out.println("resp_code:" + req.getParameter("resp_code"));
	System.out.println("resp_desc" + req.getParameter("resp_desc"));
	System.out.println(req);
    }
}
