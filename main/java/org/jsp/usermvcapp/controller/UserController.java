package org.jsp.usermvcapp.controller;

import java.util.Scanner;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/save")
	public String saveUser(@ModelAttribute(name = "u") User user) {
		user = userDao.saveUser(user);
		return "<body style=background-color:#b5aeb4;font-size:25px><strong>User saved with the id: " + user.getId()
				+ "</strong></body>";
	}

	@RequestMapping(value = "/open-updation")
	public ModelAndView openUpdation(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("updation");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/update")
	public String updateUser(@ModelAttribute(name = "u") User user) {
		user = userDao.updateUser(user);
		if (user != null) {
			return "<body style=background-color:#b5aeb4;font-size:25px><strong>User updated with the Id: "
					+ user.getId() + "</strong></body>";
		} else {
			return "<body style=background-color:#b5aeb4;font-size:25px><strong>User not updated,Id not found</strong></body>";
		}
	}

	@RequestMapping(value = "/open-find")
	public ModelAndView openFind(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("findById");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/findById")
	public String findUserById(@ModelAttribute(name = "u") User user) {
		user = userDao.findUserById(user.getId());
		if (user != null) {
			return "<body style=background-color:#b5aeb4;font-size:25px><strong>User " + user.getName()
					+ " found with Id: " + user.getId() + "</strong></body>";
		}
		return "<body style=background-color:#b5aeb4;font-size:25px><strong>No user found for the entered Id</strong></body>";
	}

	@RequestMapping(value = "/open-phone")
	public ModelAndView openPhone(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("phone");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/phone")
	public String verifyUserByPhone(@ModelAttribute(name = "u") User user) {
		user = userDao.verifyUser(user.getPhone(), user.getPassword());
		if (user != null) {

			String content = "Verification Successfull!!!<br>User Id: " + user.getId() + "<br>" + "Name: "
					+ user.getName() + "<br>" + "Phone: " + user.getPhone() + "<br>" + "Email: " + user.getEmail();

			return "<body style=background-color:#b5aeb4;font-size:25px><strong>" + content + "</strong</body>";
		}
		return "<body style=background-color:#b5aeb4;font-size:25px><strong>Invalid Phone or Password</strong></body>";
	}

	@RequestMapping(value = "/open-email")
	public ModelAndView openEmail(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("email");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/email")
	public String verifyUserByEmail(@ModelAttribute(name = "u") User user) {
		user = userDao.verifyUser(user.getEmail(), user.getPassword());
		if (user != null) {

			String content = "Verification Successfull!!!<br>User Id: " + user.getId() + "<br>" + "Name: "
					+ user.getName() + "<br>" + "Phone: " + user.getPhone() + "<br>" + "Email: " + user.getEmail();

			return "<body style=background-color:#b5aeb4;font-size:25px><strong>" + content + "</strong</body>";
		}
		return "<body style=background-color:#b5aeb4;font-size:25px><strong>Invalid Email or Password</strong></body>";
	}

	@RequestMapping(value = "/open-id")
	public ModelAndView openId(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("id");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/id")
	public String verifyUserById(@ModelAttribute(name = "u") User user) {
		user = userDao.verifyUser(user.getId(), user.getPassword());

		if (user != null) {

			String content = "Verification Successfull!!!<br>User Id: " + user.getId() + "<br>" + "Name: "
					+ user.getName() + "<br>" + "Phone: " + user.getPhone() + "<br>" + "Email: " + user.getEmail();

			return "<body style=background-color:#b5aeb4;font-size:25px><strong>" + content + "</strong</body>";
		}
		return "<body style=background-color:#b5aeb4;font-size:25px><strong>Invalid Id or Password</strong></body>";
	}

	@RequestMapping(value = "/open-delete")
	public ModelAndView openDelete(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("delete");
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value = "/delete")
	public String deleteUserById(@ModelAttribute(name = "u") User user) {
		user = userDao.deleteUser(user.getId());
		if (user != null) {
			return "<body style=background-color:#b5aeb4;font-size:25px><strong>User " + user.getName()
					+ " deleted Successfully with the Id: " + user.getId() + "</strong></body>";
		}
		return "<body style=background-color:#b5aeb4;font-size:25px><strong>Unable to delete user,No Id found</strong></body>";
	}

}
