package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Item;
import com.example.form.ItemForm;
import com.example.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Item> items = this.itemService.findAll();
		System.out.println(items.toString());
		return "item/index";
	}
	
	@GetMapping("new")
	public String tnew(@ModelAttribute("itemForm") ItemForm itemForm) {
		return "item/new";
	}
	
	@PostMapping("create")
	public String create(ItemForm itemForm) {
		return "redirect:/item";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model, @ModelAttribute("itemForm") ItemForm itemForm) {
		return "item/edit";
	}
	
	@PostMapping("edit/{id}")
	public String update(@PathVariable("id") Integer id, @ModelAttribute("itemForm") ItemForm itemForm) {
		return "redirect:/item";
	}
	
	@PostMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		return "redirect:/item";
	}
}
