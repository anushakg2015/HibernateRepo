package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.Item;

public interface ItemDAO {
	public Item SaveItemByid(int mid,Item item);
	public Item getItemById(int id);
	public boolean deletetemById(int id);
	public Item updateItemById(int id);
	public List<Item> getAllItem();

}
